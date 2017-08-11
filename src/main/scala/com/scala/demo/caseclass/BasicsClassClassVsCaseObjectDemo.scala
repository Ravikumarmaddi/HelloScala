package com.scala.demo.caseclass

/**
  * Created by ravikumar on 4/4/17.
  */
object BasicsClassClassVsCaseObjectDemo extends App{

  // 1. Scala Version 2.11.1 on-wards, we cannot create Case Classes without parameters.
  // Or it’s always advisable to use Case Object in this case.
  // case class CC1   // So this line won't compile.
  case class CC2()    // It will compile

  case object CO1

  // 2. You can make it some fields mutable if you need, but not recommended.
  //    By default all fields are vals in case classs.
  case class CC3(id:Int, var name:String)
  // Here you can change nema, try it
  val cc1 = CC3(1,"aaa")
  cc1.name = "bbb"
  println(cc1.name)

  // 3. Before Scala Version 2.11.1, Scala Case Classes support maximum of 22 parameters only. If we use more than 22, we will get compile-time error.
  case class Names(a1:String,a2:String,a3:String,a4:String,a5:String,a6:String,a7:String,a8:String,a9:String,a10:String,
                   a11:String,a12:String,a13:String,a14:String,a15:String,a16:String,a17:String,a18:String,a19:String,a20:String,
                   a21:String,a22:String,a23:String,a24:String,a25:String,a26:String,a27:String,a28:String,a29:String,a30:String)
}
