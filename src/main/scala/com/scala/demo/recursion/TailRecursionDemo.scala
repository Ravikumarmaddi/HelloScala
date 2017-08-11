package com.scala.demo.recursion

/**
  * Created by ravikumar on 30/11/16.
  */
object TailRecursionDemo extends App {
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)

  //  1. Write a function to sum all integers between two given numbers a and b:
  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b)

  //  2. Write a function to sum the squares of all integers between two given numbers a and b:
  def square(x: Int): Int = x * x

  def sumSquares(a: Int, b: Int): Int =
    if (a > b) 0 else square(a) + sumSquares(a + 1, b)

  //  3. Write a function to sum the powers 2n of all integers n between two given numbers a and b:
  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)

  def sumPowersOfTwo(a: Int, b: Int): Int =
    if (a > b) 0 else powerOfTwo(a) + sumPowersOfTwo(a + 1, b)
}
