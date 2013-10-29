package scalakurs.patternmatching.solutions

object PatternMatching {

  // Exercise 1: Should match either 5 of type Int or "5" of type String
  def match5(a: Any): Boolean = a match {
    case 5 => true
    case "5" => true
    case _ => false
  }

  // Exercise 2: Match name and age and put into a tuple
  case class Person(name: String, age: Int)
  def extractNameAndAge(person: Person): (String, Int) = person match {
    case Person(name, age) => (name, age)
  }

  // Exercise 3: Match first three elements and put them into a Some[Tuple3[A,A,A]]
  // (Example of such a tuple where A = String: Some(("a", "b", "c")) )
  // Return None if there's less than three elements in the list.
  def extractFirst3Elems[A](seq: Seq[A]): Option[(A, A, A)] = seq match {
    case Seq(a, b, c, _*) => Some((a, b, c))
    case _ => None
  }

  abstract sealed class Tree
  case class Node(value: Int, left: Tree, right: Tree) extends Tree
  case object Nil extends Tree

  // Exercise 4: Check if the Tree contains a value v.
  // Hint: A tree can be both a Node(value, left, right) and
  // a Nil. Handle both cases, and use recursion to handle a Node's children.
  def contains(t: Tree, v: Int): Boolean = t match {
    case Node(value, _, _) if value == v => true
    case Node(_, left, right) => contains(left, v) || contains(right, v)
    case Nil => false
  }

  // Exercise 5: Sum all the values in the Tree
  def sumTree(t: Tree): Int = t match {
    case Node(value, left, right) => value + sumTree(left) + sumTree(right)
    case Nil => 0
  }

  // Exercise 6: Check if there's a value v in the Tree
  // for which f(v) is true (f is a function)
  def exists(t: Tree, f: Int => Boolean): Boolean = t match {
    case Node(value, left, right) => f(value) || exists(left, f) || exists(right, f)
    case Nil => false
  }

}