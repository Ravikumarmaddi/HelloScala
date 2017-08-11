package com.scala.demo.types

/**
  * Created by ravikumar.m on 23-10-2016.
  */

class A

trait B

object C

case class D(var a: Int)

case object E

case class F(var a: Int) extends B

case object G extends B

class H(a: Int, b: String)

trait I extends H

class J(var a: Int, var b: String)

case class K(var a: Int, var b: String)

class L(val a: Int, val b: String)

sealed trait M

sealed class N

class O extends B

trait Q

class PP extends B with Q

case class AA private(id: String) {}

case class BB(id: String) {}

sealed trait UpsertStatus
object UpsertStatus {
  case object Updated extends UpsertStatus
  case object Inserted extends UpsertStatus
}



// sealed object O   // -- Sealed is not allowed to object.

object EmptyTypesDemo extends App {
  println("Sample Tpe Demo")
}
