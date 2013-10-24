package scalakurs.typeclasses
package solutions

trait BooleanLike[-A] {
  def asBoolean(a: A): Boolean
}

object BooleanLike {

  implicit val intBooleanLike = new BooleanLike[Int] {
    def asBoolean(a: Int) = a != 0
  }

  implicit val stringBooleanLike = new BooleanLike[String] {
    def asBoolean(a: String): Boolean = a == "true"
  }

  implicit val optionBooleanLike = new BooleanLike[Option[Any]] {
    def asBoolean(a: Option[Any]): Boolean = a.isDefined
  }

  /**
   * Get a hold of the implicit by adding a parameter list
   * or by calling {{implicitly}}
   */
  def asBoolean[A](a: A)(implicit bla: BooleanLike[A]) = bla.asBoolean(a)

  /**
   * Will this suffice for a container M[_], like Option[String]?
   * Maybe you need to take a look at the variance of the BooleanLike trait,
   * and also at the signature of the relevant implicit BooleanLike?
   */
  implicit class AsBoolean[M](m: M)(implicit blm: BooleanLike[M]) {
    def boolean: Boolean = blm.asBoolean(m)
  }
}

