package com.scala.demo.extractor

/**
  * Created by ravikumar on 20/11/16.
  */
object InfixNotationExtractorDemo extends App {

  //  If a case class has exactly two values, its extractor can be used in infix notation.

  case class Pair(a: String, b: String)

  val p: Pair = Pair("hello", "world")
  val x Pair y = p

  //x: String = hello
  //y: String = world
  //  Any extractor that returns a 2-tuple can work this way.

  object Foo {
    def unapply(s: String): Option[(Int, Int)] = Some((s.length, 5))
  }

  val a Foo b = "hello world!"
  //a: Int = 12
  //b: Int = 5
}
