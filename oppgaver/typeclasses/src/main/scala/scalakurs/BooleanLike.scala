package scalakurs

trait BooleanLike[A] {
  def asBoolean(a: A): Boolean
}

object BooleanLike {

  implicit val intBooleanLike = new BooleanLike[Int] {
    def asBoolean(a: Int) = a == 1
  }

  implicit val stringBooleanLike = false

  implicit val optionBooleanLike = false

  /**
   * Get a hold of the implicit by adding a parameter list
   * or by calling {{implicitly}}
   */
  def asBoolean[A](a: A) = false

  /**
   * Will this suffice for a container (M[_]) type?
   */
  implicit class AsBoolean[???](a: ???) {
    def boolean = false
    def mboolean = false
  }
}

