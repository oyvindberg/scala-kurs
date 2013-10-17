package scalakurs

import org.scalatest.{Tag, FunSuite}

class BooleanLikeTest extends FunSuite {

  import BooleanLike._

  test("Example BooleanLike type class for Int") {
    assert(asBoolean(1))
    assert(!asBoolean(0))
  }

  test("Implement BooleanLike type class for String") {
    assert(asBoolean("true"))
    assert(!asBoolean("false"))
    assert(!asBoolean(""))
    assert(!asBoolean(null: String))
  }

  /**
   * You'll need to "convert" the type A into a type with the
   * function boolean: Boolean
   */
  bonus("Add some syntactic sugar to call asBoolean postfix") {
    assert(1.boolean)
    assert(!"".boolean)
  }

  /**
   * You'll need to abstract over a container type M[_] instead of an A,
   * which takes no type parameter.
   */
//  bonus("Implement BooleanLike type class for Option with syntactic sugar") {
//    assert(Option("foo").mboolean)
//    assert(!(None: Option[String]).mboolean)
//  }

  def bonus(testName: String) = test(s"Bonus: $testName") _
}
