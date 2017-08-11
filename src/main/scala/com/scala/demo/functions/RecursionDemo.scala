package com.scala.demo.functions

/**
  * Created by ravikumar.m on 07-11-2016.
  */
object RecursionDemo {
  def main(args: Array[String]) {
    for (i <- 1 to 10)
      println( "Factorial of " + i + ": = " + factorial(i) )
  }

  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1
    else
      n * factorial(n - 1)
  }
}
