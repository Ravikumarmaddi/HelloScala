package com.scala.demo.objects

/**
  * Created by ravikumar.m on 07-11-2016.
  */

object CompanionObjectDemo {

  class CompanionClass(val jString: String) {
    private var extraData = ""

    override def toString = jString + extraData
  }
  class NonCompanionClass(val jString: String) {
    private var extraData = ""

    override def toString = jString + extraData
  }

  object NonCompanionObject {
    def apply(base: String, extras: String) = {
      val s = new NonCompanionClass(base)
      // s.extraData = extras   // You can not access private members.
      s
    }

    def apply(base: String) = new NonCompanionClass(base)
  }

  object CompanionClass {
    def apply(base: String, extras: String) = {
      val s = new CompanionClass(base)
      s.extraData = extras
      s
    }

    def apply(base: String) = new CompanionClass(base)
  }

  println(CompanionClass("hello", " world"))
  println(CompanionClass("hello"))
  val s1 = new CompanionClass("hello again")

 // import com.scala.demo.objects.CompanionObjectDemo.NonCompanionClass

  println(NonCompanionObject("hello", " world"))
  println(NonCompanionObject("hello"))
  val s2 = new NonCompanionClass("hello again")
}