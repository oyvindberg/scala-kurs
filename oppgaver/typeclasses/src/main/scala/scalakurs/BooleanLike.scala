package scalakurs

trait BooleanLike[A] {
  def asBoolean(a: A): Boolean
}

object BooleanLike {

  implicit val intBooleanLike = new BooleanLike[Int] {
    def asBoolean(a: Int) = a == 1
  }

  implicit val stringBooleanLike = new BooleanLike[String] {
    def asBoolean(a: String): Boolean = Option(a).exists("true" ==)
  }

  implicit val optionBooleanLike = new BooleanLike[Option[_]] {
    def asBoolean(a: Option[_]): Boolean = a.isDefined
  }

  def asBoolean[A](a: A)(implicit bla: BooleanLike[A]) = bla.asBoolean(a)

  implicit class AsBoolean[A](a: A)(implicit bla: BooleanLike[A]) {
    def boolean: Boolean = bla.asBoolean(a);
  }

  implicit class AsMBoolean[M[_]](m: M[_])(implicit blm: BooleanLike[M[_]]) {
    def mboolean: Boolean = blm.asBoolean(m);
  }
}

