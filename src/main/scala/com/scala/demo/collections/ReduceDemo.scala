package com.scala.demo.collections

/**
  * Created by ravikumar on 20/11/16.
  */
object ReduceDemo extends App{
  val numList = List[Int](1, 2, 3, 4, 5)
  numList.reduce((n1, n2) => n1 + n2)  // 15

  val numSet = Set[Int](1, 2, 3, 4, 5)
  numSet.reduce((n1, n2) => n1 + n2)   // 15

  val numArray = Array[Int](1, 2, 3, 4, 5)
  numArray.reduce((n1, n2) => n1 + n2) // 15
}
