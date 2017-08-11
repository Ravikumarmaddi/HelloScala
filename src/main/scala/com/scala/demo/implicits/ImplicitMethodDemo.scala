package com.scala.demo.implicits

/**
  * Created by ravikumar.m on 17-10-2016.
  */
class ImplicitMethodDemo {

}

class Configuration1 {
  var isDevelopment = false
  var numberOfRetries = 10
  var port = 8080
  var url: String = null

  override def toString = isDevelopment + "," + numberOfRetries + "," + url + ":" + port
}

object ImplicitMethodDemo extends App {
  // this mimics reading strings from the user
  val userInput1 = "true"
  val userInput2 = "20"
  val userInput3 = "3000"
  val userInput4 = "http://www.google.com"
  var configuration = new Configuration1

  implicit def str2int(string: String): Int = Integer.valueOf(string).intValue

  implicit def str2bool(string: String): Boolean = string.toUpperCase.equals("TRUE")
  configuration.isDevelopment = userInput1
  configuration.numberOfRetries = userInput2
  configuration.port = userInput3
  configuration.url = userInput4

  println(configuration)
}
