package com.scala.demo.annotation.privated

/**
  * Created by ravikumar.m on 05-11-2016.
  */
class PrivateInnerClassDemo {

}

class Outer {

  class Inner {
    private def f() {
      println("f")
    }

    class InnerMost {
      f()

      // OK
      def ff() {
        println("f")
      }
    }

    (new InnerMost).ff()
  }

  //(new Inner).f() // Error: f is not accessible
  //(new Inner.InnerMost).ff()
}
