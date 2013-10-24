package scalakurs.for_comprehensions

import org.scalatest.FunSuite

class ForComprehensionsTest extends ForComprehensions with FunSuite {
  test("finn alle faktorer av x") {
    assert(alleFaktorerAv(10) === Seq(1,2,5,10))
    assert(alleFaktorerAv(13) === Seq(1, 13))
    assert(alleFaktorerAv(98) === Seq(1, 2, 7, 14, 49, 98))
  }

  test("finn alle pytagoreiske tripler der a < b < c < 100 (vha brute force)") {
    val tripler: Seq[(Int, Int, Int)] = pytagoreiskeTripler

    assert(tripler.size === 52)
    assert(tripler.head === (3, 4, 5))
    assert(tripler.last === (65, 72, 97))
  }
}

