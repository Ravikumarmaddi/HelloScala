package com.scala.demo.exception

import java.sql.SQLException

/**
  * Created by ravikumar.m on 16-10-2016.
  */

class ExceptionDemo {
  def doit = {
    try {
      //somethingThatThrowsExceptions("blah")
    }
    catch {
      case sqle: SQLException => println("SQLException")//log.error("problem from database", sqle)
      case ioe: IndexOutOfBoundsException => println("IndexOutOfBoundsException")//log.info("IOException; don't care", ioe)
      // any other exception will get through as if we didn't try/catch
    }
  }
}