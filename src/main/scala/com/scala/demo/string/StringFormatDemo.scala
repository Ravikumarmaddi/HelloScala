package com.scala.demo.string

/**
  * Created by ravikumar.m on 08-11-2016.
  */
object StringFormatDemo {
  def main(args: Array[String]) {
    var floatVar = 12.456
    var intVar = 2000
    var stringVar = "Hello, Scala!"

    var fs = printf("The value of the float variable is " +
      "%f, while the value of the integer " +
      "variable is %d, and the string " +
      "is %s", floatVar, intVar, stringVar)
    println(fs)


    val height = 1.9d
    val name = "James"
    println(f"$name%s is $height%2.2f meters tall") //James is 1.90 meters tall
  }

  private def formatAbs(i:Int):String ={
    var messsage = "%d is the absulte of %d"
   // messsage.format(abs(i),i)
    ""
  }
}
