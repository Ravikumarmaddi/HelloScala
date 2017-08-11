package com.scala.demo.seal

/**
  * Created by ravikumar.m on 16-10-2016.
  */
sealed abstract class LogMessage

case class StringMessage(message: String) extends LogMessage

case class ExceptionMessage(exception: Throwable) extends LogMessage

case class BothMessage(message: String, exception: Throwable) extends LogMessage

class Logger {
  def debug(l: LogMessage) = log(10, l)

  def log(level: Int, l: LogMessage): Unit = l match {
    case StringMessage(msg) => println(msg)
    case ExceptionMessage(exception: Error) => exception.printStackTrace
    case ExceptionMessage(ex) => println(ex.toString)
  }

  def info(l: LogMessage) = log(5, l)

  def error(l: LogMessage) = log(1, l)
}
