package com.scala.demo.singleton

/**
  * Created by ravikumar.m on 05-11-2016.
  */
class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc

  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
  }
}

object SingletonDemo {
  def main(args: Array[String]) {
    val point = new Point(10, 20)
    printPoint

    def printPoint{
      println ("Point x location : " + point.x)
      println ("Point y location : " + point.y)
    }
  }
}
