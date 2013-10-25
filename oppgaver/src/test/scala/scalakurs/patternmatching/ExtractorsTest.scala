package scalakurs.patternmatching

import org.scalatest.{FunSpec, FunSuite}
import org.scalatest.matchers.ShouldMatchers

class ExtractorsTest extends FunSpec with ShouldMatchers {

  describe("Exercise 1: Int.unapply") {
    it("(\"1\") should return Some(1)") {assert(Extractors.Int.unapply("1") == Some(1))}
    it("(\"a\") should return None") {assert(Extractors.Int.unapply("a") == None)}
  }

  describe("Exercise 2: PhoneNumber.unapply") {
    val prefix = 47
    val number = 22048700
    it("(\"4722048700\") should return None") {assert(Extractors.PhoneNumber.unapply(prefix.toString + number.toString) == None)}
    it("(\"47 22048700\") should return" + s"Some(($prefix, $number))") {assert(Extractors.PhoneNumber.unapply(prefix + " " + number ) == Some((prefix, number)))}
    it("(\"asdf 22048700\") should return None") {assert(Extractors.PhoneNumber.unapply("asdf" + " " + number) == None)}
  }
}
