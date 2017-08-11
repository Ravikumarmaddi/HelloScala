package com.scala.demo.functions

/**
  * Created by ravikumar.m on 07-11-2016.
  */

object NestedFunctionsDemo {
  def main(args: Array[String]) {
    println( factorial(0) )
    println( factorial(1) )
    println( factorial(2) )
    println( factorial(3) )
  }

  def factorial(i: Int): Int = {
    def fact(i: Int, accumulator: Int): Int = {
      if (i <= 1)
        accumulator
      else
        fact(i - 1, i * accumulator)
    }
    fact(i, 1)
  }
  def print(): Unit ={
    //fact(1,1)
  }
}
