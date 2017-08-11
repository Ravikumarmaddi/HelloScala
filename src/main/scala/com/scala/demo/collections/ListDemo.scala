package com.scala.demo.collections

object ListDemo {
  def main(args: Array[String]): Unit = {
    mkSringDemo
    //mapDemo
    // emptyList()

  }

  def mapDemo: Unit = {
    val fruit = List("apple", "orange", "pear")
    val fruits = fruit.map(S => S + "s")
    println(fruits)

  }

  def mkSringDemo: Unit = {
    val fruit = List("apple", "orange", "pear")
    val fruits = fruit.mkString(", ")
    println(fruits)

  }

  def sortDemo: Unit = {
    val fruit = List("apple", "orange", "pear")
    val afruit = fruit.sortWith((s, t) =>
      s.charAt(0).toLower <
        t.charAt(0).toLower)

    println(afruit)

  }

  def listDemo {
    println("Simple way of defining List")


    val fruit1 = List("apples", "oranges", "pears")
    val nums1 = List(1, 2, 3, 4)
    val diag1 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
    val empty1 = List()

    println(fruit1)
    println(nums1)
    println(diag1)
    println(empty1)
    println()

    println("Specifying content type of List elements")
    val fruit2: List[String] = List("apples", "oranges", "pears")
    val nums2: List[Int] = List(1, 2, 3, 4)
    val diag2: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
    val empty2: List[Nothing] = List()

    println(fruit2)
    println(nums2)
    println(diag2)
    println(empty2)
    println()

    println("List Concatenation")
    val nums3 = List(1, 3, 5)
    val nums4 = List(2, 4, 6)
    val nums5 = nums3 ::: nums4

    println(nums5)

    val nums6 = nums4 :+ nums5 // low performance
    val nums7 = nums4 :: nums5 // High performance.

    println(nums6)

    println("Map operation on List")

    println(List().isEmpty)
    println(List(1).nonEmpty)

    val l = List(1, 2, 3, 10, 55, 100)
    println(l.head)
    println(l.tail)
    println(l.headOption)
    println(l.lastOption)
    // println(l.find(true))
    println(List(-2, -1, 0, 1, 2).filter(num => num > 0))
    println(List(-2, -1, 0, 1, 2).partition(num => num < 0))
    println(List(1, 2, 3, 4).forall(num => num > 0)) // = true, all numbers are positive
    println(List(-3, -2, -1, 1).forall(num => num < 0)) // = false, not all numbers are negative)
    println(l(1))
    println(l(7)) //index out of bound error.
    println(0 :: l) //Prepend Elements
    println(l :+ 200) //Append Elements
    println(List(1, 2) ::: List(3, 4)) // List(1, 2, 3, 4)
    println(List.concat(List(1, 2), List(3, 4))) // List(1, 2, 3, 4)
    println(List(1, 2) ++ List(3, 4)) // List(1, 2, 3, 4)

    println("\nCommon operations")

    println(List(1, 2, 3).find(_ == 3)) // Some(3)
    println(List(1, 2, 3).map(_ * 2)) // List(2, 4, 6)
    println(List(1, 2, 3).filter(_ % 2 == 1)) // List(1, 3)
    println(List(1, 2, 3).fold(0)((acc, i) => acc + i * i)) // 1 * 1 + 2 * 2 + 3 * 3 = 14
    println(List(1, 2, 3).foldLeft("Foo")(_ + _.toString)) // "Foo123"
    println(List(1, 2, 3).foldRight("Foo")(_ + _.toString)) // "123Foo"
    println()
    println()
    println()
    println()
    println()
    println()
  }

  /* def squareList1(xs: List[Int]): List[Int] = xs match {
     case Nil => Nil
     case y :: ys => y * y :: squareList1(ys)
   }*/

  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x * x)

  def emptyList(): Unit = {
    // Empty lists
    val el1 = List()
    val el2 = List(Nil)

    println(el1)
    println(el2)

    println(el1.length)
    println(el2.length)

  }
}