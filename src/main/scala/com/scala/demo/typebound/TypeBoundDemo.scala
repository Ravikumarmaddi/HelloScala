package com.scala.demo.typebound

/**
  * Created by ravikumar.m on 17-10-2016.
  */

class DatabaseEntity

class ReferenceData(var code: String, var desc: String)
  extends DatabaseEntity {

  override def toString = code + ":" + desc
}

class State(code: String) extends ReferenceData(code, code) {
  override def toString = code
}

class Gender(letter: String, desc: String) extends ReferenceData(letter, desc)

class Person(var name: String, var gender: Gender, var birthState: State)
  extends DatabaseEntity

class Sorter[T <: ReferenceData](list: List[T]) {
  def regular = list

  def sorted = list.sortWith((a, b) => a.code.compare(b.code) < 0)
}

object TypeBoundDemo extends App {

  val genders = List(new Gender("M", "Male"),
    new Gender("F", "Female"), new Gender("O", "Other"))

  val states = List(new State("MD"), new State("DC"), new State("VA"))

  val people = List(new Person("Dave", genders(0), states(1)),
    new Person("Rudy", genders(2), states(1)),
    new Person("Carrie", genders(1), states(2)))

  def genderSorter = new Sorter(genders)

  def stateSorter = new Sorter(states)

  println(genderSorter.sorted)
  println(stateSorter.sorted)
}
