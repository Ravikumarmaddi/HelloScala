package com.scala.demo.common

/**
  * Created by ravikumar.m on 22-10-2016.
  */
class ProtectedDemo {

}

/*The protected keyword:

the protected keyword in scala has a different meaning than in java
protected means current class and subclasses can access member
unlike java, other classes in package can’t access member
Example:*/

package foo {

  class Foo {
    // (1) make 'getFoo' protected.
    protected def getFoo = "foo"
  }

  class FooSub extends Foo {
    def doFoo = {
      // (2) we can access getFoo because we're a subclass of Foo
      val x = getFoo
    }
  }
  class Bar {
    def doBar = {
      val f = new Foo
      // (3) this line won't compile because getFoo is protected
      //f.getFoo
    }
  }

}

package baz {

  import foo.Foo
  class Baz {
    def doBaz = {
      val f = new Foo
      // (4) this won't work either
      //f.getFoo
    }
  }

}