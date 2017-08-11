package com.scala.demo.caseclass

case class FullEmp(id: Int, name: String)

case class PartialEmp(id: Option[Int], name: Option[String])


object PartialVsFullCaseClass extends App {
  var fullEmp1 = FullEmp(1, "Ravi")
  var fullEmp2 = FullEmp(1, null)
  var partialEmp1 = PartialEmp(Some(1), Some("Krishna"))
  var partialEmp2 = PartialEmp(Some(1), None)
  var partialEmp3 = PartialEmp(Some(1), null)
  println(fullEmp1.name)
  println(fullEmp2.name)

  println(partialEmp1.name + "   " + partialEmp1.name.get)
  println(partialEmp2.name)
  println(partialEmp3.name)
}


