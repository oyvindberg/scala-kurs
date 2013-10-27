package scalakurs.functional

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class FunctionalTest extends FunSuite with ShouldMatchers {


  // Fibonacci: 0, 1, 1, 2, 3, 5, 8

  test("find the nth fibonacci number, imperative style") {
    Functional.imperativeFib(1) should be (0)
    Functional.imperativeFib(6) should be (5)
    Functional.imperativeFib(4) should be (2)
  }


  // Oppgave: Implementer resten av funksjonen for å regne ut fakultet
  test("faculty") {
    Functional.factorial(1) should be(1)
    Functional.factorial(5) should be(120)
    Functional.factorial(6) should be(720)
  }


  // Oppgave: Implementer en rekursiv variant som finner det n-te fibonacci-tallet
  test("find the nth fibonacci number") {
    Functional.fib(1) should be (0)
    Functional.fib(6) should be (5)
    Functional.fib(4) should be (2)
  }




}
