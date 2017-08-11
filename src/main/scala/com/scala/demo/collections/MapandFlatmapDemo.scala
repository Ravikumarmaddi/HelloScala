package com.scala.demo.collections

/**
  * Created by ravikumar.m on 04-11-2016.
  * Note:
  *   ON STRING:
  *     The reason for this behavior is that, in order to apply "map" to a String, Scala treats the string as a sequence of chars (IndexedSeq[String]). This is what you get as a result of the map invocation, where for each element of said sequence, the operation is applied. Since Scala treated the string as a sequence to apply map, that is what mapreturns.
  * flatMap then simply invokes flatten on that sequence afterwards, which then "converts" it back to a String
  *   ON LIST:
  *     map apply on every element.
  *     flatmap converts the list into single sequence of characters and apply.
  */
object MapandFlatmapDemo extends App {
  // ON STRINGS
  val s = "Hello World"

  s.flatMap(c => ("." + c)) // prepend each element with a period
  //res5: String = .H.e.l.l.o. .W.o.r.l.d
  //Then, I was curious why Mr. Odersky didn't use a map here. But, when I tried map, I got a different result than I expected.

  s.map(c => ("." + c))
  //res8: scala.collection.immutable.IndexedSeq[String] = Vector(.H, .e, .l, .l, .o,
  //". ", .W, .o, .r, .l,

  val sList = s.toList
  //sList: List[Char] = List(H, e, l, l, o,  , W, o, r, l, d)

  sList.map(c => "." + c)
  //res9: List[String] = List(.H, .e, .l, .l, .o, ". ", .W, .o, .r, .l, .d)

  // ON LIST
  val fruits = Seq("apple", "banana", "orange")
  //fruits: Seq[java.lang.String] = List(apple, banana, orange)

  fruits.map(_.toUpperCase)
  //res0: Seq[java.lang.String] = List(APPLE, BANANA, ORANGE)

  fruits.flatMap(_.toUpperCase)
  //res1: Seq[Char] = List(A, P, P, L, E, B, A, N, A, N, A, O, R, A, N, G, E)
}
