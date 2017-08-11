package com.scala.demo.functions

/**
  * Created by ravikumar.m on 27-10-2016.
  */
object HigherOrderFunctionsDemo extends App{

  def even(n: Int): Boolean = n % 2 == 0

  def negative(n: Int): Boolean = n < 0

  def isEmpty(s: String): Boolean = s == ""


  def notForInt(f: Int => Boolean): Int => Boolean = n => !f(n)

  def notForString(f: String => Boolean): String => Boolean = s => !f(s)

  var odd = notForInt(even)
  var positive = notForInt(negative)
  var notEmpty = notForString(isEmpty)

  println(odd(3)) //will yield true
  println(positive(-1)) //will yield false
  println(notEmpty("DKD"))

  //will yield true

  def small(n: Int, m: Int): Boolean = n > m

  def negative2(n: Int, m: Int): Boolean = (n + m) < 0

  def notForIntInt(f: (Int, Int) => Boolean): (Int, Int) => Boolean = (n, m) => !f(n, m)

  var big = notForIntInt(small)
  var positive2 = notForIntInt(negative2)

  println(big(20, 10))
  println(positive2(-20, 10))

  // Diffrent way
  def not[A](f: A => Boolean): A => Boolean = a => !f(a)

  odd = not(even)
  positive = not(negative)
  notEmpty = not(isEmpty)
}
