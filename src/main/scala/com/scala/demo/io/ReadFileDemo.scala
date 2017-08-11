package com.scala.demo.io

import scala.io.Source

/**
  * Created by ravikumar on 7/3/17.
  */
object ReadFileDemo extends App {
  val file = "/home/ravikumar/dev/HelloScala/src/main/scala/com/scala/demo/io/test.txt"
  for (line <- Source.fromFile(file).getLines())
    println(line.length + " " + line)
  Console.out.println("Please enter filename")
}
