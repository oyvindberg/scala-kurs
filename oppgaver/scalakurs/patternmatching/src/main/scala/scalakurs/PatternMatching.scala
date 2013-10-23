package scalakurs

object PatternMatching {

  // Exercise 1: Should match either 5 of type Int or "5" of type String
  def match5(a: Any): Boolean = ???

  // Exercise 2: Match name and age and put into a tuple
  case class Person(name: String, age: Int)
  def extractNameAndAge(person: Person): (String, Int) = ???

  // Exercise 3: Match first three elements and put them into a Some[Tuple3[A,A,A]]
  // (Example of such a tuple where A = String: Some(("a", "b", "c")) )
  // Return None if there's less than three elements in the list.
  def extractFirst3Elems[A](seq: Seq[A]): Option[(A, A, A)] = ???

  abstract sealed class Tree
  case class Node(value: Int, left: Tree, right: Tree) extends Tree
  case object Nil extends Tree

  // Exercise 4: Check if the Tree contains a value v.
  // Hint: A tree can be both a Node(value, left, right) and
  // a Nil. Handle both cases, and use recursion to handle a Node's children.
  def contains(t: Tree, v: Int): Boolean = ???

  // Exercise 5: Sum all the values in the Tree
  def sumTree(t: Tree): Int = ???

  // Exercise 6: Check if there's a value v in the Tree
  // for which f(v) is true (f is a function)
  def exists(t: Tree, f: Int => Boolean): Boolean = ???

}