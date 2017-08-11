package com.scala.demo.collections

//import org.joda.time.DateTime

case class Emp1(a:Int, b:String)
//case class DrPowerReading(siteId: String, timestamp: Long, reading: Double, insertTime: DateTime = new DateTime())

object MapFilterDemo extends App {

  val elist: Map[String,Emp1] = Map( "1" -> Emp1(1,"aaa"), "2" -> Emp1(2,"bbb"))
  val elist1 = elist + "3" -> Emp1(3,"ccc")

  println(elist)
  println(elist1)
  println(elist1.isInstanceOf[Map[String,Emp1]])
  println(elist.getClass)
  println(elist1.getClass)
  elist - "1" -> Emp1(1,"aaa")
  println(elist.size)
  elist - "2"
  println(elist.size)

  println()
  println()
  println()
  println()
}
