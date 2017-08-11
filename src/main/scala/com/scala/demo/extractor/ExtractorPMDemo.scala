package com.scala.demo.extractor

/**
  * Created by ravikumar.m on 09-11-2016.
  */
object ExtractorPMDemo {
  def main(args: Array[String]) {
    val x = ExtractorPMDemo(5)
    println(x)

    x match {
      case ExtractorPMDemo(num) => println(x+" is bigger two times than "+num)

      //unapply is invoked
      case _ => println("i cannot calculate")
    }
  }
  def apply(x: Int) = x*2
  def unapply(z: Int): Option[Int] = if (z%2==0) Some(z/2) else None
}
