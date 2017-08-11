package com.scala.demo.applyunapply

import java.util.UUID

/**
  * Created by ravikumar on 28/4/17.
  */
object ApplyUnapplyDemo extends  App {

}

case class Acc (aco :String, nm:String, balance:Float, add:String)


object Acc{
 def apply( bal:Float, add:String) = new Acc(UUID.randomUUID().toString,"name", 0, add)

}
