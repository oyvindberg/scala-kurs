package scalakurs

object PatternMatching {

  // ------------- Part 1 -----------------------------------

  // Should match either 5 of type Int or "5" of type String
  def match5(a: Any): Boolean = ???

  // Match name and age and put into a tuple
  case class Person(name: String, age: Int)
  def extractNameAndAge(person: Person): (String, Int) = ???

  // Match first three elements and put into a Some of a tuple.
  // Return None if there's less than three elements in the list.
  def extractFirst3Elems[A](seq: Seq[A]): Option[(A, A, A)] = ???

  // ------------- Part 2 -----------------------------------

  abstract sealed class Tree
  case class Node(value: Int, left: Tree, right: Tree) extends Tree
  case object Nil extends Tree

  object Tree {

    // Check tree contains the value v.
    // Hint: A tree can be both a Node(value, left, right) and
    // a Nil. Handle both cases, and use recursion to traverse the tree.
    def contains(t: Tree, v: Int): Boolean = ???

    // Hint: You should be able to
    def sumTree(t: Tree): Int = ???

    // Hint: f: is a function, see if there's a value v in the tree
    // for which f(v) is true.
    def exists(t: Tree, f: Int => Boolean): Boolean = ???
  }

}