package scalakurs

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MapOppgaverTest
  extends MapOppgaver
  with FunSuite
  with ShouldMatchers {

  test("lag et funksjon som lager et map med initiell verdi") {
    nyttMap(1, 4) == Map(1 -> 4)
  }

  test("lag en funksjon som legger til en assosiasjon i et eksisterende Map") {
    val m = Map(1 -> 2)

    leggTilAssosiasjon(2, 1, m)(2) should be(1)
  }

  test("lag en funksjon som tar bort assosiasjoner i en map som tilfredsstiller et predikat") {
    pending
  }

  test("lag en funksjon som endrer alle verdier i en map vha en funksjon") {
    pending
  }

  test("lag en funksjon som tar en liste med tupler og returnerer en map med default") {
    pending
  }

  test("map partition") {
    pending
  }

  test("map groupBy") {
    val personerGrupperPaKjonn: Map[Kjonn, List[Person]] = personer.groupBy(_.kjonn)
    println(personerGrupperPaKjonn.groupBy {
      case (k, v: List[Person]) => v.alk / 10
    }       )
  }

  test("lag en funksjon som først slår opp i Map A og hvis det ikke finnes der slår opp i Map B") {
    val mapA = Map(1 -> 2)
    val mapB = Map(2 -> 3)

    letMedFallbackMap(1, mapA, mapB) should be(2)
    letMedFallbackMap(2, mapA, mapB) should be(3)
  }
}

sealed trait Kjonn
case object Kvinne extends Kjonn
case object Mann extends Kjonn
case class Person(navn: String, alder: Int, kjonn: Kjonn)

class MapOppgaver {

  val personer =
    Person("Gudrun Klok", 70, Kvinne) ::
    Person("Halvar Freidig", 25, Mann) ::
    Person("John Holm", 50, Mann) ::
    Person("Jens Joner", 14, Mann) ::
    Person("Jarl Golden", 40, Mann) ::
    Person("Åse Øst", 30, Kvinne) ::
    Nil

  def nyttMap[A,B](a: A, b: B): Map[A,B] = Map(a -> b)

  def leggTilAssosiasjon[A,B](a: A, b:B, m: Map[A,B]): Map[A,B] = m + (a -> b)

//  def mapWithDefault[A,B](List((a:A, b:B)))

  def letMedFallbackMap[A,B](key: A, mapA: Map[A,B], mapB: Map[A,B]): B = (mapA orElse mapB)(key)
}