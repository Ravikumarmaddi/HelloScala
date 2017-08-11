package com.scala.demo.patternmatching

/**
  * Created by ravikumar on 16/11/16.
  */
object OptionPMDemo extends App{
  def f(x: Option[Int]) = x match {
    case Some(i) => doSomething(i)
    case None    => doSomethingIfNone
  }
  // This is functionally equivalent to using fold, or map/getOrElse:

  def g(x: Option[Int]) = x.fold(doSomethingIfNone)(doSomething)
  def h(x: Option[Int]) = x.map(doSomething).getOrElse(doSomethingIfNone)

  def doSomething(i: Int) = println( "Something")
  def doSomethingIfNone = println( "Something none")

}
