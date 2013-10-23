package scalakurs.solutions

trait BooleanLike[A] {
  def asBoolean(a: A): Boolean
}

object BooleanLike {

  implicit val intBooleanLike = new BooleanLike[Int] {
    def asBoolean(a: Int) = a != 0
  }

  implicit val stringBooleanLike = new BooleanLike[String] {
    def asBoolean(a: String): Boolean = a == "true"
  }

  implicit val optionBooleanLike = new BooleanLike[Option[_]] {
    def asBoolean(a: Option[_]): Boolean = a.isDefined
  }

  /**
   * Get a hold of the implicit by adding a parameter list
   * or by calling {{implicitly}}
   */
  def asBoolean[A : BooleanLike](a: A): Boolean =
    implicitly[BooleanLike[A]].asBoolean(a)

  implicit class AsBoolean[A](a: A)(implicit bla: BooleanLike[A]) {
    def boolean: Boolean = bla.asBoolean(a)
  }

  implicit class AsBooleanM[M[_]](a: M[_])(implicit bla: BooleanLike[M[_]]) {
    def mboolean: Boolean = bla.asBoolean(a)
  }

}

