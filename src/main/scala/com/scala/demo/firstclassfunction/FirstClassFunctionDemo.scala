package com.scala.demo.firstclassfunction

/**
  * Created by ravikumar on 13/3/17.
  */
object FirstClassFunctionDemo extends App {

  def sum (a:Int,b:Int, c:Int) = a + b + c
  var a = sum _

  println(sum(1,2,3))
  println(a(2,3,4))
  println(a.apply(1,2,3))

  var b = sum(10,_:Int,_:Int)
  println(b(2,3))
  println(b.apply(1,2))

  var c = sum(_:Int,20,_:Int)
  println(c(2,3))
  println(c.apply(1,2))

}
