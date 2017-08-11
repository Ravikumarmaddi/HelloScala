package com.scala.demo.functions

/**
  * Created by ravikumar on 17/12/16.
  */
trait TFunExercise {
  def partial1[A,B,C](a: A, f: (A,B) => C): B => C
}

class FunExerciseClass extends TFunExercise{
  override def partial1[A, B, C](a: A, f: (A, B) => C): (B) => C = ???
}
