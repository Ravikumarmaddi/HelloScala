package com.scala.demo.implicits

/**
  * Created by ravikumar on 19/11/16.
  */
@annotation.implicitNotFound(msg = "Select the proper implicit value for type M[${A}]!")
case class M[A](v: A) {}

object ImplicitNotFoundDemo extends App {

  def usage[O](implicit x: M[O]): O = x.v

  //Does not work because no implicit value is present for type `M[Int]`
  //usage[Int]   //Select the proper implicit value for type M[Int]!
  implicit val first: M[Int] = M(1)
  usage[Int]     //Works when `second` is not in scope
  //implicit val second: M[Int] = M(2)
  //Does not work because more than one implicit values are present for the type `M[Int]`
  //usage[Int]   //Select the proper implicit value for type M[Int]!
}
