package scalakurs.patternmatching.solutions

abstract sealed class Tree

case class Node(value: Int, left: Tree, right: Tree) extends Tree

case object Nil extends Tree

object Tree {

  def contains(t: Tree, v: Int): Boolean = t match {
    case Nil => false
    case Node(nodeVal, _, _) if v == nodeVal => true
    case Node(_, left, right) => contains(left, v) || contains(right, v)
  }

  def sumTree(t: Tree): Int = t match {
    case Nil => 0
    case Node(treeVal, left, right) => treeVal + sumTree(left) + sumTree(right)
  }

  def exists(t: Tree, f: Int => Boolean): Boolean = t match {
    case Nil => false
    case Node(v, left, right) => f(v) || exists(left, f) || exists(right, f)
  }
}
