package scalakurs.option

class Tree {
  def mkString: String = ???
  def countVertices: Int = ???
}

case class Node(left: Option[Tree], right: Option[Tree]) extends Tree
case class Leaf(value: String) extends Tree
