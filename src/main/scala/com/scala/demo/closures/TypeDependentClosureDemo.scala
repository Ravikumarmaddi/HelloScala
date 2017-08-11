package com.scala.demo.closures

/**
  * Created by ravikumar.m on 17-10-2016.
  */

class Logger(level: Int) {
  def debug(message: => String) = log(10, message)

  def error(message: => String) = log(1, message)

  def log(logLevel: Int, message: => String) =
    if (level >= logLevel) println(message)

  def javaDebug(message: String) = if (level >= 10) println(message)
}

object TypeDependentClosureDemo extends App {
  val messageType = "test debug message"
  var logger = new Logger(1)

  logger.debug("This is a simple debug message" + breadcrumb)

  var complex = "complicated"

  // this prints out a value when it's called
  // and how we can know when an expression containing
  // it was evaluated
  def breadcrumb: String = {
    println("BREADCRUMB")
    "..."
  }

  logger.debug("This is a "
    + complex + " debug "
    + messageType + breadcrumb)

  complex = "mucho complicated"
  logger.javaDebug("This is a "
    + complex + " debug "
    + messageType + breadcrumb)
  logger.error("RED ALERT" + breadcrumb)
}
