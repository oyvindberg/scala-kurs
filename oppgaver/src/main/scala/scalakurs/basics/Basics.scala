package scalakurs.basics

object Basics {
  def sayHello(to: String): String = ???

  def shout (u: String): String = ???

  def add(a: Int, b: Int): Int = ???

  /* hint: Int.to() kan gi en fin løsning */
  def sumInt(fromInclusive: Int, toInclusive: Int): Int = ???

  def square(x: Int): Int = ???

  def cube(x: Int): Int = ???

  def squareAndCube(x: Int): (Int, Int) = ???

  // use this method in the following implementations
  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)

  def sumSquares = ???

  def sumIntNew  = {
    /* hint */
    def identity(x: Int): Int = x
    ???
  }
}
