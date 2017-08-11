package com.scala.demo.functions

/**
  * Created by ravikumar on 17/12/16.
  */
object AndThenDemo extends App {
  val f = (i: Double) => math.Pi / 2 - i
  val cos = f andThen math.sin
  println(cos(1))
  println(cos(0.5))
}
