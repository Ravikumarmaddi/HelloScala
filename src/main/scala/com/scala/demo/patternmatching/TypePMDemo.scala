package com.scala.demo.patternmatching

/**
  * Created by ravikumar on 19/11/16.
  */
class TypePMDemo {
  //  Pattern matching can also be used to check the type of an instance, rather than using isInstanceOf\[B\]:

  val anyRef: AnyRef = ""

  anyRef match {
    case _: Number => "It is a number"
    case _: String => "It is a string"
    case _: CharSequence => "It is a char sequence"
  }
  //> res0: String = It is a string
  //  The order of the cases is important:

  anyRef match {
    case _: Number => "It is a number"
    case _: CharSequence => "It is a char sequence"
    case _: String => "It is a string"
  }
  //> res1: String = It is a char sequence
  //  In this manner it is similar to a classical 'switch' statement, without the fall-through functionality.
}
