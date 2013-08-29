package scalakurs

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite

class StrengerSomListerTest
  extends StrengerSomLister
  with FunSuite
  with ShouldMatchers {

  test("finn nummer på bokstav i alfabet") {
    char2int('e') should be(4)
    char2int('E') should be(4)
  }

  test("lag en funksjon som mapper fra tall til bokstav") {
    int2char(4) should be('e')
  }

  test("lag en funksjon som konverterer en list med char til en streng") {
    listOfChars2String(List('a', 'b', 'c', 'd')) should be("abcd")
  }

  test("lag en funksjon som mapper fra en liste med tall til en streng") {
    list2string(List(5, 8, 13, 13)) should be("finn")
  }

  test("lag funksjon som mapper fra streng til liste med nummer i alfabet") {
    nummerIAlfabetStreng("FINN") should be(List(5, 8, 13, 13))
  }

  test("implementer rot13 for en char") {
    rot13('a') should be('a' + 13)
    rot13(rot13('a')) should be('a')
    rot13(rot13('z')) should be('z')
    rot13(' ') should be(' ')
  }

  test("implementer rot13") {
    rot13("fgevat re ra pbyyrpgvba") should be("string er en collection")
  }
}

class StrengerSomLister {
  val engelskAlfabet = 'a' to 'z'

  def char2int(c: Char): Int = engelskAlfabet.indexOf(c.toLower)

  def int2char(i: Int): Char = engelskAlfabet(i)

  def listOfChars2String(l: List[Char]): String = l.mkString

  def list2string(l: List[Int]): String = l.map(int2char).mkString

  def nummerIAlfabetStreng(s: String): List[Int] = s.map(char2int).toList

  def rot13(c: Char): Char = c match {
    case ' ' => ' '
    case _ =>
      int2char((char2int(c) + 13) % 26)
  }

  def rot13(s: String): String = s.map(rot13)
}
