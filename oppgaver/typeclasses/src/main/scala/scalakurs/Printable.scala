package scalakurs

trait Printable[A] {
  def print(a: A): String
}

object Print
