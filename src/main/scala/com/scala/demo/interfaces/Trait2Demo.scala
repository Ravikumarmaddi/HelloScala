package com.scala.demo.interfaces

/**
  * Created by ravikumar.m on 16-10-2016.
  */

trait SuperComparable {
  // extenders need only implement this method
  // since it has no definition, it's abstract
  // Also notice that the final colon and type indicate
  // the return type of this method
  def compareTo(x: Any): Int

  // here we have a method that works in terms
  // of the abstract one above, just as you
  // would have in a Java abstract class
  // Also note that we don't need to declare
  // the return type; it's inferred by
  // the compiler
  def lessThan(x: Any) = compareTo(x) < 0

  def greaterThan(x: Any) = compareTo(x) > 0

  def same(x: Any) = compareTo(x) == 0
}

// This is more like a traditional
// interface in Java, as the methods
// are all abstract
trait HasArea {
  def area: Double
}

class Shape {
  override def toString = "Some Shape"
}

// We can extend a proper superclass, but also
// mixin the two traits using the "with"
// keyword.  Note that if we had no explicit superclass
// the first trait would follow the "extends" keyword.
class Circle(r: Int) extends Shape with SuperComparable with HasArea {
  val radius = r;

  def diameter = radius * 2

  def area = {
    val pi = 3.14
    var area = pi * radius
    area *= radius
    area
  }

  override def toString = "Circle with radius " + radius

  // note that we do not need to declare override
  // here (although we can)
  // asInstanceOf performs a cast; we probably wouldn't
  // implement this method this way in the real
  // world.
  def compareTo(x: Any) = radius - x.asInstanceOf[Circle].radius
}

object SuperComparableDemo {
  def main(args: Array[String]) {
    val circle = new Circle(4)
    val sameCircle = new Circle(4)
    val smallCircle = new Circle(3)
    val biggerCircle = new Circle(5)

    println(circle.lessThan(biggerCircle))
    println(circle.same(sameCircle))
    println(circle.greaterThan(smallCircle))
    println(circle.lessThan(smallCircle))
    println(circle.area)
  }
}
