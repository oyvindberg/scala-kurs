package scalakurs.typeclasses

import org.scalatest.{FunSuite, Tag}

trait FunSuiteHelper extends FunSuite {

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
