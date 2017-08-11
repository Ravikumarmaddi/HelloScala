package com.scala.demo.functions

/**
  * Created by ravikumar on 7/3/17.
  */
object FunctionReturnDemo extends App{
  def f(): Unit = "this String gets lost"
  def g() { "this String gets lost too" }
  def h() = { "this String gets returned!" }
  println(f())
  println(g())
  println(h())

}
