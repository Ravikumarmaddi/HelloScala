package com.scala.demo.functions

/**
  * Created by ravikumar.m on 07-11-2016.
  */

object VariableArgumentsDemo {
  def main(args: Array[String]) {
    printStrings(10,"Hello", "Scala", "Python");
  }
  // NOTE: variable arguments param should come last.
  def printStrings( i:Int, b:String,args:String* ) = {
    var i : Int = 0;

    for( arg <- args ){
      println("Arg value[" + i + "] = " + arg );
      i = i + 1;
    }
  }
}