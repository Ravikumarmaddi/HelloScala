package com.scala.demo.constructors

/**
  * Created by ravikumar.m on 22-10-2016.
  */

object AuxiliaryConstructorsDemo extends App {
  println(new OldPizza)
  println(new OldPizza(14))
  println(new OldPizza(16, "Thick"))

  println(new NewPizza)
  println(new NewPizza(14))
  println(new NewPizza(16, "Thick"))

  println(new LatestPizza)
  println(new LatestPizza(14))
  println(new LatestPizza(16, "Thick"))

}

class OldPizza {

  var crustSize = 12
  var crustType = "Thin"

  def this(crustSize: Int) {
    this()
    this.crustSize = crustSize
  }

  def this(crustSize: Int, crustType: String) {
    this(crustSize)
    this.crustType = crustType
  }

  override def toString = {
    "A %s inch pizza with %s crust.".format(crustSize, crustType)
  }

}

class NewPizza(var crustSize: Int = 12,
               var crustType: String = "Thin") {

  def this(crustSize: Int) {
    this()
    this.crustSize = crustSize
  }

  /*  def this(crustSize: Int, crustType: String) {
      this(crustSize)
      this.crustType = crustType
    }*/

  override def toString = {
    "A %s inch pizza with %s crust.".format(crustSize, crustType)
  }
}

class LatestPizza(var crustSize: Int = 12,
               var crustType: String = "Thin")



