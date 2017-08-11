package com.scala.demo.implicits

import com.scala.demo.implicits.ImplicitClass._

/**
  * Created by ravikumar.m on 05-11-2016.
  * Note −
  *     Implicit classes must be defined inside another class/object/trait (not in top level).
  *     Implicit classes may only take one non –implicit argument in their constructor.
  *     Implicit classes may not be any method, member or object in scope with the same name as the implicit class.
  */

object ImplicitClassDemo extends App {

  4 times println("hello")

}