package com.demo.patterns

/**
  * Created by ravikumar on 16/11/16.
  */
object ExpressionPMDemo {

  def checkSign(x: Int): String = {
    x match {
      case a if a < 0 => s"$a is a negative number"
      case b if b > 0 => s"$b is a positive number"
      case c => s"$c neither positive nor negative"
    }
  }

  def doSomething(i: Int) = println( "Something")
  def doSomethingIfNoneOrOdd = println( "Something odd or none")
  def doSomethingIfNone = println( "Something none")

  // NOTE: It will throw exception if i is odd number. so you have to write like below.
  def f1(x: Option[Int]) = x match {
    case Some(i) if i % 2 == 0 => doSomething(i)
    case None    => doSomethingIfNone
  }

  def f2(x: Option[Int]) = x match {
    case Some(i) if i % 2 == 0 => doSomething(i)
    case _ => doSomethingIfNoneOrOdd
  }

  def main(args: Array[String]): Unit = {

  }

}
