package com.scala.demo.validation

/**
  * Created by ravikumar on 9/3/17.
  */
object ClassFieldValidationDemo extends App{

  var rightAcc = new Account(2001,"Ravi Kumar Maddi", 6000)
  println(rightAcc)
  var wrongAcc = new Account(2001,"Ravi", 6000)
  println(wrongAcc)
}

class Account(num:Int, name:String, cbal:Float){
  require(num > 2000)
  require(name.length > 10)
  require(cbal > 5000)

  override def toString = num + "   " + name +"   " + cbal
}

