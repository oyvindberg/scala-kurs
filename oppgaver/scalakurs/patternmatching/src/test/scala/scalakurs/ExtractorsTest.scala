package scalakurs

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ExtractorsTest extends FunSuite with ShouldMatchers {

  test("Unapply telefonnummer-streng til et PhoneNumber-objekt") {
    val prefix = 47
    val number =  22048700
      prefix + " " + number match {
        case PhoneNumber(47, 22048700) => assert(true)
        case _ => assert(false, s"Forventet et PhoneNumber-objekt med prefiks $prefix og nummber $number.")
      }
  }
}
