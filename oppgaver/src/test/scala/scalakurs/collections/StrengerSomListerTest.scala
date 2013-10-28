package scalakurs.collections

import org.scalatest.matchers.ShouldMatchers
import scalakurs.typeclasses.FunSuiteHelper

class StrengerSomListerTest extends FunSuiteHelper with ShouldMatchers {

  val strengerSomLister = StrengerSomLister

  test("finn nummer på bokstav i alfabet") {
    strengerSomLister.alfabetPosisjon('e') should be(4)
    strengerSomLister.alfabetPosisjon('E') should be(4)
  }

  test("lag en funksjon som mapper fra tall til bokstav") {
    strengerSomLister.alfabetBokstav(4) should be('e')
  }

  test("lag en funksjon som konverterer en list med char til en streng") {
    strengerSomLister.listOfChars2String(List('a', 'b', 'c', 'd')) should be("abcd")
  }

  test("lag en funksjon som mapper fra en liste med tall til en streng") {
    strengerSomLister.list2string(List(5, 8, 13, 13)) should be("finn")
  }

  test("lag funksjon som mapper fra streng til liste med nummer i alfabet") {
    strengerSomLister.nummerIAlfabetStreng("FINN") should be(List(5, 8, 13, 13))
  }

  test("implementer rot13 for en char") {
    strengerSomLister.rot13('a') should be('a' + 13)
    strengerSomLister.rot13(strengerSomLister.rot13('a')) should be('a')
    strengerSomLister.rot13(strengerSomLister.rot13('z')) should be('z')
    strengerSomLister.rot13(' ') should be(' ')
  }

  test("implementer rot13") {
    strengerSomLister.rot13("fgevat re ra pbyyrpgvba") should be("string er en collection")
  }
}
