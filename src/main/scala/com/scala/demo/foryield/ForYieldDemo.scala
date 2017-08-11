package com.scala.demo.foryield

/**
  * Created by ravikumar.m on 16-10-2016.
  */
class ForYieldDemo {

}

class State(val code: String, val desc: String, val loc: Symbol) {
  override def toString = desc
}

object ForYieldDemo extends App {
  val states = List(new State("DC", "District of Columbia", 'east),
    new State("VA", "Virginia", 'east),
    new State("MD", "Maryland", 'east),
    new State("CA", "California", 'west),
    new State("OK", "Oklahoma", 'midwest),
    new State("NE", "Nebraska", 'midwest),
    new State("AL", "Alabama", 'south))

  val noEastCoast =
    for (state <- states if state.loc != 'east || state.code == "DC")
      yield state

  println(noEastCoast)
  val sisters = for (state1 <- states;
                     state2 <- states if state1.loc != state2.loc)
    yield (state1, state2)
  for (state <- states if !done) if (state.code == "DC")  done = true

  for (state <- states if state.loc != 'east || state.code == "DC")
    println(state)
  var done = false

}