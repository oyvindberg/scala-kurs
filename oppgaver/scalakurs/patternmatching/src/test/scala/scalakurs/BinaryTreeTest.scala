package scalakurs

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import PatternMatching._

class BinaryTreeTest extends FunSuite with ShouldMatchers {

  test("et tre inneholder") {
    assert(Tree.contains(BinaryTree.exampleTree, 11))
    assert(!Tree.contains(BinaryTree.exampleTree, 19))
  }

  test("summer et tre") {
    assert(Tree.sumTree(BinaryTree.exampleTree) == 42)
  }

  test("det eksisterer noe i treet som passer et kriterie") {
    assert(Tree.exists(BinaryTree.exampleTree, _ < 5))
    assert(!Tree.exists(BinaryTree.exampleTree, _ > 100))
  }
}

object BinaryTree {
  val exampleTree: Tree = Node(5, Node(9, Nil, Node(4, Nil, Nil)), Node(1, Node(12, Nil, Node(11, Nil, Nil)), Nil))
}
