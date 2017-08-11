package com.demo.patterns

/**
  * Created by ravikumar on 16/11/16.
  */
object SeqPMDemo {

  def f(ints: Seq[Int]): String = ints match {
    case Seq() =>
      "The Seq is empty !"
    case Seq(first) =>
      s"The seq has exactly one element : $first"
    case Seq(first, second) =>
      s"The seq has exactly two elements : $first, $second"
    case  s @ Seq(_, _, _) =>
      s"s is a Seq of length three and looks like ${s}"  // Note individual elements are not bound to their own names.
    case _ =>
      "The seq has more than two elements"
  }

  def f2(ints: Seq[Int]): String = ints match {
    case Seq(first, second, tail @ _*) =>
      s"The seq has at least two elements : $first, $second. The rest of the Seq is $tail"
    case Seq(first, tail @ _*) =>
      s"The seq has at least one element : $first. The rest of the Seq is $tail"
    // alternative syntax
    // here of course this one will never match since it checks
    // for the same thing as the one above
    case first +: tail =>
      s"The seq has at least one element : $first. The rest of the Seq is $tail"
    case _ =>
      "The seq didn't match any of the above, so it must be empty"
  }

  def main(args: Array[String]): Unit = {
    println(f(Seq()))
    println(f(Seq(1)))
    println(f(Seq(1, 2)))
    println(f(Seq(1, 2, 3)))
    println(f(Seq(1, 2, 3, 4)))
  }

}
