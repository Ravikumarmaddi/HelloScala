package com.scala.demo.implicits

/**
  * Created by ravikumar.m on 05-11-2016.
  */
object ImplicitClass {
  implicit class IntTimes(x: Int) {
    def times [A](f: =>A): Unit = {
      def loop(current: Int): Unit =
        if(current > 0){
          f
          loop(current - 1)
        }
      loop(x)
    }
  }
}