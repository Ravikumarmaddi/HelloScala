package com.scala.demo.patternmatching

/**
  * Created by ravikumar on 19/11/16.
  */
object StablePMDemo {

//  Pattern Matching With Stable Identifier
//  In standard pattern matching, the identifier used will shadow any identifier in the enclosing scope. Sometimes it is necessary to match on the enclosing scope's variable.
//
//    The following example function takes a character and a list of tuples and returns a new list of tuples. If the character existed as the first element in one of the tuples, the second element is incremented. If it does not yet exist in the list, a new tuple is created.

  def tabulate(char: Char, tab: List[(Char, Int)]): List[(Char, Int)] = tab match {
    case Nil => List((char, 1))
    case (`char`, count) :: tail => (char, count + 1) :: tail
    case head :: tail => head :: tabulate(char, tail)
  }

//  println(tabulate('A', List(("aaaaaaaaaa",1),("bbbbbbbbbbbbbb",2))))
//  The above demonstrates pattern matching where the method's input, char, is kept 'stable' in the pattern match: that is, if you call tabulate('x', ...), the first case statement would be interpreted as:
//
//  case('x', count) => ...
//  Scala will interpret any variable demarcated with a tick mark as a stable identifier: it will also interpret any variable that starts with a capital letter in the same way.
}
