package com.scala.demo.implicits

/**
  * Created by ravikumar on 19/11/16.
  *
  */
object ImplicitLocalFieldsDemo extends App {
  // import the duration methods
  import scala.concurrent.duration._

  // dummy methods that use the implicit parameter
  def doLongRunningTaskA()(implicit timeout: FiniteDuration): Long = {println(timeout.toMillis);timeout.toMillis}
  def doLongRunningTaskB()(implicit timeout: FiniteDuration): Long =  {println(timeout.toMillis);timeout.toMillis}

  // we define the value timeout as implicit
  implicit val timeout1: FiniteDuration = 1.second

 // val timeout2: FiniteDuration = 3.second
  // Note: it creats ambiguous value. ie. It concern about type not concern about name of variable.
  // implicit val timeout2: FiniteDuration = 1.second

  // we can now call the functions without passing the timeout parameter
  // 1. It will do type check only not name check.
  doLongRunningTaskA() // 1000
  doLongRunningTaskB() // 1000

}
