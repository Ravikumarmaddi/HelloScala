package com.scala.demo.traits

import java.util.Calendar

import sun.util.calendar.Gregorian.Date

/**
  * Created by ravikumar.m on 23-10-2016.
  */
trait TraitMethodDemo {

  val StartOfYear = Calendar.getInstance()
  val EndOfYear = Calendar.getInstance()

  def printTimeGap() {
    println(EndOfYear.toString + StartOfYear)
  }
}
