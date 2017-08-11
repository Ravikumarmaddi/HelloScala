package com.scala.demo.functions

/**
  * Created by ravikumar on 11/5/17.
  */
object ReturningMultiplesDemo {
  // a method that returns a tuple
  def getStockInfo = {
    // other code here ...
    ("NFLX", 100.00, 101.00) // return a tuple
  }

  // call the method like this
  val (symbol, currentPrice, bidPrice) = getStockInfo

  // or call the method like this
  val x = getStockInfo
  x._1    // String = NFLX
  x._2    // Double = 100.0
  x._3    // Double = 101.0
}
