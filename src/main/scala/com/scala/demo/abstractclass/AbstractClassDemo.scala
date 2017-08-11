package com.scala.demo.abstractclass

/**
  * Created by ravikumar on 11/4/17.
  */
object AbstractClassDemo extends App {



}



abstract class AA {
  def a:Int
  def b:String
}

case class BB(a:Int,b:String,c:String) extends AA


object CC extends App{
  var a = BB(1,"bbb","ccc")
  var b:AA = _
  b = a
  println(b.a + b.b )  // b.c won't work because we are
}


