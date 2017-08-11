package com.scala.demo.implicits

/**
  * Created by ravikumar on 19/11/16.
  */
object ImplicitConvertionDemo extends App {

  //  An implicit conversion allows the compiler to automatically convert an object of one type to another type. This allows the code to treat an object as an object of another type.

  case class Foo(i: Int)

  // without the implicit
  Foo(40) + 2

  // compilation-error (type mismatch)

  // defines how to turn a Foo into an Int
  implicit def fooToInt(foo: Foo): Int = {
    println("fooToInt called.")
    foo.i
  }

  // now the Foo is converted to Int automatically when needed
  println(Foo(40) + 2) // 42
  println(2 + Foo(40))

  // 42
  //  The conversion is one-way: in this case you cannot convert 42 back to Foo(42). To do so, a second implicit conversion must be defined:

  implicit def intToFoo(i: Int): Foo = {
    println("intToFoo called.")
    Foo(i)
  }

  //  Implicit conversions should be used sparingly because they obfuscate what is happening. It is a best practice to use an explicit conversion via a method call unless there's a tangible readability gain from using an implicit conversion.
  // Foo() = 10

  //Int aa = 10 + Foo(40)
  var a: Foo = 100
  println(a)


}
