package com.github.robertberry.fpis

object Chapter10 {

  trait Monoid[A] {
    def op(a1: A, a2: A): A

    def zero: A
  }

  val stringMonoid = new Monoid[String] {
    def op(a1: String, a2: String): String = a1 + a2

    def zero: String = ""
  }

  def listMonoid[A] = new Monoid[List[A]] {
    def op(a1: List[A], a2: List[A]): List[A] = a1 ++ a2

    def zero: List[A] = Nil
  }

  /** Exercise 1
    *
    * Give Monoid instances for integer addition and multiplication as well as Boolean operators
    */
  val intAddition = new Monoid[Int] {
    def op(a1: Int, a2: Int): Int = a1 + a2

    def zero: Int = 0
  }

  val intMultiplication = new Monoid[Int] {
    def op(a1: Int, a2: Int): Int = a1 * a2

    def zero: Int = 1
  }

  val booleanOr = new Monoid[Boolean] {
    def op(a1: Boolean, a2: Boolean): Boolean = a1 || a2

    def zero: Boolean = false
  }

  val booleanAnd = new Monoid[Boolean] {
    def op(a1: Boolean, a2: Boolean): Boolean = a1 && a2

    def zero: Boolean = true
  }

  /** Exercise 2
    *
    * Give a Monoid instance for combining two Options
    */
  def firstOption[A] = new Monoid[Option[A]] {
    def op(a1: Option[A], a2: Option[A]): Option[A] = a1 orElse a2

    def zero: Option[A] = None
  }

  def endoMonoid[A] = new Monoid[A => A] {
    def op(a1: (A) => A, a2: (A) => A): (A) => A = a1 compose a2

    def zero: (A) => A = identity[A]
  }

  /** Exercise 5
    *
    * Write a Monoid instance for STring that inserts spaces between words unless they exist, and trims spaces off the
    * ends of the result
    */
  val trimMonoid = new Monoid[String] {
    def op(a1: String, a2: String): String = (a1.trim, a2.trim) match {
      case ("", x) => x
      case (x, "") => x
      case (x, y) => x + " " + y
    }

    def zero: String = ""
  }

  /** Exercise 6
    *
    * Implement concatenate, a function that folds a list with a Monoid
    */
  def concatenate[A](as: List[A])(implicit monoid: Monoid[A]): A = as.foldLeft(monoid.zero)(monoid.op)

  /** Exercise 7
    *
    * Implement foldMap
    */
  def foldMap[A,B](as: List[A], m: Monoid[B])(f: A => B): B = {
    as.foldLeft(m.zero)((b, a) => m.op(b, f(a)))
  }

  /** Exercise 8
    *
    * Implement foldLeft and foldRight in terms of foldMap
    */
  def foldLeft[A, B](as: List[A])(z: B)(f: (B, A) => B) = {
    foldMap(as, endoMonoid[B])({ a: A => (b: B) => f(b, a) })(z)
  }

  def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B = {
    foldMap(as, endoMonoid[() => B])({ a: A => (b: () => B) => () => f(a, b()) })(() => z)()
  }

  /** Exercise 9
    *
    * Implement a foldMap for IndexedSeq - it should do a balanced fold
    */
  def foldMapV[A, B](as: IndexedSeq[A], m: Monoid[B])(f: A => B): B = {
    if (as.length == 0) m.zero
    else if (as.length == 1) m.op(m.zero, f(as(0)))
    else {
      val (left, right) = as.splitAt(as.length / 2)
      m.op(foldMapV(left, m)(f), foldMapV(right, m)(f))
    }
  }

  /** Exercise 10
    *
    * Use foldMapV to detect whether a given IndexedSeq[Int] is ordered.
    *
    * You will need to come up with a creative Monoid.
    */
  sealed trait Range

  case object ZeroRange extends Range
  case object UnorderedRange extends Range
  case class OrderedRange(min: Int, max: Int) extends Range

  implicit def rangeMonoid = new Monoid[Range] {
    override def op(a1: Range, a2: Range): Range = (a1, a2) match {
      case (ZeroRange, a) => a
      case (a, ZeroRange) => a
      case (UnorderedRange, _) => UnorderedRange
      case (_, UnorderedRange) => UnorderedRange
      case (OrderedRange(minLeft, maxLeft), OrderedRange(minRight, maxRight)) =>
        if (maxLeft > minRight) {
          UnorderedRange
        } else {
          OrderedRange(minLeft, maxRight)
        }
    }

    override def zero: Range = ZeroRange
  }

  def isOrdered(xs: IndexedSeq[Int]) = foldMapV(xs, rangeMonoid)(x => OrderedRange(x, x)) match {
    case UnorderedRange => false
    case _ => true
  }

  /** Exercise 10 (In the latest version of the MEAP, this is now exercise 10 ... )
    *
    * Write a Monoid instance for WordCount and make sure that it meets the Monoid laws
    */

  object WordCount {
    def fromString(s: String): WordCount = {
      val words = s.split("\\s+").toList

      // Note: for some reason, when splitting a string such as ' hello world ' using the above, this actually
      // generates Array("", "hello", "world"), which seems kind of arbitrary given the trailing spaces don't
      // produce another word but the leaning ones do, but maybe I'm missing something. If the arithmetic below
      // looks strange, that's why.
      lazy val startsWithSpace = s.startsWith(" ")
      lazy val endsWithSpace = s.endsWith(" ")

      if (s.forall(_.isSpaceChar)) {
        Stub(s)
      } else if (startsWithSpace && endsWithSpace) {
        Part("", words.length - 1, "")
      } else if (startsWithSpace) {
        Part("", words.length - 2, words.last)
      } else if (endsWithSpace) {
        Part(words.head, words.length - 1, "")
      } else if (words.length == 1) {
        Stub(words.head)
      } else {
        Part(words.head, words.length - 2, words.last)
      }
    }
  }

  sealed trait WordCount

  case class Stub(chars: String) extends WordCount
  case class Part(leftStub: String, words: Int, rightStub: String) extends WordCount

  object NonEmptySpaceString {
    def unapply(s: String) = if (s.forall(_.isSpaceChar) && s.length > 0) Some(s) else None
  }

  var wordCountMonoid = new Monoid[WordCount] {
    override def op(a1: WordCount, a2: WordCount): WordCount = (a1, a2) match {
      case (Stub(leftStub), Stub(rightStub)) =>
        Stub(leftStub + rightStub)

      case (Stub(leftStub), Part("", wordCount, rightStub)) =>
        Part(leftStub, wordCount, rightStub)

      case (Part(leftStub, wordCount, ""), Stub(rightStub)) =>
        Part(leftStub, wordCount, rightStub)

      case (Stub(NonEmptySpaceString(_)), Part(_, wordCount, rightStub)) =>
        Part("", wordCount + 1, rightStub)

      case (Part(leftStub, wordCount, _), Stub(NonEmptySpaceString(_))) =>
        Part(leftStub, wordCount + 1, "")

      case (Stub(leftLeftStub), Part(leftRightStub, wordCount, rightStub)) =>
        Part(leftLeftStub + leftRightStub, wordCount, rightStub)

      case (Part(leftStub, wordCount, rightLeftStub), Stub(rightRightStub)) =>
        Part(leftStub, wordCount, rightLeftStub + rightRightStub)

      case (Part(leftStub, leftWordCount, centreLeftStub), Part(centreRightStub, rightWordCount, rightStub)) =>
        Part(
          leftStub,
          leftWordCount + rightWordCount + (if ((centreLeftStub + centreRightStub) == "") 0 else 1),
          rightStub
        )
    }

    override def zero: WordCount = Stub("")
  }

  /** Exercise 11
    *
    * Use the WordCount Monoid to implement a function that recursively splits a String then counts the words in the
    * String
    */
  def countWords(str: String, threshold: Int = 10) = {
    def iter(s: String): WordCount = {
      if (s.length > threshold) {
        val (left, right) = s.splitAt(s.length / 2)

        wordCountMonoid.op(WordCount.fromString(left), WordCount.fromString(right))
      } else {
        WordCount.fromString(s)
      }
    }

    def emptyStub(s: String) = s match {
      case "" => true
   //   case NonEmptySpaceString() => true
      case _ => false
    }

    iter(str) match {
      case Stub(s) if emptyStub(s) => 0
      case Stub(_) => 1
      case Part(leftStub, wordCount, rightStub) =>
        wordCount + (if (!emptyStub(leftStub)) 1 else 0) + (if (!emptyStub(rightStub)) 1 else 0)
    }
  }

  trait Foldable[F[_]] {
    def foldRight[A,B](as: F[A])(z: B)(f: (A, B) => B): B
    def foldLeft[A,B](as: F[A])(z: B)(f: (B, A) => B): B
    def foldMap[A,B](as: F[A])(f: A => B)(mb: Monoid[B]): B
    def concatenate[A](as: F[A])(m: Monoid[A]): A =
      foldLeft(as)(m.zero)(m.op)
  }

  /** Exercise 12
    *
    * Implement Foldable[List], Foldable[IndexedSeq], and Foldable[Stream].
    *
    * Remember that they can be implemented in terms of one another, but that that may not be the most efficient
    * implementation.
    */
  val listFoldable = new Foldable[List] {
    override def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)

    override def foldLeft[A, B](as: List[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)

    override def foldMap[A, B](as: List[A])(f: (A) => B)(mb: Monoid[B]): B =
      foldRight(as)(mb.zero) { (a, b) =>
        mb.op(b, f(a))
      }
  }

  val indexedSeqFoldable = new Foldable[IndexedSeq] {
    override def foldRight[A, B](as: IndexedSeq[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)

    override def foldLeft[A, B](as: IndexedSeq[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)

    override def foldMap[A, B](as: IndexedSeq[A])(f: (A) => B)(mb: Monoid[B]): B =
      foldLeft(as)(mb.zero) { (b, a) =>
        mb.op(b, f(a))
      }
  }

  val streamFoldable = new Foldable[Stream] {
    override def foldRight[A, B](as: Stream[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)

    override def foldLeft[A, B](as: Stream[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)

    override def foldMap[A, B](as: Stream[A])(f: (A) => B)(mb: Monoid[B]): B =
      foldLeft(as)(mb.zero) { (b, a) =>
        mb.op(b, f(a))
      }
  }

  /** Exercise 13
    *
    * Recall the binary tree data type from Chapter 3. Implement Foldable for it.
    */
  import Chapter3.{Tree, Leaf, Branch}

  def treeFoldRight[A, B](as: Tree[A])(z: B)(f: (A, B) => B): B = {
    as match {
      case Leaf(a) => f(a, z)
      case Branch(left, right) =>
        val rightResult = treeFoldRight(right)(z)(f)
        treeFoldRight(left)(rightResult)(f)
    }
  }

  def treeFoldLeft[A, B](as: Tree[A])(z: B)(f: (B, A) => B): B = {
    as match {
      case Leaf(a) => f(z, a)
      case Branch(left, right) =>
        val leftResult = treeFoldLeft(left)(z)(f)
        treeFoldLeft(right)(leftResult)(f)
    }
  }

  val treeFoldable = new Foldable[Tree] {
    override def foldRight[A, B](as: Tree[A])(z: B)(f: (A, B) => B): B =
      treeFoldRight(as)(z)(f)

    override def foldLeft[A, B](as: Tree[A])(z: B)(f: (B, A) => B): B =
      treeFoldLeft(as)(z)(f)

    override def foldMap[A, B](as: Tree[A])(f: (A) => B)(mb: Monoid[B]): B =
      treeFoldLeft(as)(mb.zero) { (b, a) =>
        mb.op(b, f(a))
      }
  }

  /** Flips parameters around in a binary function */
  def flip[A, B, C](f: (A, B) => C): (B, A) => C =
    (b: B, a: A) => f(a, b)

  /** Exercise 14
    *
    * Implement a Foldable Option instance
    */
  val optionFoldable = new Foldable[Option] {
    override def foldRight[A, B](as: Option[A])(z: B)(f: (A, B) => B): B =
      as map { a => f(a, z) } getOrElse z

    override def foldLeft[A, B](as: Option[A])(z: B)(f: (B, A) => B): B =
      foldRight(as)(z)(flip(f))

    override def foldMap[A, B](as: Option[A])(f: (A) => B)(mb: Monoid[B]): B =
      as.map(f).getOrElse(mb.zero)
  }

  /** Exercise 15
    *
    * Any Foldable structure can be turned into a List. Write this conversion in a generic way.
    */
  implicit class FoldableToListExtension[F[_]](foldable: Foldable[F]) {
    def toList[A](fa: F[A]): List[A] =
      foldable.foldRight(fa)(List.empty[A])(_ :: _)
  }

  /** Exercise 16
    *
    * Implement the product monoid function
    */
  def productMonoid[A, B](aMonoid: Monoid[A], bMonoid: Monoid[B]): Monoid[(A, B)] = new Monoid[(A, B)] {
    override def op(t1: (A, B), t2: (A, B)): (A, B) = {
      val (a1, b1) = t1
      val (a2, b2) = t2

      (aMonoid.op(a1, a2), bMonoid.op(b1, b2))
    }

    override def zero: (A, B) =
      (aMonoid.zero, bMonoid.zero)
  }

  /** Exercise 17
    *
    * Write a monoid instance for functions whose results are monoids
    */
  def functionMonoid[A, B](monoid: Monoid[B]): Monoid[A => B] = {
    new Monoid[A => B] {
      override def op(f1: (A) => B, f2: (A) => B): (A) => B =
        (a: A) => monoid.op(f1(a), f2(a))

      override def zero: (A) => B =
        (a: A) => monoid.zero
    }
  }

  /** Exercise 18
    *
    * ??? Instructions seem to be missing. Implement bag.
    */
  def mapMergeMonoid[K,V](V: Monoid[V]): Monoid[Map[K, V]] =
    new Monoid[Map[K, V]] {
      def zero = Map()
      def op(a: Map[K, V], b: Map[K, V]) =
        a.foldLeft(b) {
          case (m,(k,v)) => m + (k -> V.op(v, m.get(k) getOrElse V.zero))
        } }

  def bag[A](as: IndexedSeq[A]): Map[A, Int] = {
    indexedSeqFoldable.foldMap(as)(a => Map(a -> 1))(mapMergeMonoid(intAddition))
  }
}