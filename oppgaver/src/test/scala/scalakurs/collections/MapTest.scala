package scalakurs.collections

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MapOppgaverTest
  extends FunSuite
  with ShouldMatchers {

  test("lag et funksjon som lager et map med initiell verdi") {
    MapOppgaver.nyttMap(1, 4) === Map(1 -> 4)
  }

  test("lag en funksjon som legger til en assosiasjon i et eksisterende Map") {
    val map = Map(1 -> 2)

    MapOppgaver.leggTilAssosiasjon(map, 2, 1) should be(Map(1 -> 2, 2 -> 1))
  }

  test("lag en funksjon som tar en key og fjerner en assosiasjon i et eksisterende Map") {
    val map = Map(1 -> 2)

    MapOppgaver.taBortAssosiasjon(map, 1) should be(Map())
  }

  test("lag en funksjon som tar bort assosiasjoner i en map som tilfredsstiller et predikat") {
    val map = Map(1 -> 2, 2 -> 3)

    MapOppgaver.taBortAssosiasjon(map, (entry: (Int, Int)) => entry._2 == 3) should be(Map(1 -> 2))
  }

  test("lag en funksjon som endrer alle verdier i en map vha en funksjon") {
    val map = (1 to 10).map(i => (i,i)).toMap

    MapOppgaver.brukFunksjonPåAlleVerdier(map, (v: Int) => v * 7)(6) should be (42)
  }

  test("lag en funksjon som tar en liste med tupler og returnerer en map med default") {
    val map = MapOppgaver.mapMedDefault(List((1, 2), (2, 3)), 42)

    map(1) should be (2)
    map(10) should be (42)
  }

  test("lag en funksjon som først slår opp i Map A og hvis det ikke finnes der slår opp i Map B") {
    val mapA = Map(1 -> 2)
    val mapB = Map(1 -> 3, 2 -> 3)

    MapOppgaver.letMedFallbackMap(1, mapA, mapB) should be(2)
    MapOppgaver.letMedFallbackMap(2, mapA, mapB) should be(3)
  }
}

