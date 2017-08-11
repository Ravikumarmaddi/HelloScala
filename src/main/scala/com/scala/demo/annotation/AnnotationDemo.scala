package com.scala.demo.annotation

import scala.beans.BeanProperty

/**
  * Created by ravikumar.m on 16-10-2016.
  */
class Person1 {
  @BeanProperty
  var name = "Dave"

  var age = 36
}

object AnnotationDemo extends App {
  /* Person1 p
   // Scala has added this method for us
   println(p.getName());

   // Since we didn't annotate "age", we can't do this:
   println(p.getAge()); // compile error!*/
}
