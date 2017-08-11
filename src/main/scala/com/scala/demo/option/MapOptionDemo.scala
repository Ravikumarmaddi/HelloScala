package com.scala.demo.option

/**
  * Created by ravikumar on 29/11/16.
  */
object MapOptionDemo {
  def main(args: Array[String]) {
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

    println("show(capitals.get( \"Japan\")) : " + show(capitals.get( "Japan")) )
    println("show(capitals.get( \"India\")) : " + show(capitals.get( "India")) )
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
}
