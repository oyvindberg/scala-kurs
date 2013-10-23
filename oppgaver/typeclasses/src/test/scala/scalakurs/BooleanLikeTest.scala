package scalakurs

import org.scalatest.{Tag, FunSuite}

class BooleanLikeTest extends FunSuite {

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
      assert(!asBoolean(null: String))
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


  override protected def test(testName: String, testTags: Tag*)
                             (testFun: => Unit): Unit = {
    super.test(testName, testTags:_*)(isImplemented(testFun))
  }

  def bonus(testName: String) = test(s"Bonus: $testName") _

  def isImplemented[A](block: => A) = {
    try block catch {
      case err: NotImplementedError => fail(err)
    }
  }
}
