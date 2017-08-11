package com.demo.patterns

/**
  * Created by ravikumar on 16/11/16.
  */
object RegExPMDemo {

  def main(args: Array[String]): Unit = {
    val emailRegex = "(.+)@(.+)\\.(.+)".r
    "ravi.maddi@gmail.com" match {
      case emailRegex(userName, domain, topDomain) => println(s"Hi $userName from $domain")
      case _ => println(s"This is not a valid email.")
    }
  }

}
