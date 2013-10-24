package scalakurs.typeclasses

trait BooleanLike[A] {
  def asBoolean(a: A): Boolean
}

object BooleanLike {

  implicit lazy val intBooleanLike = new BooleanLike[Int] {
    def asBoolean(a: Int) = a != 0
  }

  implicit lazy val stringBooleanLike: BooleanLike[String] = ???

  implicit lazy val optionBooleanLike: BooleanLike[Option[_]] = ???

  /**
   * Get a hold of the implicit by adding a parameter list
   * or by calling {{implicitly}}
   */
  def asBoolean[A](a: A)(implicit bla: BooleanLike[A]) = bla.asBoolean(a)

  /**
   * Will this suffice for a container (M[_]) type?
   */
  implicit class AsBoolean[???](a: ???) {
    def boolean: Boolean = ???
    def mboolean: Boolean = ???
  }
}

