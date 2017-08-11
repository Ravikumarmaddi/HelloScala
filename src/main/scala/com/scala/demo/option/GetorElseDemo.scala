package com.scala.demo.option

/**
  * Created by ravikumar on 29/11/16.
  */
object GetorElseDemo {
  def main(args: Array[String]) {
    val a:Option[Int] = Some(5)
    val b:Option[Int] = None

    println("a.getOrElse(0): " + a.getOrElse(0) )
    println("b.getOrElse(10): " + b.getOrElse(10) )

    println("a.isEmpty: " + a.isEmpty )
    println("b.isEmpty: " + b.isEmpty )
  }
}