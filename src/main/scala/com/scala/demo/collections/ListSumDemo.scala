package com.scala.demo.collections

/**
  * Created by ravikumar on 17/12/16.
  */
sealed trait List1[+A]

case object Nil extends List1[Nothing]

case class Cons[+A](head: A, tail: List1[A]) extends List1[A]

object List1 {
  def sum(ints: List1[Int]): Int = ints match {
    case Nil => 0
    case Cons(head, tail) => head + sum(tail)
  }

  def product(ints: List1[Double]): Double = ints match {
    case Nil => 1
    case Cons(x, xt) => x * product(xt)
  }

  /*def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
    /*as match {
      /*case Nil => z
      case C*/ons(x, xs) => f(x, foldRight(xs, z)(f))
    }*/
*/
  /*def sum2(ns: List[Int]) =
    //foldRight(ns, 0)((x, y) => x + y)
  foldRight(ns, 0)(_ + _)

  def product2(ns: List[Double]) =
    foldRight(ns, 1.0)(_ * _)*/

  /* def setHead(head: Int, ints: List[Int]): List[Int] = ints match {
     case Nil => Nil
     case a@List[Int] if a.length > 1 => List (head)

   }*/
}
