package com.scala.demo.patternmatching

/**
  * Created by ravikumar on 17/11/16.
  */
object CaseClassPMDemo extends  App {
  case class Student(name: String, email: String)

  def matchStudent1(student: Student): String = student match {
    case Student(name, email) => s"$name has the following email: $email" // extract name and email
  }
  //All the normal rules of pattern-matching apply - you can use guards and constant expressions to control matching:

  def matchStudent2(student: Student): String = student match {
    case Student("Paul", _) => "Matched Paul" // Only match students named Paul, ignore email
    case Student(name, _) if name == "Paul" => "Matched Paul" // Use a guard to match students named Paul, ignore email
    case s if s.name == "Paul" => "Matched Paul" // Don't use extractor; use a guard to match students named Paul, ignore email
    case Student("Joe", email) => s"Joe has email $email" // Match students named Joe, capture their email
    case Student(name, email) if name == "Joe" => s"Joe has email $email" // use a guard to match students named Joe, capture their email
    case Student(name, email) => s"$name has email $email." // Match all students, capture name and email
  }
}
