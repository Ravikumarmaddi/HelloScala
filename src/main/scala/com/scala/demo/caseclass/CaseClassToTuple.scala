package com.scala.demo.caseclass

import com.scala.demo.entities.Person

/**
  * Created by ravikumar on 26/11/16.
  */
object CaseClassToTuple extends App {
  // Case Class to Tuple
  //What about obtaining a function that accepts a tuple whose arity is equal to the number of the case class
  // arguments, and produces an instance of the class? Well, there’s the tupled method for that:
  val tupledPerson: ((String, String, Int)) => Person = Person.tupled
  val meAsTuple: (String, String, Int) = ("Lacava", "Alessandro", 1976)
  val meAsPersonAgain: Person = tupledPerson(meAsTuple)

  // Tuple to Case Class
  //  You could also need a function that, given an instance of your class as input, produces
  // an Option[TupleN[A1, A2, ..., AN]] as output, where N is the number of the case class arguments
  // and A1, A2, ..., AN are their types. E.g.:
  val toOptionOfTuple: Person => Option[(String, String, Int)] = Person.unapply _
  // val x: Option[(String, String, Int)] = toOptionOfTuple(p) // Some((Lacava,Alessandro,1976))

}
