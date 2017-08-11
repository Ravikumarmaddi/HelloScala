package com.scala.demo.common

import java.util.NoSuchElementException

/**
  * Created by ravikumar on 24/11/16.
  */
trait Suit {
  type ThisSuit <: Suit
  type PrevSuit <: Suit
  type NextSuit <: Suit

  def prev: PrevSuit
  def next: NextSuit
}

trait RedSuit extends Suit {
  type ThisSuit <: RedSuit
}
trait BlackSuit extends Suit {
  type ThisSuit <: BlackSuit
}

case object Hearts extends RedSuit {
  type ThisSuit = Hearts.type
  type PrevSuit = Nothing
  type NextSuit = Spades.type
  def prev = throw new NoSuchElementException
  def next = Spades
}
case object Spades extends BlackSuit {
  type ThisSuit = Spades.type
  type PrevSuit = Hearts.type
  type NextSuit = Diamonds.type
  def prev = Hearts
  def next = Diamonds
}
case object Diamonds extends RedSuit {
  type ThisSuit = Diamonds.type
  type PrevSuit = Spades.type
  type NextSuit = Clubs.type
  def prev = Spades
  def next = Clubs
}
case object Clubs extends BlackSuit {
  type ThisSuit = Clubs.type
  type PrevSuit = Diamonds.type
  type NextSuit = Nothing
  def prev = Diamonds
  def next = throw new NoSuchElementException
}