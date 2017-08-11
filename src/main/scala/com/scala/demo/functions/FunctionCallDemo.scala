package com.scala.demo.functions

/**
  * Created by ravikumar on 1/12/16.
  */
object FunctionCallDemo extends App{

  var s:String = "Hello, world!"

  println( s toLowerCase)  // you can use space instead of '.'

  printIt _

  def printIt(x:AnyRef) = println(""+ x)
}
