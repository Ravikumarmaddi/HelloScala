package com.scala.demo.extractor

/**
  * Created by ravikumar on 20/11/16.
  */
object                                                                                                                                                               CaseClassPartialExtractorDemo extends App{

//  A case class is a class with a lot of standard boilerplate code automatically included. One benefit of this is that Scala makes it easy to use extractors with case classes.

  case class Person(name: String, age: Int)  // Define the case class
  val p = Person("Paola", 42)  // Instantiate a value with the case class type

  val p2 = Person("Angela", 1337)

  val List(Person(n1, a1), Person(_, a2)) = List(p, p2)

  println("n1:"+n1+"\na1:"++"\nn2:"+a2)

  // n1: String = Paola
  // a1: Int = 42
  // a2: Int = 1337
//  Here we see two important things:
//
//    Extraction can happen at 'deep' levels: properties of nested objects can be extracted.
//  Not all elements need to be extracted. The wildcard _ character indicates that that particular value can be anything, and is ignored. No val is created.
}
