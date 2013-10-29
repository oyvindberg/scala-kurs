package scalakurs.patternmatching.solutions

object Extractors {

  // Exercise 1: Implement Int.unapply.
  // Hint: Check if String is numeric in scala: input.forall(_.isDigit)
  object Int {
    def unapply(s: String): Option[Int] = if (s.forall(_.isDigit)) Some(s.toInt) else None
  }

  // Exercise 2: Implement PhoneNumber.unapply, which takes
  // strings representing telephone numbers. Example string:
  // "47 22048700"
  //
  // Neither the prefix nor the number needs to be checked for any specific
  // length, all we're assuming is that a phone number is two numbers separated by a whitespace.
  //
  // Hint: The Int.unapply extractor from exercise 1 is useful for converting a String to an Int.
  object PhoneNumber {
    def unapply(str: String): Option[(Int, Int)] = str.split(" ") match {
      case Array(Int(prefix), Int(num)) => Some((prefix, num))
      case _ => None
    }
  }

}