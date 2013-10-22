import org.scalatest.FunSuite

class PytagoreiskeTriplerTest extends FunSuite {
  test("finn alle pytagoreiske tripler der a < b < c < 100") {
    val pytagoreiskeTripler: Seq[(Int, Int, Int)] = PytagoreiskeTripler.regnUt

    assert(pytagoreiskeTripler.size === 52)
    assert(pytagoreiskeTripler.head === (3, 4, 5))
    assert(pytagoreiskeTripler.last === (65, 72, 97))
  }
}

