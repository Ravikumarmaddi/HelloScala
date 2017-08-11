package com.scala.demo.caseclass

import com.scala.demo.entities.Person

object ClassVSCaseClass2Demo extends App {
  val p = Person("Lacava", "Alessandro", 1976)
  val lastname = p.lastname
  // the following won't compile:
  //p.lastname = "Brown"

  val p_1 = Person("Brown", "John", 1969)
  val p_2 = Person("Lacava", "Alessandro", 1976)

  println(p == p_1) // false
  println(p == p_2)
  // true

  // the result is: Person(Lacava,Michele,1972), my brother :)
  // Capy - can fill the missing fields and override existing values.
  val p_3 = p.copy(firstname = "Michele", birthYear = 1972)
  println(p_3)

  // To extact perticular values from case class
  //Apart from being used in pattern matching the unapply method lets you deconstruct a case class to extract it’s fields, both during pattern matching and as a simple expression to extract some of its fields. E.g.:

  val Person(lastname1, _, _) = p
  println(lastname1)
  // prints Lacava

  // create Person object.
  val personCreator: (String, String, Int) => Person = Person.apply _

  // the result is: Person(Brown,John,1969)
  println(personCreator("Brown", "John", 1969))

  // What if you need a function that, given your case class arguments as parameters, creates an instance of the class? Here’s how you can do it by partially applying apply (no pun intended :)):
  val personCreator2: (String, String, Int) => Person = Person.apply _
  // the result is: Person(Brown,John,1969)
  personCreator("Brown", "John", 1969)

//  What if you want your function, from the previous point, to be curried? Enters the curried method:
  val curriedPerson: String => String => Int => Person = Person.curried
  val lacavaBuilder: String => Int => Person = curriedPerson("Lacava")
  println(lacavaBuilder("Alessandro")(1976))
  println(lacavaBuilder("Michele")(1972))



}
