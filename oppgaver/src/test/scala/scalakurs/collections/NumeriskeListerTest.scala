package scalakurs.collections

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class NumeriskeListerTest
  extends FunSuite
  with ShouldMatchers {

  // Range
  test("lag en range fra a til b") {
    val r = NumeriskeLister.lagRange(1, 7)
    assert(r contains 1)
    assert(r contains 7)
  }

  test("summer tallene fra 1 til 20") {
    NumeriskeLister.summerRange(1, 20) should be(210)
  }

  test("lag en funksjon (predikat) som sjekker om et gitt tall er et oddetall") {
    NumeriskeLister.oddetallP(11) should be (true)
    NumeriskeLister.oddetallP(20) should be (false)
  }

  test("lag en funksjon som tar en liste med heltall og returnerer oddetallene") {
    NumeriskeLister.filtrerOddetall(List(1, 2, 3, 4, 5)) should be(List(1, 3, 5))
  }

  test("lag en funksjon som tar en liste og returnerer en liste med oddetall og en liste med partall") {
    NumeriskeLister.delOddetallOgPartall(List(1, 2, 3, 4, 5, 6)) should be ((List(1, 3, 5), List(2, 4, 6)))
  }

  test("lag et predikat som sjekker om minst et av elementene i lista er et oddetall") {
    NumeriskeLister.detFinnesEtOddetall(List(2,4,6)) should be (false)
    NumeriskeLister.detFinnesEtOddetall(List(2,4,7)) should be (true)
  }

  test("lag et predikat som sjekker om alle elementene i en liste er oddetall") {
    NumeriskeLister.alleOddetallP(List(1,3,5)) should be (true)
    NumeriskeLister.alleOddetallP(List(1,5,9,4)) should be (false)
  }

  test("lag en funksjon som returnerer en list med alle lister som inneholder oddetall") {
    NumeriskeLister.filtrerListerSomInneholderOddetall(
      List(List(1, 3), List(2, 4), List(3, 4))) should be(List(List(1, 3), List(3, 4)))
  }

  test("lag en funksjon som returnerer en list med alle lister som kun inneholder oddetall") {
    NumeriskeLister.filtrerListerSomKunInneholderOddetall(
      List(List(1,3),List(2,4), List(3,4))) should be (List(List(1,3)))
  }

  test("lag en funksjon som returnerer en liste med oddetall") {
    NumeriskeLister.hentUtAlleOddetall(
      List(List(1,2),List(3,4),List(5,7))) should be (List(1,3,5,7))
  }

  test("lag en funksjon som lager partall av oddetall ved å legge til en") {
    NumeriskeLister.lagPartall(5) should be (6)
    NumeriskeLister.lagPartall(6) should be (6)
  }

  test("lag en funksjon som sørger for at alle tall i en liste blir partall") {
    NumeriskeLister.lagPartallsliste(List(1,2,3,4)) should be (List(2,2,4,4))
  }

  test("lag en funksjon som finner alle ekte divisorer til et gitt heltall") {
    NumeriskeLister.ekteDivisorer(10) should be (List(1,2,5))
  }

  test("lag et predikat som sjekker om et tall er et perfekt tall") {
    NumeriskeLister.perfektTallP(6) should be (true)
    NumeriskeLister.perfektTallP(10) should be (false)
  }
}
