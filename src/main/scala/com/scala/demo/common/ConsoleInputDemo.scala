package com.demo.common

/**
  * Created by ravikumar on 16/11/16.
  */
object ConsoleInputDemo extends App {
  println("Hello World!")
  for {
    arg <- this.args
  } println(s"Arg=$arg")
}
