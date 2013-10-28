package scalakurs.for_comprehensions

object ForComprehensions {
  implicit class IntWithPower(i: Int) {
    def **(pow: Int) = math.pow(i, pow)
  }

  def alleFaktorerAv(x: Int): Seq[Int] = ???

  /**
   * Et pytagoreisk trippel er (a, b, c) der
   * a ** 2 + b ** 2 = c ** 2 og
   * a < b < c
   *
   * Hint: begynn med å generere alle permutasjoner av (a, b, c) der
   * a, b og c er mellom 1 og 100. Filtrer deretter bort ett og ett kriterie.
   *
   * ekstra utfordring: skriv hele metoden som _en_ for-comprehension
   */
  def pytagoreiskeTripler: Seq[(Int, Int, Int)] = ???

}

