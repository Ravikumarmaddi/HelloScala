package com.scala.demo.pattern

/**
  * Created by ravikumar.m on 09-11-2016.
  */
object AnyPMDemo {
  def main(args: Array[String]) {
    var v:Int = 10
    println(matchTest("two"))
    println(matchTest("test"))
    println(matchTest(1))
    println(matchTest(v))
  }
  // Note: Only one case will execute, even multiple matches applical to giving value.
  // that to first one only will call.
  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case _ : Int => "scala.Int any"    // type check
    case y : Int => "scala.Int y"    // type check
    case _ => "many"
  }
}
