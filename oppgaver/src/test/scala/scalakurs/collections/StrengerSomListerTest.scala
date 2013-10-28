package scalakurs.collections

import org.scalatest.matchers.ShouldMatchers
import scalakurs.typeclasses.FunSuiteHelper

class StrengerSomListerTest extends FunSuiteHelper with ShouldMatchers {

  test("finn nummer på bokstav i alfabet") {
    StrengerSomLister.alfabetPosisjon('e') should be(4)
    StrengerSomLister.alfabetPosisjon('E') should be(4)
  }

  test("lag en funksjon som mapper fra tall til bokstav") {
    StrengerSomLister.alfabetBokstav(4) should be('e')
  }

  test("lag en funksjon som konverterer en list med char til en streng") {
    StrengerSomLister.listOfChars2String(List('a', 'b', 'c', 'd')) should be("abcd")
  }

  test("lag en funksjon som mapper fra en liste med tall til en streng") {
    StrengerSomLister.list2string(List(5, 8, 13, 13)) should be("finn")
  }

  test("lag funksjon som mapper fra streng til liste med nummer i alfabet") {
    StrengerSomLister.nummerIAlfabetStreng("FINN") should be(List(5, 8, 13, 13))
  }

  test("implementer rot13 for en char") {
    StrengerSomLister.rot13('a') should be('a' + 13)
    StrengerSomLister.rot13(StrengerSomLister.rot13('a')) should be('a')
    StrengerSomLister.rot13(StrengerSomLister.rot13('z')) should be('z')
    StrengerSomLister.rot13(' ') should be(' ')
  }

  test("implementer rot13") {
    StrengerSomLister.rot13("fgevat re ra pbyyrpgvba") should be("string er en collection")
  }
}
