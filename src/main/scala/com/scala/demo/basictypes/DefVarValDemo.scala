package com.scala.demo.basictypes

/**
  * Created by ravikumar on 3/5/17.
  */
object DefVarValDemo extends App {
  class Person222(val name:String,var age:Int )
  def person1 = new Person222("Kumar",12)
  val person2 = new Person222("Kumar",12)
  person1.age = 20
  person2.age = 20
  println(person1.age)  // OUTPUT: 12  -- def not allow to change instance.
  println(person2.age)  // OUTPUT: 20  -- val allow to change instance.


}
