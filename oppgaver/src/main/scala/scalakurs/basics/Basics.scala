package scalakurs.basics

object Basics {

  def sayHello(to: String): String = ??? // s"Hello, $to!"

  def add(a: Int, b: Int): Int = ???

  def sumInt(fromInclusive: Int, toInclusive: Int): Int = ???

  def square(x: Int): Int = ???

  def cube(x: Int): Int = ???

  def squareAndCube(x: Int): (Int, Int) = ???

  def oncePerTime(seconds: Long)(callback: () => Unit) {
    while (true) { callback(); Thread.sleep(seconds * 1000) }
  }

  // use this method in the following implementations
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)

  def sumCubes: (Int, Int) => Int  = sum(cube)
  def sumSquares = ???
  def sumInt     = {
    def identity(x: Int): Int = x

    ???
  }
}
