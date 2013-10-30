package scalakurs.option

class Tree {
  lazy val rootValue: Option[String] = ???
  lazy val mkString: String = ???
  lazy val nrOfEdges: Int =
}

case class Node(left: Option[Tree], right: Option[Tree]) extends Tree
case class Leaf(value: String) extends Tree
