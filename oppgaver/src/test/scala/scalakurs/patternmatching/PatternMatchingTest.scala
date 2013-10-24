package scalakurs.patternmatching

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

import PatternMatching._

class PatternMatchingTest extends FunSuite with ShouldMatchers {
//  describe("Exercise 1: Match 5") {
//    it("should match 5") { assert(match5(5))}
//    it("""should match "5"""") { assert(match5("5"))}
//    it("should return false for everything else") { assert(!match5("everythingElse"))}
//  }

  test("Exercise 1: Match 5") {
    assert(match5("5") && match5(5) && !match5(4) && !match5(""))
  }

  test("Exercise 2: Match person") {
    val (kobeName, kobeAge, dwyaneName, dwyaneAge) = ("Kobe", 35, "Dwyane", 33)
    val kobe = Person(kobeName, kobeAge)
    val dwyane = Person(dwyaneName, dwyaneAge)
    assert(extractNameAndAge(kobe) ==(kobeName, kobeAge))
    assert(extractNameAndAge(dwyane) ==(dwyaneName, dwyaneAge))
  }

  // Exercise 3
  test("Exercise 3: Match seq") {
    assert(extractFirst3Elems(Seq(1, 2, 3, 4)) == Some((1, 2, 3)))
    assert(extractFirst3Elems(Seq(1, 2, 3)) == Some((1, 2, 3)))
    assert(extractFirst3Elems(Seq(1, 2)) == None)
    assert(extractFirst3Elems(Seq()) == None)
  }

  private val exampleTree: Tree =
    Node(5, Node(9, Nil, Node(4, Nil, Nil)), Node(1, Node(12, Nil, Node(11, Nil, Nil)), Nil))

  // Exercise 4
  test("Exercise 4: Check if Tree contains some value v") {
    assert(contains(exampleTree, 11))
    assert(!contains(exampleTree, 19))
  }

  // Exercise 5
  test("Exercise 5: Sum all values in Tree") {
    assert(sumTree(exampleTree) == 42)
  }

  // Exercise 6
  test("Exercise 6: Check if there's a v for which f(v) is true in Tree") {
    assert(exists(exampleTree, _ < 5))
    assert(exists(exampleTree, _ > 100))
    assert(!exists(exampleTree, _ < 0))
  }

}
