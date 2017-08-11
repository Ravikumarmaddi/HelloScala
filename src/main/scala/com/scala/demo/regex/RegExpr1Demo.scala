package com.scala.demo.regex

/**
  * Created by ravikumar.m on 09-11-2016.
  */
import scala.util.matching.Regex

object RegExpr1Demo {
  def main(args: Array[String]) {
    val pattern = new Regex("abl[ae]\\d+")
    val str = "ablaw is able1 and cool"

    println((pattern findAllIn str).mkString(","))
  }
}
