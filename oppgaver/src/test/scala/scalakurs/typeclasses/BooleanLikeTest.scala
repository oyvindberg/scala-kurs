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
   * You'll need to "convert" the type A into a type with the
   * function boolean: Boolean.
   */
  bonus("Add some syntactic sugar to call asBoolean postfix") {
      assert(1.boolean)
      assert(!"".boolean)
  }

  /**
   * You'll need to abstract over a container type M[_] instead of an A,
   * which takes no type parameter. This requires a spescialised mboolean.
   */
  bonus("Implement BooleanLike type class for Option with postfixed mboolean") {
      assert(Option("foo").mboolean)
      assert(!(None: Option[String]).mboolean)
  }
}
