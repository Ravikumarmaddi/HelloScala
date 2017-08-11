package com.scala.demo.caseclass

/**
  * Created by ravikumar on 4/3/17.
  */
case class CaseClassAsClass(name:String,id:Double) {

  var lastName:String = "Maddi"

}


object CaseClassAsClassDemo extends App{

  var cc = CaseClassAsClass("Ravi", 1)
  println(cc.name)
  println(cc.lastName)
  println(cc.id)

}