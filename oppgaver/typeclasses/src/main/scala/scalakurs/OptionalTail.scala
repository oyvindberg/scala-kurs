package scalakurs

/**
 * Trait defining behaviour
 */
trait OptionalTail {
}

/**
 * Companion object with type class implementations
 */
object OptionalTail {

  def tailOption[???](m: ???) = {}

  implicit class Tailed[???](m: ???) {
    def tailOption = {}
  }
}
