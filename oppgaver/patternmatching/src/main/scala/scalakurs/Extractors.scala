package scalakurs

case class PhoneNumber(i18nPrefix: Int, number: Int)

object Int {
  def unapply(s: String) : Option[Int] = ???
}

object PhoneNumber {
  def unapply(str: String): Option[(Int, Int)] = ???
}