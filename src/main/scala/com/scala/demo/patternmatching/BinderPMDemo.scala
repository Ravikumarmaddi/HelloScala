package com.scala.demo.patternmatching

/**
  * Created by ravikumar on 17/11/16.
  */
object BinderPMDemo extends App {

  //The @ sign allows us to bind a variable to a name during a pattern match. The bound variable can either be the entire matched object or part of the matched object:

  sealed trait Shape

  case class Rectangle(height: Int, width: Int) extends Shape

  case class Circle(radius: Int) extends Shape

  case object Point extends Shape

  (Circle(5): Shape) match {
    case Rectangle(h, w) => println(s"rectangle, $h x $w.")
    case Circle(r) if r > 9 => println(s"large circle")
    case c@Circle(_) => println(s"small circle: ${c.radius}")
    //The bound identifier can be used in any conditional filter. Thus,
  }
  (Circle(10): Shape) match {
    case Circle(r) if r > 9 => println(s"large circle")
    //can also be written as:
    case c@Circle(_) if c.radius > 9 => println(s"large circle")
    //Or the name can be bound to part of the matched pattern:
    case Point => println("point")
  }
  // > res0: String = small circle: 5


  Seq(Some(1), Some(2), None) match {
    // The first element is bound to the name 'head'
    case Seq(head@Some(1), _*) => head
    case _ => None
  }
}
