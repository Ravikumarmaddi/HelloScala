package com.scala.demo.traits

/**
  * Created by ravikumar.m on 23-10-2016.
  */

trait PeriodA {
  def start: Long
  def stop: Long
  def description: String
  def manageTo: String
}

case class CaseClassExtendsTraits(
                         start: Long,
                         stop: Long,
                         description: String,
                         manageTo: String)
  extends PeriodA
