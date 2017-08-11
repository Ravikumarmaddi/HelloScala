package com.scala.demo.caseclass

/**
  * Created by ravikumar on 25/11/16.
  */
object ClassVSCaseClass extends App {

  case class Hello(name: String, num: Int)

  class HelloClass(name: String, num: Int) {
    def getName() {
      name
    }

    def getNum() {
      num
    }
  }

  var h = Hello("ravi", 2)
  println(h)
  var hc = new HelloClass("ravi", 2) // You should use 'new'.
  println(h.name) // case class fields are public
  println(h.num)
  // hc.name   // These name, num are not
  // hc.num
  println(hc.getName())
  println(hc.getNum())

  // h.name ="krishna"   // Immutable

}
