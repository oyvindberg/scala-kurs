package scalakurs

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class NumeriskeListerTest
  extends NumeriskeLister
  with FunSuite
  with ShouldMatchers {

  // Range
  test("lag en range fra a til b") {
    val r = lagRange(1, 7)
    assert(r contains 1)
    assert(r contains 7)
  }

  test("summer tallene fra 1 til 20") {
    summerRange(1, 20) should be(210)
  }

  test("summer alle oddetall mellom 1 og 200 (hint: step)") {
    summerOddetall(1, 200) should be(10000)
  }

  test("lag en funksjon (predikat) som sjekker om et gitt tall er et oddetall") {
    oddetallP(11) should be (true)
    oddetallP(20) should be (false)
  }

  test("lag en funksjon som tar en liste med heltall og returnerer oddetallene") {
    filtrerOddetall(List(1, 2, 3, 4, 5)) should be(List(1, 3, 5))
  }

  test("lag en funksjon som tar en liste og returnerer en liste med oddetall og en liste med partall") {
    delOddetallOgPartall(List(1, 2, 3, 4, 5, 6)) should be ((List(1, 3, 5), List(2, 4, 6)))
  }

  test("lag et predikat som sjekker om minst et av elementene i lista er et oddetall") {
    detFinnesEtOddetall(List(2,4,6)) should be (false)
    detFinnesEtOddetall(List(2,4,7)) should be (true)
  }

  test("lag et predikat som sjekker om alle elementene i en liste er oddetall") {
    alleOddetallP(List(1,3,5)) should be (true)
    alleOddetallP(List(1,5,9,4)) should be (false)
  }

  test("lag en funksjon som returnerer en list med alle lister som inneholder oddetall") {
    filtrerListerSomInneholderOddetall(List(List(1, 3), List(2, 4), List(3, 4))) should be(List(List(1, 3), List(3, 4)))
  }

  test("lag en funksjon som returnerer en list med alle lister som kun inneholder oddetall") {
    filtrerListerSomKunInneholderOddetall(List(List(1,3),List(2,4), List(3,4))) should be (List(List(1,3)))
  }

  test("lag en funksjon som returnerer en liste med oddetall") {
    filtrerOddetallLister(List(List(1,2),List(3,4),List(5,7))) should be (List(1,3,5,7))
  }

  test("lag en funksjon som lager partall av oddetall ved å legge til en") {
    lagPartall(5) should be (6)
    lagPartall(6) should be (6)
  }

  test("lag en funksjon som sørger for at alle tall i en liste blir partall") {
    lagPartallsliste(List(1,2,3,4)) should be (List(2,2,4,4))
  }

  test("lag en funksjon som finner alle divisorer til et gitt heltall") {
    divisorer(10) should be (List(1,2,5))
  }

  test("lag et predikat som sjekker om et tall er et perfekt tall") {
    perfektTallP(6) should be (true)
    perfektTallP(10) should be (false)
  }

  test("finn det fjerde perfekte tallet (6 er det forste)") {
    (6 to 10000).view.filter(perfektTallP).take(4).last should be (8128)
  }
}
