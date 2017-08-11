package com.scala.demo.basictypes

/**
  * Created by ravikumar on 8/3/17.
  */
object BasicTypesDemo extends App {

  //Value type Range
  var bite: Byte = 7               //8-bit signed two’s complement integer (-2 7 to 2 7 - 1, inclusive)
  var short1  : Short  = 123       //16-bit signed two’s complement integer (-2 15 to 2 15 - 1, inclusive)
  var int1    : Int  = 12345       //32-bit signed two’s complement integer (-2 31 to 2 31 - 1, inclusive)
  var long1   : Long = 12345678    // 64-bit signed two’s complement integer (-2 63 to 2 63 - 1, inclusive)
  var char1   : Char = 'c'         //16-bit unsigned Unicode character (0 to 2 16 - 1, inclusive)
  var str1    : String = "Sri"     //a sequence of Char s
  var float1  : Float  = 0.5f      // 32-bit IEEE 754 single-precision float
  var double1 : Double = 0.000001  //64-bit IEEE 754 double-precision float
  var bool1: Boolean = true      //true or false

}
