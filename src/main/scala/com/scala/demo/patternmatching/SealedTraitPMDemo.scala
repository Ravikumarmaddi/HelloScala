package com.scala.demo.patternmatching

/**
  * Created by ravikumar on 17/11/16.
  */
object SealedTraitPMDemo extends App{
  sealed trait Shape
  case class Square(height: Int, width: Int) extends Shape
  case class Circle(radius: Int) extends Shape
  case object Point extends Shape

  def matchShape(shape: Shape): String = shape match {
    case Square(height, width) => "It's a square"
    case Circle(radius)        => "It's a circle"
    case _ => "Do nothing"
    //no case for Point because it would cause a compiler warning.
  }
  println(matchShape(Point))
  println(matchShape(Square(10,20)))
  println(matchShape(Circle(10)))

}
