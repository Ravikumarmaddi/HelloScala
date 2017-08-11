package com.scala.demo.namedparams

/**
  * Created by ravikumar.m on 17-10-2016.
  */
object NamedParamsDemo extends App {
  def printName(first: String, last: String) = println(first + " " + last)
  printName("Dave", "Copeland")
  // Prints "Dave Copeland"
  printName(first = "Dave", last = "Copeland")
  // Prints "Dave Copeland"
  printName(last = "Copeland", first = "Dave")
  // Prints "Dave Copeland"
}
