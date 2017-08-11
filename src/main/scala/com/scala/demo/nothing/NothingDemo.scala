package com.scala.demo.nothing

object NothingDemo {
  def main(args: Array[String]): Unit = {
    //    val empty2: List[Nothing] = Nothing
    error("sss")
  }

  def error(msg: String) = throw new Error(msg)
}