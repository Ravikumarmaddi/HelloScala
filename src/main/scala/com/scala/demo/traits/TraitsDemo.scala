package com.scala.demo.traits

/**
  * Created by ravikumar.m on 23-10-2016.
  */
trait Equal2 {
  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}

/*
Gernerated Java code for trait Equal
public interface com.scala.demo.traits.Equal {
  public abstract boolean isEqual(java.lang.Object);
  public abstract boolean isNotEqual(java.lang.Object);
}
*/
class TraitsDemo {
}

class Point1(xc: Int, yc: Int) extends Equal2 {
  var x: Int = xc
  var y: Int = yc

  def isEqual(obj: Any) = obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == y
}

object TraitsDemo {
  def main(args: Array[String]) {
    val p1 = new Point1(2, 3)
    val p2 = new Point1(2, 4)
    val p3 = new Point1(3, 3)

    println(p1.isNotEqual(p2))
    println(p1.isNotEqual(p3))
    println(p1.isNotEqual(2))

    var ee = new Equal2 {
      override def isEqual(x: Any): Boolean = !isNotEqual(x)
    }
    println(ee.isEqual("aaa"))
  }
}
