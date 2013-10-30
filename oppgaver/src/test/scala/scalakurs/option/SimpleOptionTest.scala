package scalakurs.option

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SimpleOptionTest extends FunSuite with ShouldMatchers {
  // hvis s er null skal funksjonen returnere None
  // hvis s ikke er null skal den returnere Some(s)
  def wrapPossibleNull(s: String): Option[String] = ???

  test("translate null to None") {
    wrapPossibleNull(null) should be (None)
  }

  test("translate \"not null\" to Some(\"not null\"") {
    wrapPossibleNull("not null") should be (Some("not null"))
  }

  ////////////////////

  def getSomeValueOrProvidedDefaultValue(opt: Option[String], defaultValue: String): String = {
    ???
  }

  test("change None to \"default value\"") {
    getSomeValueOrProvidedDefaultValue(Option(null), "default value") should be ("default value")
  }

  ////////////////////

  // hvis begge tallene er definert (Some) skal Some(a+b) returneres
  // hvis minst en av tallene er None skal None returneres
  def addOptionalInts(a: Option[Int], b: Option[Int]): Option[Int] = ???

  test("add to optional numbers") {
    addOptionalInts(Some(1), Some(2)) should be (Some(3))
    addOptionalInts(None, Some(1)) should be (None)
    addOptionalInts(None, None) should be (None)
    addOptionalInts(Some(1), None) should be (None)
  }

  ////////////////////

  case class Person(name: String, age: Int)

  // hvis alle verdiene er definert (Some) så skal Some(Person(...)) returneres
  // hvis minst en av verdiene er None skal None returneres
  def createPerson(optionalName: Option[String], optionalAge: Option[Int]): Option[Person] = ???

  test("create person from optional values") {
    createPerson(Some("Kåre"), None) should be (None)
    createPerson(None, Some(12)) should be (None)
    createPerson(None, None) should be (None)
    createPerson(Some("Die Wenche"), Some(66)) should be (Some(Person("Die Wenche", 66)))
  }
}

