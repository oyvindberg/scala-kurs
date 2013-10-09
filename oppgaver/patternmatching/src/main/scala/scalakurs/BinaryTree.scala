package scalakurs

abstract sealed class Tree
case class Node(value: Int, left: Tree, right: Tree) extends Tree
case object Nil extends Tree

object Tree {
  def contains(t: Tree, v: Int): Boolean = ???
  def sumTree(t: Tree): Int = ???
  def exists(t: Tree, f: Int => Boolean): Boolean = ???
}
