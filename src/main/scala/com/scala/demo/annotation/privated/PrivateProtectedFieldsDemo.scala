package com.scala.demo.annotation.privated

/**
  * Created by ravikumar.m on 05-11-2016.
  */
class PrivateProtectedFieldsDemo {

}

package society {
  package professional {

    class Executive2 {
      private[professional] var workDetails = null
      private[society] var friends = null
      private[this] var secrets = null

      def help(another: Executive2, admin: Admin) {

        println(another.workDetails)
        //println(another.secrets) //ERROR
      }
    }

    class Admin {
      private[professional] var adminDetails = null
      private[society] var friends = null
      private[this] var secrets = null

      def help(another: Executive2, admin2: Admin) {

        println(another.workDetails)
        println(another.friends)
        admin2.printDetails(this)
        admin2.printSecrets(this)
        //println(another.secrets) //ERROR
      }
      def printDetails(another: Admin): Unit =
        println(this.adminDetails)
      def printSecrets(another: Admin): Unit =
        println(this.secrets)

    }

  }

  package education {

    class Student {
      protected[education] var studyDetails = null
      protected[society] var classfriends = null
      protected[this] var secrets = null

      def help(another: Student) {
        println(another.classfriends)
        another.print(this)
        //println(another.secrets) //ERROR
      }

      def print(another: Student): Unit =
        println(this.classfriends)

    }

  }

}
