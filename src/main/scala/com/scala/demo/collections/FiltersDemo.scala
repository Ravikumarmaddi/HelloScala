package com.scala.demo.collections

import scala.collection.immutable.Nil

object FiltersDemo {
  def main(args: Array[String]): Unit = {
    val data = List("x", "x", "c", "c", "c", "s", "s", "d", "s", "a", "a", "a")
    println(encode(data))
    //packfilter()
    //filterDemos()
  }

  def filterDemos(): Unit = {
    val nums = List(2, 5, -6, 4, 7, 9, 8, -1)

    println(nums filter (x => x > 0))
    println(nums filterNot (x => x > 0))
    println(nums partition (x => x > 0))
    println(nums takeWhile (x => x > 0)) // take elements till predicate fails first time..
    println(nums dropWhile (x => x > 0)) // take elements after predicate fails first time..

    println(nums partition (x => x % 2 == 0))
  }

  /**
    * Packing of list consecutive duplicates
    */
  def packfilter(): Unit = {
    val data = List("x", "x", "c", "c", "c", "s", "s", "d", "s", "a", "a", "a")
    println(pack(data))
  }

  def pack[T](xs: List[T]): List[List[T]] = xs match {
  //  case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }

  def encode[T](data: List[T]): List[(T, Int)] =
    pack(data) map (subList => (subList.head, subList.length))
}