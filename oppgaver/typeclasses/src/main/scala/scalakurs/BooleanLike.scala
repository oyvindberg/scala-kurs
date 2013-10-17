package scalakurs

trait BooleanLike[A] {
  def asBoolean(a: A): Boolean
}

object BooleanLike {

  implicit val intBooleanLike = new BooleanLike[Int] {
    def asBoolean(a: Int) = a == 1
  }

  implicit val stringBooleanLike = ???

  implicit val optionBooleanLike = ???

  /**
   * Get a hold of the implicit by adding a parameter list
   * or by calling {{implicitly}}
   */
  def asBoolean[A](a: A): Boolean = ???

  implicit class AsBoolean[???](a: ???)(implicit bla: ???) {
    def boolean: Boolean = ???
  }
}

