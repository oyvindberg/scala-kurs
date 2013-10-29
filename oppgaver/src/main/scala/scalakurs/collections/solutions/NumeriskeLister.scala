package scalakurs.collections.solutions

object NumeriskeLister {
  def lagRange(a: Int, b: Int): Range = a to b

  def summerRange(a: Int, b: Int): Int = (a to b).sum

  def oddetallP(i: Int): Boolean = i % 2 == 1

  def filtrerOddetall(l: List[Int]): List[Int] = l.filter(oddetallP)

  // hint: partition
  def delOddetallOgPartall(l: List[Int]): (List[Int], List[Int]) = l.partition(oddetallP)

  def detFinnesEtOddetall(l: List[Int]): Boolean = l.exists(oddetallP)

  def alleOddetallP(l: List[Int]): Boolean = l.forall(oddetallP)

  def filtrerListerSomInneholderOddetall(l: List[List[Int]]): List[List[Int]] =
    l.filter(detFinnesEtOddetall)

  def filtrerListerSomKunInneholderOddetall(l: List[List[Int]]): List[List[Int]] =
    l.filter(alleOddetallP)

  // hint se på signaturen for å se hva denne metoden skal gjøre
  def hentUtAlleOddetall(l: List[List[Int]]): List[Int] =
    l.map(indreliste => indreliste.filter(oddetallP)).flatten

  def lagPartall(i: Int): Int = if (oddetallP(i)) i + 1 else i

  def lagPartallsliste(l: List[Int]): List[Int] = l.map(lagPartall)

  // ekteDivisor == faktor
  // ekteDivisor(21) == List(1, 3, 7)
  def ekteDivisorer(i: Int): List[Int] = (for (d <- 1 until i if i % d == 0) yield d).toList

  // Et perfekt tall er et tall der summen av tallets alle ekte divisorer er lik tallet selv
  def perfektTallP(i: Int): Boolean = ekteDivisorer(i).sum == i
}