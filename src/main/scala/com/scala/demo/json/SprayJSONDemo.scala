package com.scala.demo.json

import spray.json._
import DefaultJsonProtocol._
/**
  * Created by ravikumar on 15/12/16.
  */
case class Customer (cno:Int, name:String, address: Address)
case class Address( dno:String, city:String, country:String )

object SprayJSONDemo extends App {

  var res = """{"something":"somevalue"}""".parseJson
  println(res.convertTo[Map[String,String]])

  var values = List("aaa","bbb","ccc")
  println (values.toJson.prettyPrint)

//  implicit val addressFormat = jsonFormat2(Address)
//  implicit val customerFormat = jsonFormat2(Customer)

//  val beans = Customer(1,"Beans", new Address("104","New York", "USA"))
//  println(beans.toJson.prettyPrint)
}
