package com.scala.demo.functions

/**
  * Created by ravikumar.m on 06-11-2016.
  */
object CallByNameDemo {
  def main(args: Array[String]) {
    println (System.nanoTime);
    delayed(time());
    var i : Int =10
    print(3+i);
  }

  def time() = {
    println("Getting time in nano seconds")
    //println (System.nanoTime);
    System.nanoTime
  }
  def delayed( t: => Long ) = {
    println("In delayed method")
    println("Param: " + t)
  }
  def print(x: => Int): Unit =
  {
    println (x * x)
  }
}