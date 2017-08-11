package com.demo.patterns

/**
  * Created by ravikumar on 16/11/16.
  */

object Main {

  def f(x: Int): String = x match {
    case 1 => "One"
    case 2 => "Two"
    case _ => "Unknown!"
  }

  def main(args: Array[String]): Unit = {
    println(f(2))
    println(f(3))
  }

}

