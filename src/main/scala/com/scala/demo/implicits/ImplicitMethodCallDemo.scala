package com.scala.demo.implicits

/**
  * Created by ravikumar on 10/3/17.
  */
object ImplicitMethodCallDemo extends App {
  val r = new Rational(2, 3)
  // println(2 * r)  // It won't work beacuse 2.*(r), here 2 is Int. But Int dont have '*' method.
  // So, you should implement implicit converter which will convert int to Rational implicitly.

  implicit def intToRational(x: Int) = new Rational(x)  // Note: It should be in where you are calling like below.

  println(2 * r)   // Now, It works.

}

class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def +(i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def -(i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def *(i: Int): Rational =
    new Rational(numer * i, denom)

  def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def /(i: Int): Rational =
    new Rational(numer, denom * i)

  override def toString = numer + "/" + denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

 // implicit def intToRational(x: Int) = new Rational(x)
}
