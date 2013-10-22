class ForComprehensions {
  implicit class IntWithPower(i: Int) {
    def **(pow: Int) = math.pow(i, pow)
  }

  def alleFaktorerAv(x: Int): Seq[Int] = for {
    f <- 1 to x if x % f == 0
  } yield f

  /**
   * Et pytagoreisk trippel er (a, b, c) der
   * a^2 + b^2 = c^2 og
   * a < b < c
   *
   * ekstra utfordring: skriv hele metoden som _en_ for-comprehension
   */
  def pytagoreiskeTripler: Seq[(Int, Int, Int)] = for {
    a <- 1 to 100
    b <- 1 to 100 if a < b
    c <- 1 to 100 if b < c
    if a ** 2 + b ** 2 == c ** 2
  } yield (a, b, c)
}

