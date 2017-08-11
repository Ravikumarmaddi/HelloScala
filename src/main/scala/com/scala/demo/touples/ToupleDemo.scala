package com.scala.demo.touples

object ToupleDemo extends App {

  example4

  // Example 1: Tuple as return type
  def example1() {
    def getName(name: String): (String, String) = {
      (name, name)
    }

    println(getName("ravi")._1)
    println(getName("ravi")._2)
  }

  // Example 2: Tuple variables
  def example2() {
    val getInfo = (1, "rin", 25.50) // you can specify def/var also instead of val.

    // Tuple full retrival
    val (num, name, price) = getInfo

    println(num + "   " + name + "   " + price)
    println(getInfo.toString())  // you can print like this also.

    // Tuple partial retrival
    val (num1, name1, _) = getInfo
    println(num + "   " + name)
    val (_, name2, _) = getInfo
    println(name)
  }

  // Example 3: Diffrent style tuple
  def example3() {
    val a = 1 -> "ravi"
    println(a.getClass)
    println(a._1 + "  " + a._2)
  }

  // Example 4: Print tuple
  def example4() {
    val a = ("aaa","bbb","ccc","ddd")
    a.productIterator.foreach(println _)
    println(a.getClass)
  }

  // Example 5: swap tuple
  def example5() {
    val a = ("aaa","bbb")  // Tuple2 only have swap method.
    println(a.swap)
  }
}