package com.scala.demo.nothing

trait List[T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")

  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

  singleton[Int](8)
  singleton[Boolean](true)
  // You can use like this, 
  singleton(5)
  singleton(false)

}