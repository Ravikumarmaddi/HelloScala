package com.scala.demo.common

/**
  * Created by ravikumar.m on 04-11-2016.
  */
class PrivateThisDemo {

}

trait Foo1 {
    protected def foo(that: Foo1): Int = that.foo(this)
  }

trait Foo2 {
   // protected[this] def foo(that: Foo2): Int = that.foo(this) // PROTECTED [THIS] : IT WON'T ALLOW TO ACCESS THIS OBJECT BY OTHER OBJECT OF ANY TYPE OR SAME TYPE ALSO.
  }
trait Foo3 {
  protected[this] def foo(that: Foo3): Int = this.foo(that)
}
