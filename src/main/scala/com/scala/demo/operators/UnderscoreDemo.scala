package com.scala.demo.operators


// imports all the classes in the package matching
import scala.collection.generic.SeqFactory
import scala.util.matching._
// imports all the members of the object Fun. (static import in java)
import scala.BigInt._
// imports all the members of the object Fun but renames Foo to Bar
//import com.test.Fun.{ Foo => Bar , _ }
// imports all the members except Foo. To exclude a member rename it to _
//import com.test.Fun.{ Foo => _ , _ }

// in curringin we use _ to specify there parameters remain

object UnderscoreDemo extends App {

  def add(a: Int)(b: Int): Int = a + b

  val parAdd = add(10)_
  println( parAdd(20))
}