package com.scala.demo.caseclass

/**
  * Created by ravikumar on 26/11/16.
  */
object CaseClassCurring extends App {

  case class Keyword(text: String)(source: String, foo: Int)

  //  The formal parameters in the first parameter section of a case class (just text in this case) are called elements; they are treated specially. All the goodies you get when you define a case class (accessors, pattern matching support, copy method, …) only apply to the first section. For example you don’t have an accessor for source since the compiler didn’t implicitly prefix it with val, like it did for text instead. E.g.:
  val k1 = Keyword("restaurant")("storage", 1)

  // won't compile
 // val source = k1.source

  //  You can solve the accessor problem by prefixing the parameters with val. E.g.:
  case class Keyword2(text: String)(val source: String, val foo: Int)

  //  Anyway you still won’t get all the other case class features. For instance, you cannot use the copy method by specifying only the source parameter. You have to specify, at least, all the parameters of the sections successive to the first. E.g.:
  // won't compile
  // val k2 = k1.copy()(source = "web")
  // will compile
  val k3 = k1.copy()(source = "web", foo = 1)

  //  At this point the natural question that may arise is: “Why on earth should I want to define a case class in such a way?” Apparently there are cases when it could be a reasonable choice. For example suppose that, for your business model, two instances of Keyword are to be considered equal iff they have the same text field. Well, in such a case by defining the case class using the curried form you’ll get what you want. E.g.:
  val k4 = Keyword("restaurant")("storage", 1)
  val k5 = Keyword("restaurant")("web", 2)
  k4 == k5 // true!
  //  That’s because also the equals implementation, you get for free for case classes, only applies to the first parameter section, so only to text in this case. I’m not saying here that this is always the best choice but it could be of help in certain situations.
}
