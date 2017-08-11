package com.scala.demo.caseclass

/**
  * Created by ravikumar.m on 22-10-2016.
  */
case class Employee(name: String, id: Int)

object BasicsCaseClassDemo extends App {
  // 1. 'new' keyword is optional to create new instance of case class.
  var e = new Employee("ravi", 1)
  var e1 = Employee("krishna", 2)

  // 2. Fields(here, name and id) becomes class field of class and becomes val(immutable ie. constants in simple words.).
  println(e.name + "    " + e.id);
  println(e1.name + "    " + e1.id);

  //  e.name = "gopi"  //Error: reassignment to val

  // 3. Scala compiler also adds a copy method to Case class automatically.
  var e2 = e1
  println(e2.name + "    " + e2.id);
  if (e2 == e1)
    println(true)
  else
    println(false)
  var e3 = e1.copy()
  println(e3.name + "    " + e3.id);
  if (e3 == e1)
    println(true)
  else
    println(false)

  var e4 = e1.copy(id = 3, name = "rama" + e1.name)
  println(e4.name + "    " + e4.id);
  if (e4 == e1)
    println(true)
  else
    println(false)

  // 4. Partial arguments not allowed except those have default values.
  //var e5 = Employee(id=5)  //Error: not enough arguments for method apply: (name: String, id: Int)com.scala.demo.caseclass.Employee in object Employee.
  //println(e5.id);

  case class PrartialEmployee(name: String = "xxx", id: Int)

  var e6 = PrartialEmployee(id = 5) //Error: not enough arguments for method apply: (name: String, id: Int)com.scala.demo.caseclass.Employee in object Employee.
  println(e6.id);

  // 5. Case classes can be abstract
  abstract case class ACC(id: Int)

  // case abstract class CAC(id:Int) //error: illegal start of definition

  // 6. Case class can not extend another case class
  //  case class Base(id:Int)
  //  case class Child(name:String) extends Base

  // 7. Case Class can extend another Class or Abstract Class.
  class Base1(id:Int)
  abstract class Base2(id:Int)
  case class Child(name:String) //extends Base1 with Base2

}
