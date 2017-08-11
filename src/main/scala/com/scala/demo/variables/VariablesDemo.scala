package com.scala.demo.variables

/**
  * Created by ravikumar.m on 22-10-2016.
  */
object VariablesDemo extends App {
  val p1 = new Person1("Alvin Alexander")
  p1.name                                  // String = Alvin Alexander
  p1.name = "Fred Flintstone"              // String = Fred Flintstone

  val p2 = new Person2("Alvin Alexander")
  p2.name                                  // String = Alvin Alexander
 // p2.name = "Fred Flintstone"              // error: reassignment to val

  val p3 = new Person3("Alvin Alexander")
 // p3.name                                  // error: value name is not a member of Person

  val p4 = new Person4("Alvin Alexander")
//  p4.name       // error: variable name in class Person cannot be accessed in Person
  p4.printName  // Alvin Alexander

}

// 'name' is a var
class Person1(var name: String)

// 'name' is a val
class Person2(val name: String)

// 'name' is neither var or val
class Person3(name: String)

// 'name' is 'private var'
class Person4(private var name: String) { def printName {println(name)}  }

