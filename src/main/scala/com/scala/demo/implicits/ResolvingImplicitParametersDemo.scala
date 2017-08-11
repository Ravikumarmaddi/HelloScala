package com.scala.demo.implicits

/**
  * Created by ravikumar on 20/11/16.
  */
case class SomeCtx1(i:Int)

case class SomeCtx2(i:Int)
object ResolvingImplicitParametersDemo extends App{
  //Assuming an implicit parameter list with more than one implicit parameter:

  case class Example(p1:String, p2:String)(implicit ctx1:SomeCtx1, ctx2:SomeCtx2)
 // Now, assuming that one of the implicit instances is not available (SomeCtx1) while all other implicit instances needed are in-scope, to create an instance of the class an instance of SomeCtx1 must be provided.

   // This can be done while preserving each other in-scope implicit instance using the implicitly keyword:

//                                                                                                                                                                       Example("something","somethingElse")(new SomeCtx1(1), implicitly[SomeCtx2])

}

