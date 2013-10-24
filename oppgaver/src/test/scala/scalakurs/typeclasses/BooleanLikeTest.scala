package scalakurs.typeclasses

class BooleanLikeTest extends FunSuiteHelper {

//  import solutions.BooleanLike._
  import BooleanLike._

  test("Example BooleanLike type class for Int") {
      assert(asBoolean(1))
      assert(!asBoolean(0))
  }

  test("Implement BooleanLike type class for String") {
      assert(asBoolean("true"))
      assert(!asBoolean("false"))
      assert(!asBoolean(""))
  }

  /**
   * You'll need to (implicitly) convert the type A into an AsBoolean[A]
   * with the function boolean: Boolean.
   */
  bonus("Add some syntactic sugar to call asBoolean postfix") {
      assert(1.boolean)
      assert(!"".boolean)
  }

  /**
   * You'll need to abstract over a container type M[_] in addition to A,
   * which takes no type parameter. This will require the BooleanLike[A] to
   * support some BooleanLike[B] where a B <: A. You can do this now, or wait
   * until after the type variance talk.
   */
  bonus("Implement BooleanLike type class for Option with postfixed .boolean") {
      assert(Option("foo").boolean)
      assert(!(None: Option[String]).boolean)
  }
}
