package scalakurs

case class PhoneNumber(i18nPrefix: Int, number: Int)

object PhoneNumber {
  def unapply(str: String): Option[(Int, Int)] = ???
}