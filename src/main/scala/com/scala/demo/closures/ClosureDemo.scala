package com.scala.demo.closures

/**
  * Created by ravikumar.m on 08-11-2016.
  */
object ClosureDemo {
  def main(args: Array[String]) {
    println( "multiplier(1) value = " +  multiplier(1) )
    println( "multiplier(2) value = " +  multiplier(2) )
  }
  var factor = 3
  val multiplier = (i:Int) => i * factor
}
