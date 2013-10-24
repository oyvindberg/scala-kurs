package scalakurs.patternmatching

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ExtractorsTest extends FunSuite with ShouldMatchers {

  test("Exercise 1: Int.unapply") {
    assert(Extractors.Int.unapply("1") == Some(1))
    assert(Extractors.Int.unapply("a") == None)
  }

  test("Exercise 2: PhoneNumber.unapply") {
    val prefix = 47
    val number = 22048700
    assert(Extractors.PhoneNumber.unapply(prefix + " " + number ) == Some((prefix, number)))
    assert(Extractors.PhoneNumber.unapply("asdf" + " " + number ) == Some(None))
  }
}
