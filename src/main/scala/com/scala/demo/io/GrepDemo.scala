package com.scala.demo.io

/**
  * Created by ravikumar on 12/3/17.
  */
object GrepDemo extends App{

  val fu = new FileUtils()
  val fileNm = "/home/ravikumar/dev/HelloScala/src/main/scala/com/scala/demo/io/test.txt"
  fu.grep(".*aaa.*", new java.io.File(fileNm))

}

class FileUtils {

  def grep(pattern: String, file: java.io.File) =
    for (
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file +": "+ line.trim)

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  def filterFiles(folder:java.io.File, extension: String) =
    for {
      file <- folder.listFiles()
      if file.getName.endsWith(".scala")
    } yield file

}
