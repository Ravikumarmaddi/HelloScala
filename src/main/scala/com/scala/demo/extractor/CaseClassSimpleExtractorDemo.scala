package com.scala.demo.extractor

/**
  * Created by ravikumar on 20/11/16.
  */
object CaseClassSimpleExtractorDemo extends App{

//  A case class is a class with a lot of standard boilerplate code automatically included. One benefit of this is that Scala makes it easy to use extractors with case classes.

  case class Person(name: String, age: Int)  // Define the case class
  val p = Person("Paola", 42)  // Instantiate a value with the case class type

  val Person(n, a) = p  // Extract values n and a
  println(n + "   "   + a  )
  // n: String = Paola
  // a: Int = 42
}
