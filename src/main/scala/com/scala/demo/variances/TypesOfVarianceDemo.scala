package com.scala.demo.variances

/**
  * It illustrates Diffrent types of variances:
  * class Foo[+A] // A covariant class
  * class Bar[-A] // A contravariant class
  * class Baz[A]  // An invariant class
  */
object TypesOfVarianceDemo {

}

abstract class Animal {
  def name: String
}

case class Dog(name: String) extends Animal

case class Cat(name: String) extends Animal

object VarianceTest extends App {
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach {
      animal => println(animal.name)
    }
  }

  val dogs: List[Dog] = List(Dog("Tom"), Dog("Nisy"))
  val cats: List[Cat] = List(Cat("Tom1"), Cat("Nisy1"))

  printAnimalNames(dogs)
  printAnimalNames(cats)

}

abstract class Printer[-A] {
  def print(a:A): Unit
}

class AnimalPrinter extends Printer[Animal]{
  override def print(a:Animal): Unit ={
    println(a.name)
  }
}

class CatPrinter extends Printer[Cat]{
  override def print(a:Cat): Unit ={
    println(a.name)
  }
}


object ContravarianceTest extends App {
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach {
      animal => println(animal.name)
    }
  }

  val dogs: List[Dog] = List(Dog("Tom"), Dog("Nisy"))
  val cats: List[Cat] = List(Cat("Tom1"), Cat("Nisy1"))

  printAnimalNames(dogs)
  printAnimalNames(cats)

}

