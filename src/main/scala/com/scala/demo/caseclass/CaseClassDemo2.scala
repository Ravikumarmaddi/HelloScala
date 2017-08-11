package com.scala.demo.caseclass

/**
  * Created by ravikumar on 26/4/17.
  */
object CaseClassDemo2 extends App {

     val col = Seq(Emp(1,"aaaa"),Emp(2,"bbbb"),Emp(3),Stu(1,"aaaa"),Stu(2,"bbbb"), Stu(3))

     col.foreach{ data => data match{
       case Emp(_,n) => println(s"name: $n"  );  // println(data.id) // error - You can access data, but you can not access its fileds(id, name)
       case Emp(id,_) => println(s"Id: $id") // what are the valures you want to use, those you have to give some name(line n here).
      // case Emp(n) => println(s"name: $n") // error: you have to pass all perameters.
     }}
}
trait Org
case class Emp (id:Int, name:String="") extends Org
case class Stu (id:Int, name:String="") extends Org


