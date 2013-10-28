package scalakurs.basics.solutions

object Basics {

  def sayHello(to: String): String = s"Hello, $to!"

  def add(a: Int, b: Int): Int = a + b

  def sumInt(a: Int, b: Int): Int = if (a > b) 0 else a + sumInt(a + 1, b)

  def square(x: Int): Int = x * x

  def cube(x: Int): Int = x * x * x

  def shout(s: String) = s.toUpperCase

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)

  def sumCubes: (Int, Int) => Int  = ???
  def sumSquares = ???
  // def sumInt     = ???

  def id(x: Int): Int = x

}

