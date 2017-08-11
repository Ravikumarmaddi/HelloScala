package com.github.robertberry.fpis

import com.github.robertberry.fpis.Chapter11.{Monad, Functor}
import com.github.robertberry.fpis.Chapter6.State
import State._

object Chapter12 {
  trait Applicative[F[_]] extends Functor[F] {
    // primitive combinators
    def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C]
    def unit[A](a: => A): F[A]
    // derived combinators
    def map[A, B](fa: F[A])(f: A => B): F[B] =
      map2(fa, unit(()))((a, _) => f(a))
    def traverse[A,B](as: List[A])(f: A => F[B]): F[List[B]] =
      as.foldRight(unit(List[B]()))((a, fbs) => map2(f(a), fbs)(_ :: _))
  }

  /** Exercise 1
    *
    * Transplant the implementations of as many combinators as you can from Monad to Applicative, using only map2
    * and unit, or methods implemented in terms of them.
    */
  implicit class ApplicativeExtensions1[F[_]](applicative: Applicative[F]) {
    def sequence[A](fas: List[F[A]]): F[List[A]] = applicative.traverse(fas)(identity)

    def replicateM[A](n: Int, fa: F[A]): F[List[A]] = sequence(List.fill(n)(fa))

    def product[A, B](fa: F[A], fb: F[B]): F[(A,B)] =
      applicative.map2(fa, fb)(_ -> _)
  }

  /** Exercise 2
    *
    * Implement apply, then map and map2 in terms of it.
    */
  implicit class ApplicativeExtensions2[F[_]](applicative: Applicative[F]) {
    def apply[A, B](fab: F[A => B])(fa: F[A]): F[B] =
      applicative.map2(fab, fa)(_(_))

    def map[A, B](fa: F[A])(f: A => B): F[B] =
      apply(applicative.unit[A => B](f))(fa)

    def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] =
      apply(apply(applicative.unit[A => B => C]({ a: A => { b: B => f(a, b) } }))(fa))(fb)
  }

  /** Exercise 3
    *
    * Implement map3 and map4 using only unit, apply, and the curried method available on functions
    */
  implicit class ApplicativeExtensions3[F[_]](ap: Applicative[F]) {
    def map3[A, B, C, D](fa: F[A], fb: F[B], fc: F[C])(f: (A, B, C) => D): F[D] = {
      ap.apply(ap.apply(ap.apply(ap.unit[A => B => C => D](f.curried))(fa))(fb))(fc)
    }

    def map4[A, B, C, D, E](fa: F[A], fb: F[B], fc: F[C], fd: F[D])(f: (A, B, C, D) => E): F[E] = {
      ap.apply(ap.apply(ap.apply(ap.apply(ap.unit[A => B => C => D => E](f.curried))(fa))(fb))(fc))(fd)
    }
  }

  /** Exercise 4
    *
    * What is the meaning of streamApplicative.sequence?
    *
    * Given a list of streams, returns a stream of lists of elements from each stream (so the first thing emitted would
    * be a list of the heads of each stream, then the next would be a list of the second items from each stream, etc.),
    * until one stream ends.
    */

  /** Ignoring exercise 5 as I've done it previously (implement a Monad for Either) */

  /** Exercise 6
    *
    * Write an Applicative instance for Validation that accumulates errors in Failure.
    */
  sealed trait Validation[+E, +A]

  case class Failure[E](head: E, tail: Vector[E] = Vector())
    extends Validation[E, Nothing]

  case class Success[A](a: A) extends Validation[Nothing, A]

  def validationApplicative[E] = new Applicative[({type f[A] = Validation[E, A]})#f] {
    override def map2[A, B, C](fa: Validation[E, A], fb: Validation[E, B])(f: (A, B) => C): Validation[E, C] =
      (fa, fb) match {
        case (Success(a), Success(b)) => Success(f(a, b))
        case (f @ Failure(_, _), Success(_)) => f
        case (Success(_), f @ Failure(_, _)) => f
        case (Failure(leftH, leftT), Failure(rightH, rightT)) =>
          Failure(leftH, (leftT :+ rightH) ++ rightT)
      }

    override def unit[A](a: => A): Validation[E, A] = Success(a)
  }

  /** Exercise 7
    *
    * Prove that all monads are applicative functors by showing that if the monad laws hold, the Monad implementations
    * of map and map2 satisfy the applicative laws.
    *
    * -- TODO
    */

  /** Exercise 8
    *
    * Implement product
    */
  implicit class ApplicativeExtensions4[F[_]](F: Applicative[F]) {
    def product[G[_]](G: Applicative[G]): Applicative[({type f[x] = (F[x], G[x])})#f] =
      new Applicative[({type f[x] = (F[x], G[x])})#f] {
        override def map2[A, B, C](fga: (F[A], G[A]), fgb: (F[B], G[B]))(f: (A, B) => C): (F[C], G[C]) = {
          val (fa, ga) = fga
          val (fb, gb) = fgb

          (F.map2(fa, fb)(f), G.map2(ga, gb)(f))
        }

        override def unit[A](a: => A): (F[A], G[A]) = (F.unit(a), G.unit(a))
      }
  }

  /** Exercise 9
    *
    * Implement compose
    */
  implicit class ApplicativeExtensions5[F[_]](F: Applicative[F]) {
    def compose[G[_]](G: Applicative[G]): Applicative[({type f[x] = F[G[x]]})#f] = new Applicative[({type f[x] = F[G[x]]})#f] {
      override def map2[A, B, C](fa: F[G[A]], fb: F[G[B]])(f: (A, B) => C): F[G[C]] =
        F.map2(fa, fb) { (ga, gb) =>
          G.map2(ga, gb)(f)
        }

      override def unit[A](a: => A): F[G[A]] = F.unit(G.unit(a))
    }
  }

  /** Exercise 10
    *
    * Prove that this composite applicative functor meets the applicative laws. This is an extremely challenging exercise.
    *
    * --- TODO
    */

  /** Exercise 11
    *
    * Try to implement compose on Monad. It's not possible but it's constructive to figure out why.
    */

  /*
  import Chapter11.Monad

  implicit class MonadExtensions1[F[_]](F: Monad[F]) {
    def compose[G[_]](G: Monad[G]): Monad[({type f[x] = F[G[x]]})#f] = new Monad[({type f[x] = F[G[x]]})#f] {
      override def unit[A](a: => A): F[G[A]] = F.unit(G.unit(a))

      override def flatMap[A, B](ma: F[G[A]])(f: (A) => F[G[B]]): F[G[B]] = {
        F.flatMap(ma) { ga =>
          G.flatMap(ga) { a =>
            f(a)

            ???
          }
        }
      }
    }
  }
  */

  /** Exercise 12
    *
    * On the Applicative trait, implement sequence over a Map rather than a List
    */
  implicit class ApplicativeExtensions6[F[_]](F: Applicative[F]) {
    def sequenceMap[K,V](ofa: Map[K,F[V]]): F[Map[K,V]] = ofa.foldLeft(F.unit(Map.empty[K, V])) {
      case (facc, (k, fv)) =>
        F.map2(facc, fv) { (acc, v) =>
          acc + (k -> v)
        }
    }
  }

  trait Traverse[F[_]] {
    def traverse[G[_]: Applicative, A, B](fa: F[A])(f: A => G[B]): G[F[B]]

    def sequence[G[_]: Applicative, A](fga: F[G[A]]): G[F[A]] =
      traverse(fga)(identity)
  }

  /** Exercise 13
    *
    * Write Traverse instances for List, Option, Map and Tree
    */
  implicit val listTraverse = new Traverse[List] {
    override def traverse[G[_]: Applicative, A, B](fa: List[A])(f: (A) => G[B]): G[List[B]] =
      implicitly[Applicative[G]].sequence(fa.map(f))
  }

  val optionTraverse = new Traverse[Option] {
    override def traverse[G[_]: Applicative, A, B](fa: Option[A])(f: (A) => G[B]): G[Option[B]] = {
      val F = implicitly[Applicative[G]]
      fa.map(a => F.map(f(a))(Option.apply[B])) getOrElse F.unit(Option.empty[B])
    }
  }

  def mapTraverse[K] = new Traverse[({type h[V] = Map[K, V]})#h] {
    override def traverse[G[_]: Applicative, A, B](fa: Map[K, A])(f: (A) => G[B]): G[Map[K, B]] = {
      val F = implicitly[Applicative[G]]

      fa.foldLeft(F.unit(Map.empty[K, B])) { case (facc, (k, v)) =>
        F.map2(facc, f(v)) { (acc, v) =>
          acc + (k -> v)
        }
      }
    }
  }

  import com.github.robertberry.fpis.Chapter3.{Tree, Leaf, Branch, foldT}

  val treeTraverse = new Traverse[Tree] {
    override def traverse[G[_]: Applicative, A, B](fa: Tree[A])(f: (A) => G[B]): G[Tree[B]] = {
      val F = implicitly[Applicative[G]]

      foldT[A, G[Tree[B]]](fa)(a => F.map(f(a))(Leaf.apply)) { (fb1, fb2) =>
        F.map2(fb1, fb2) { (b1, b2) =>
          Branch(b1, b2)
        }
      }
    }
  }

  /** Exercise 14
    *
    * Implement map in terms of traverse as a method on Traverse[F].
    */
  type Id[A] = A

  implicit val identityApplicative = new Applicative[Id] {
    override def map2[A, B, C](fa: Id[A], fb: Id[B])(f: (A, B) => C): Id[C] = f(fa, fb)

    override def unit[A](a: => A): Id[A] = a
  }

  implicit class TraverseExtensions1[F[_]](traverse: Traverse[F]) extends Functor[F] {
    def map[A, B](fa: F[A])(f: A => B): F[B] =
      traverse.traverse[Id, A, B](fa)(f)
  }

  import Chapter10.Monoid

  type Const[M, B] = M

  implicit def monoidApplicative[M](M: Monoid[M]) =
    new Applicative[({ type f[x] = Const[M, x] })#f] {
      def unit[A](a: => A): M = M.zero

      def map2[A,B,C](m1: M, m2: M)(f: (A,B) => C): M = M.op(m1,m2)
    }

  /** Exercise 15
    *
    * Can you think of a Foldable that isn't a Functor?
    */
  import Chapter10.{Foldable, flip}

  type Endofunction[A] = A => A

  case class WhutIsThis[A](f: Endofunction[A], a: A)

  val whutIsThisFoldable = new Foldable[WhutIsThis] {
    override def foldRight[A, B](as: WhutIsThis[A])(z: B)(f: (A, B) => B): B = {
      val WhutIsThis(g, a) = as
      f(g(a), z)
    }

    override def foldLeft[A, B](as: WhutIsThis[A])(z: B)(f: (B, A) => B): B = foldRight(as)(z)(flip(f))

    override def foldMap[A, B](as: WhutIsThis[A])(f: (A) => B)(mb: Monoid[B]): B = foldRight(as)(mb.zero) { (whut, acc) =>
      mb.op(f(whut), acc)
    }
  }

  import Chapter11.stateMonad

  implicit class TraverseExtensions2[F[_]](traverse: Traverse[F]) {
    def traverseS[S, A, B](fa: F[A])(f: A => State[S, B]): State[S, F[B]] =
      traverse.traverse[({type f[x] = State[S,x]})#f,A,B](fa)(f)(stateMonad)

    def mapAccum[S, A, B](fa: F[A], s: S)(f: (A, S) => (B, S)): (F[B], S) = traverseS(fa)({ (a: A) =>
      get[S] flatMap { s1: S =>
        val (b, s2) = f(a, s1)
        set[S](s2) map { _: Unit =>
          b
        }
      }
    }).run(s)

    def toList[A](fa: F[A]): List[A] =
      mapAccum(fa, List[A]())((a, s) => ((), a :: s))._2.reverse
  }

  /** Exercise 16
    *
    * Write reverse for a traversable functor
    */
  implicit class TraverseExtensions3[F[_]](traverse: Traverse[F]) {
    def reverse[A](fa: F[A]): F[A] = {
      val as = traverse.mapAccum(fa, List.empty[A])((a, s) => ((), a :: s))._2
      traverse.mapAccum(fa, as) {
        case (a, h :: t) => (h, t)
        case (_, Nil) => sys.error("Traverse does not maintain shape")
      }._1
    }
  }

  /** Exercise 17
    *
    * Use mapAccum to give a default implementation of foldLeft for the Traverse trait.
    */
  implicit class TraverseExtensions4[F[_]](traverse: Traverse[F]) {
    def foldLeft[A, B](fa: F[A])(s: B)(f: (B, A) => B): B = {
      traverse.mapAccum(fa, s) { (a, b) =>
        ((), f(b, a))
      }._2
    }
  }

  /** Exercise 18
    *
    * Use applicative functor products to write the fusion of two traversals. This function will, given two functions f
    * and g, traverse fa a single time, collecting the results of both functions at once.
    */
  implicit class TraverseExtensions5[F[_]](traverse: Traverse[F]) {
    def fuse[G[_], H[_], A, B](fa: F[A])(f: A => G[B], g: A => H[B])(G: Applicative[G], H: Applicative[H]): (G[F[B]], H[F[B]]) = {
      traverse.traverse[({ type f[Y] = (G[Y], H[Y]) })#f, A, B](fa)({ a =>
        f(a) -> g(a)
      })(G.product(H))
    }
  }

  /** Exercise 19
    *
    * Implement the composition of two Traverse instances.
    */
  implicit class TraverseExtensions6[F[_]](M: Traverse[F]) {
    def compose[L[_]](implicit N: Traverse[L]) = new Traverse[({type f[x] = F[L[x]]})#f] {
      override def traverse[G[_]: Applicative, A, B](fa: F[L[A]])(f: (A) => G[B]): G[F[L[B]]] = {
        M.traverse(fa) { la =>
          N.traverse(la) { a =>
            f(a)
          }
        }
      }
    }
  }

  /** Exercise 20
    *
    * Implement the composition of two monads where one of them is traversable.
    */
  /*
  implicit class TraverseExtensions7[M[_]](tm: Traverse[M]) {
    def composeM[F[_],G[_]](F: Monad[F], G: Monad[G], T: Traverse[G]) = new Monad[({type f[x] = F[G[x]]})#f] {
      override def unit[A](a: => A): F[G[A]] = F.unit(G.unit(a))

      override def flatMap[A, B](ma: F[G[A]])(f: (A) => F[G[B]]): F[G[B]] = F.flatMap(ma) { ga =>
        F.map(T.traverse(ga)(f)) { gga =>
          G.flatMap(gga)(identity)
        }
      }
    }
  }
 
  */

  
}
