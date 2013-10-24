package scalakurs.collections

object NumeriskeLister {
  def lagRange(a: Int, b: Int): Range = ???

  def summerRange(a: Int, b: Int): Int = ???

  def summerOddetall(a: Int, b: Int): Int  = ???

  def oddetallP(i: Int): Boolean = ???

  def filtrerOddetall(l: List[Int]): List[Int] = ???

  def delOddetallOgPartall(l: List[Int]): (List[Int], List[Int]) = ???

  def detFinnesEtOddetall(l: List[Int]): Boolean = ???

  def alleOddetallP(l: List[Int]): Boolean = ???

  def filtrerListerSomInneholderOddetall(l: List[List[Int]]): List[List[Int]] = ???

  def filtrerListerSomKunInneholderOddetall(l: List[List[Int]]): List[List[Int]] = ???

  // hint se på signaturen for å se hva denne metoden skal gjøre
  def filtrerOddetallLister(l: List[List[Int]]): List[Int] = ???

  def lagPartall(i: Int): Int = ???

  def lagPartallsliste(l: List[Int]): List[Int] = ???

  def ekteDivisorer(i: Int): List[Int] = ???

  // Et perfekt tall er et tall der summen av tallets alle ekte divisorer er lik tallet selv
  def perfektTallP(i: Int): Boolean = ???
}