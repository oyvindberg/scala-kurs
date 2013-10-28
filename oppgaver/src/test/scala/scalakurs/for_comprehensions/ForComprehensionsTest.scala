package scalakurs.for_comprehensions

import org.scalatest.FunSuite

class ForComprehensionsTest extends FunSuite {
  test("finn alle faktorer av x") {
    assert(ForComprehensions.alleFaktorerAv(10) === Seq(1,2,5,10))
    assert(ForComprehensions.alleFaktorerAv(13) === Seq(1, 13))
    assert(ForComprehensions.alleFaktorerAv(98) === Seq(1, 2, 7, 14, 49, 98))
  }

  test("finn alle pytagoreiske tripler der a < b < c < 100 (vha brute force)") {
    val tripler: Seq[(Int, Int, Int)] = ForComprehensions.pytagoreiskeTripler

    assert(tripler.size === 52)
    assert(tripler.head === (3, 4, 5))
    assert(tripler.last === (65, 72, 97))
  }
}

