package com.scala.demo.basics

/**
  * Created by ravikumar on 9/5/17.
  */
object ImportScopesDemo {
  import scala.util.Random
  def printRandom {
    val r = new Random
  }
}

class ImportScopesCheck {
  def printRandom {
     // val r = new Random // error: becuase Random you imported in ImportScopesDemo class. If you put in top then only you can access.
  }
}
