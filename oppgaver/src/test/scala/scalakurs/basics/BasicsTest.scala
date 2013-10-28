package scalakurs.basics

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite

class BasicsTest extends FunSuite with ShouldMatchers {

  import Basics._

  /** Oppgave:
    *
    * Få testene under til å kompilere og kjøre grønt
    * De som er kommentert ut, må kommenteres inn.
    */

  test("Basics should contain a constant 'constant'") {
//    constant should be("Constant")
//    Basics.constant = "new value" // <- must not compile
  }

  test("Basics should contain a variable") {
//    variable should be("Variable")
//    Basics.variable = "new value"
//    variable should be("new value")
  }

  test("Say hello") {
    sayHello("Joe") should be("Hello, Joe!")
  }

  test("shout") (
    // Create method:
    //shout("hello") should be("HELLO")
  )

  test("unless is a method with two parameter sets") {
    // pass in an anonymous function that prints Hello World to the oncePerTime function
    // that should be executed every ten seconds
    // oncePerTime(...)(...)
  }

  test("method that adds two numbers") {
    add(1, 2) should be (3)
  }

  test("method that computes the square of a number") {
    square(9) should be (81)
  }

  test("method that computes the cube of an integer") {
    cube(3) should be (27)
  }

  test("compute the sum of ints between a and b") {
    // Hint: for-loop eller lineær rekursjon
    sumInt(1, 6) should be (21)
  }

  /** NB!: Ja, dette er vanskelig hvis du ikke har sett anonyme funksjoner før **/

  test("sum of cubes") {
    // Endre metodedeklarasjon til sum til å ta inn to parameterlister
    // en for f, og en for a og b

    // lag en metode sumCube som kombinerer metodene sum og cube
    // sumCubes(1, 3) should be(36)
  }

  test("sum of squares") {
    // lag en metode sumSquare som kombinerer sum og square, til sumSquare
    // sumSquares(1, 3) should be(12)
  }

  test("sum of id") {
    // reimplementer sumInt til å bruke sum-funskjonen med to parameterlister
  }

}
