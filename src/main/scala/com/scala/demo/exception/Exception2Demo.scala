package com.scala.demo.exception

/**
  * Created by ravikumar.m on 09-11-2016.
  */

import java.io.{FileNotFoundException, FileReader, IOException}

object Exception2Demo {
  def main(args: Array[String]) {
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }

      case ex: IOException => {
        println("IO Exception")
      }
    }
  }
}
