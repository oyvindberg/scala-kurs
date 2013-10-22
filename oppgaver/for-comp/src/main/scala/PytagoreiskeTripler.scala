/**
 * Et pytagoreisk trippel er (a, b, c) der
 * a^2 + b^2 = c^2 og
 * a < b < c
 */
object PytagoreiskeTripler {
  implicit class IntWithPower(i: Int) {
    def **(pow: Int) = math.pow(i, pow)
  }

  def regnUt = for {
    a <- 1 to 100
    b <- 1 to 100 if a < b
    c <- 1 to 100 if b < c
    if a ** 2 + b ** 2 == c ** 2
  } yield (a, b, c)
}

