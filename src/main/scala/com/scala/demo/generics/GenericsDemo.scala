package com.scala.demo.generics

/**
  * Created by ravikumar.m on 16-10-2016.
  */
class Configuration[T](val key: Symbol, val value: T) {
  override def toString = key.toString + "=" + value.toString
}

/** This the class our configuration system is configuring.
  * It makes some connection to a URL. */
class Connector(desc: String, url: String, numAttempts: Int, failOnError: Boolean) {
  def get = desc + "\n" + url + "\n" + numAttempts + "\n" + failOnError // gets the url and returns it, e.g.
}

object GenericDemo extends App {

  val desc = new Configuration[String]('desc, "Our demo")
  val url = new Configuration[String]('url, "http://www.google.com")
  val attempts = new Configuration[Int]('attempts, 43)
  val failOnError = new Configuration[Boolean]('fail, false)

  new Connector(desc.value, url.value, attempts.value, failOnError.value)
  var a = 'ravi
  println(a)
}