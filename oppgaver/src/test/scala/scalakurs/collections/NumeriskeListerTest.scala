package scalakurs.collections

import org.scalatest.matchers.ShouldMatchers
import scalakurs.typeclasses.FunSuiteHelper

class NumeriskeListerTest
  extends FunSuiteHelper
  with ShouldMatchers {

  val numeriskeLister = NumeriskeLister

  // Range
  test("lag en range fra a til b") {
    val r = numeriskeLister.lagRange(1, 7)
    assert(r contains 1)
    assert(r contains 7)
  }

  test("summer tallene fra 1 til 20") {
    numeriskeLister.summerRange(1, 20) should be(210)
  }

  test("lag en funksjon (predikat) som sjekker om et gitt tall er et oddetall") {
    numeriskeLister.oddetallP(11) should be (true)
    numeriskeLister.oddetallP(20) should be (false)
  }

  test("lag en funksjon som tar en liste med heltall og returnerer oddetallene") {
    numeriskeLister.filtrerOddetall(List(1, 2, 3, 4, 5)) should be(List(1, 3, 5))
  }

  test("lag en funksjon som tar en liste og returnerer en liste med oddetall og en liste med partall") {
    numeriskeLister.delOddetallOgPartall(List(1, 2, 3, 4, 5, 6)) should be ((List(1, 3, 5), List(2, 4, 6)))
  }

  test("lag et predikat som sjekker om minst et av elementene i lista er et oddetall") {
    numeriskeLister.detFinnesEtOddetall(List(2,4,6)) should be (false)
    numeriskeLister.detFinnesEtOddetall(List(2,4,7)) should be (true)
  }

  test("lag et predikat som sjekker om alle elementene i en liste er oddetall") {
    numeriskeLister.alleOddetallP(List(1,3,5)) should be (true)
    numeriskeLister.alleOddetallP(List(1,5,9,4)) should be (false)
  }

  test("lag en funksjon som returnerer en list med alle lister som inneholder oddetall") {
    numeriskeLister.filtrerListerSomInneholderOddetall(
      List(List(1, 3), List(2, 4), List(3, 4))) should be(List(List(1, 3), List(3, 4)))
  }

  test("lag en funksjon som returnerer en list med alle lister som kun inneholder oddetall") {
    numeriskeLister.filtrerListerSomKunInneholderOddetall(
      List(List(1,3),List(2,4), List(3,4))) should be (List(List(1,3)))
  }

  test("lag en funksjon som returnerer en liste med oddetall") {
    numeriskeLister.hentUtAlleOddetall(
      List(List(1,2),List(3,4),List(5,7))) should be (List(1,3,5,7))
  }

  test("lag en funksjon som lager partall av oddetall ved å legge til en") {
    numeriskeLister.lagPartall(5) should be (6)
    numeriskeLister.lagPartall(6) should be (6)
  }

  test("lag en funksjon som sørger for at alle tall i en liste blir partall") {
    numeriskeLister.lagPartallsliste(List(1,2,3,4)) should be (List(2,2,4,4))
  }

  bonus("lag en funksjon som finner alle ekte divisorer til et gitt heltall") {
    numeriskeLister.ekteDivisorer(10) should be (List(1,2,5))
  }

  bonus("lag et predikat som sjekker om et tall er et perfekt tall") {
    numeriskeLister.perfektTallP(6) should be (true)
    numeriskeLister.perfektTallP(10) should be (false)
  }
}
