package com.scala.demo.basics

//1. General Ways
// import one class
import java.io.File

// import every class in a package
import java.io._

// import multiple classes from a package (version 1)
import java.io.{File, IOException, FileNotFoundException}

// import multiple classes from a package (version 2)
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException


//2. You can give a class a new name (or alias) when you import it:
import java.util.{List => UtilList}
import java.awt.{List => AwtList}

//3. Exclude (Hiding) classes during import
//You can hide one or more classes while importing others. The following example hides the Random class, while importing everything else from the java.util package:
import java.util.{Random => _, _}

//4. The equivalent of Java’s static import
//You can import members in a way similar to the Java static import approach:

import java.lang.Math._

object ImportsMagicDemo {
  val list = new AwtList
  // val r = new Random  // --  error: not found: type Random, Becuase you excluded Random class.
  val a = sin(0)
  val b = cos(PI)

}
