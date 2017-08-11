package com.scala.demo.currying

/**
  * Created by ravikumar.m on 16-10-2016.
  */

object FunctionCurryingDemo extends App {
  // The two paren expressions indicate that the arguments
  // in the second expression can be provided at a different
  // time than those in the first
  def prefixNotifier(pre: String)(message: String) =
    println(pre + ":" + message)

  def uppercaseNotifier(message: String) =
    println(message.toUpperCase)

  print("fffffffffffffffffffff")
  // Here we provide "ERROR" for "pre" in prefixNotifier; the
  // result of this syntax is a new function that takes on argument.
  // That function is, essentially (arg:String) => println("ERROR" + ":" + arg)
  // val errorNotifier = prefixNotifier("ERROR")

  // Since SomeSystemComponent takes a function of type
  // (String) => Unit (Unit is void in Java)
  // we can pass errorNotifier into it, since that is the type of
  // errorNotifier
  //val c1 = new SomeSystemComponent(errorNotifier)

  // uppercaseNotifier already has this type
  // val c3 = new SomeSystemComponent(uppercaseNotifier)

  // We can also just construct the curried function
  // on the fly, like so
  //val c2 = new SomeSystemComponent(prefixNotifier("---->"))
}
