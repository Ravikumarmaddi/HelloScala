package com.scala.demo.collections

/**
  * Created by ravikumar on 18/12/16.
  * Another useful container object is the tuple. Like lists, tuples are immutable,
  * but unlike lists, tuples can contain different types of elements. Whereas a
  * list might be a List[Int] or a List[String] , a tuple could contain both
  * an integer and a string at the same time. Tuples are very useful, for example,
  * if you need to return multiple objects from a method. Whereas in Java you
  * would often create a JavaBean-like class to hold the multiple return values,
  * in Scala you can simply return a tuple. And it is simple: to instantiate a new
  * tuple that holds some objects, just place the objects in parentheses, separated
  * by commas. Once you have a tuple instantiated, you can access its elements
  * individually with a dot, underscore, and the one-based index of the element.
  */
object TupleDemo extends App {
  def demo1() {
    val t = ("Ravi", 36)
    println(t._1)
    println(t._2)
    println(t match { case (a, b) => b })
  }

  /**
    * The actual type of a tuple depends on the number of elements it contains
and the types of those elements. Thus, the type of (99, "Luftballons")
is Tuple2[Int, String] . The type of ('u', 'r', "the", 1, 4, "me") is
Tuple6[Char, Char, String, Int, Int, String] .
    */
  def tupleDeme(): Unit ={

  }
}
