package com.scala.demo.operators

/**
  * Created by ravikumar.m on 16-10-2016.
  */
class Person(var name: String, var age: Int) {
  def <=>(other: Person) = {
    if (name == other.name)
      age < other.age
    else
      name.compareTo(other.name) < 0
  }

  override def toString = name + "(" + age + ")"
}

object CompareOperatorDemo extends App {
  val people = List(new Person("Dave", 36),
    new Person("Rudy", 5),
    new Person("Dave", 30),
    new Person("Amy", 32),
    new Person("Tony", 33))

  println(people.sortWith((a, b) => a <=> b))
}
