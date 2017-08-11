package com.scala.demo.extractor

/**
  * Created by ravikumar on 20/11/16.
  */
object RegexExtractorDemo extends App {
  //  A regular expression with grouped parts can be used as an extractor:

  val address = """(.+):(\d+)""".r

  val address(host, port) = "some.domain.org:8080"
  println(s"Host  :$host \nPort  : $port")

  // It will throw exception.
  val address(host1, port1) = "something not a host and port"
  println(s"Host  :$host1 \nPort  : $port1")

}
