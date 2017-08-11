package com.scala.demo.tools

/**
  * Created by ravikumar on 6/2/17.
  */
object PrintFileHierarchy extends App{
  import java.io.File
  def recursiveListFiles(f: File): Array[File] = {
    val these = f.listFiles
    these ++ these.filter(_.isDirectory).flatMap(recursiveListFiles)
  }

  var loc = "/home/ravikumar/HOME/MAIN"
  var files = recursiveListFiles(new File(loc))
  files.foreach(println)

}
