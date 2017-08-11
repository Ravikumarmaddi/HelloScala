package com.scala.demo.symbols

/**
  * Created by ravikumar on 21/11/16.
  */
object SymbolsDemo extends App{
  val nums = List(1,2,3,4,5)
  var initialValue:Int = 0;
  var sum = nums.fold(initialValue){
    (accumulator,currentElementBeingIterated) => accumulator + currentElementBeingIterated
  }
  println(sum) //prints 15 because 0+1+2+3+4+5 = 15
}
