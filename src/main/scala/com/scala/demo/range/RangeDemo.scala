package com.scala.demo.range

import squants.time.Days
import squants.time.TimeConversions._

/**
  * Created by ravikumar on 25/5/17.
  */
object RangeDemo extends  App {
  val b = (1.days to 10.days)

  println(b)
val a = (1 to 10).map(_/2)
  println(a)
}
