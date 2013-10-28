package scalakurs.basics

object Basics {

  def sayHello(to: String): String = ??? // s"Hello, $to!"

  def add(a: Int, b: Int): Int = ???

  def sumInt(a: Int, b: Int): Int = ???

  def square(x: Int): Int = ???

  def cube(x: Int): Int = ???

  def oncePerTime(seconds: Long)(callback: () => Unit) {
    while (true) { callback(); Thread.sleep(seconds * 1000) }
  }

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)

//  def sum(f: Int => Int)(a: Int, b: Int): Int = {
//    if (a > b) 0 else f(a) + sum(f)(a + 1, b)
//  }

  def sumCubes: (Int, Int) => Int  = ???
  def sumSquares = ???
  def sumInt     = ???

  def id(x: Int): Int = x

}
