package scalakurs.patternmatching

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

import PatternMatching._

class PatternMatchingTest extends FunSpec with ShouldMatchers {

  describe("Exercise 1: Match 5") {
    it("should match 5") { assert(match5(5))}
    it("""should match "5"""") { assert(match5("5"))}
    it("should return false for everything else") { assert(!match5("everythingElse"))}
  }

  describe("Exercise 2: Extract name and age") {
    val (kobeName, kobeAge, dwyaneName, dwyaneAge) = ("Kobe", 35, "Dwyane", 33)
    val kobe = Person(kobeName, kobeAge)
    val dwyane = Person(dwyaneName, dwyaneAge)
    it(s"should extract ($kobeName, $kobeAge) from Person($kobeName, $kobeAge)") {assert(extractNameAndAge(kobe) ==(kobeName, kobeAge))}
    it(s"should extract ($dwyaneName, $dwyaneAge) from Person($kobeName, $kobeAge)") {assert(extractNameAndAge(dwyane) ==(dwyaneName, dwyaneAge))}
  }

  // Exercise 3
  describe("Exercise 3: Extract first 3 elements") {
    it("should extract Seq(1,2,3) from Seq(1,2,3,4))") {assert(extractFirst3Elems(Seq(1, 2, 3, 4)) == Some((1, 2, 3)))}
    it("should extract (Seq(1,2,3) from Seq(1,2,3)") {assert(extractFirst3Elems(Seq(1, 2, 3)) == Some((1, 2, 3)))}
    it("should return none when trying to extract from Seq(1,2)") {assert(extractFirst3Elems(Seq(1, 2)) == None)}
    it("should return none when trying to extract from an empty Seq()") {assert(extractFirst3Elems(Seq()) == None)}
  }

  private val exampleTree: Tree =
    Node(5, Node(9, Nil, Node(4, Nil, Nil)), Node(101, Node(12, Nil, Node(11, Nil, Nil)), Nil))

  // Exercise 4
  describe("Exercise 4: Check if tree contains v") {
    it("should return true when v exists in tree") {assert(contains(exampleTree, 11))}
    it("should return false when v does not exist in tree") {assert(!contains(exampleTree, 19))}
  }

  // Exercise 5
  describe("Exercise 5: Sum all values in Tree") {
    it("should return 142 for test tree") {assert(sumTree(exampleTree) == 142)}
  }

  // Exercise 6
  describe("Exercise 6: Check if there's a v for which f(v) is true in Tree") {
    it("should return true for f = _ < 5 since there are several values less than 5 in the test tree") {assert(exists(exampleTree, _ < 5))}
    it("should return true for f = _ > 100 since there's at least one value in the test tree greater than 100") {assert(exists(exampleTree, _ > 100))}
    it("should return false for f = _ < 0 since there are no negative values in the test tree") {assert(!exists(exampleTree, _ < 0))}
  }

}
