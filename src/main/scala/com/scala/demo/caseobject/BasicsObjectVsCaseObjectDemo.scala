package com.scala.demo.caseobject

/**
  * Created by ravikumar on 4/4/17.
  */
object BasicsObjectVsCaseObjectDemo extends App {

  object obj

  case object CO

  // 1. By Default, Case Object gets toString and hashCode methods. But normal object cannot.
  obj.toString
  obj.hashCode()
  obj.equals(null)

  CO.toString
  CO.hashCode()
  CO.equals(null)

  // 2. By Default, Case Object is Serializable. But normal object is not. So, below statement won't compile.
  // println(obj.isInstanceOf[Serializable])
  println(CO.isInstanceOf[Serializable])

  // 3. Case class can be abstact but object should not be abstract.

}
