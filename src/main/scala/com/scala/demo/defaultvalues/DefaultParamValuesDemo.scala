package com.scala.demo.defaultvalues

/**
  * Created by ravikumar.m on 17-10-2016.
  */

class HashMap[K, V](initialCapacity: Int = 16, loadFactor: Float = 0.75f) {
}

class DefaultParamValuesDemo {
  // Uses the defaults
  val m1 = new HashMap[String, Int]

  // initialCapacity 20, default loadFactor
  val m2 = new HashMap[String, Int](20)

  // overriding both
  val m3 = new HashMap[String, Int](20, 0.8f)

  // override only the loadFactory via
  // named arguments
  val m4 = new HashMap[String, Int](loadFactor = 0.8f)

}

