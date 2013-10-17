package scalakurs.solutions

/**
 * Trait defining behaviour
 */
trait OptionalTail[M[_]] {
  def tailOption(m: M[_]): Option[M[_]]
}

/**
 * Companion object with type class implementations
 */
object OptionalTail {

  implicit def seqOptTail = new OptionalTail[Seq] {
     def tailOption(a: Seq[_]): Option[Seq[_]] = a match {
       case _ :: tail if tail.nonEmpty => Some(tail)
       case _ => None
     }
  }

  implicit def streamOptTail = new OptionalTail[Stream] {
    def tailOption(a: Stream[_]): Option[Stream[_]] = a match {
      case _ #:: tail if tail.nonEmpty => Some(tail)
      case _ => None
    }
  }

  def tailOption[M[_]](m: M[_])(implicit  ot: OptionalTail[M]) =
    ot.tailOption(m)

  implicit class Tailed[M[_]](m: M[_])(implicit ot: OptionalTail[M]) {
    def tailOption: Option[M[_]] = ot.tailOption(m)
  }

}
