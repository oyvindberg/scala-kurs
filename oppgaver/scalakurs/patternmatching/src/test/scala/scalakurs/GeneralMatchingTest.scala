package scalakurs

import PatternMatching._
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class GeneralMatchingTest  extends FunSuite with ShouldMatchers {

  test("match 5") {
    assert(match5("5") && match5(5) && ! match5(4) &&  ! match5(""))
  }

  test("match person") {
    val (kobeName, kobeAge, dwyaneName, dwyaneAge) = ("Kobe", 35, "Dwyane", 33)
    val kobe = Person(kobeName, kobeAge)
    val dwyane = Person(dwyaneName, dwyaneAge)
    assert(extractNameAndAge(kobe) == (kobeName, kobeAge))
    assert(extractNameAndAge(dwyane) == (dwyaneName, dwyaneAge))
  }

  test("match seq") {
    assert(extractFirst3Elems(Seq(1,2,3,4)) == Some((1, 2, 3)))
    assert(extractFirst3Elems(Seq(1,2,3)) == Some((1, 2, 3)))
    assert(extractFirst3Elems(Seq(1,2)) == None)
    assert(extractFirst3Elems(Seq()) == None)
  }

}
