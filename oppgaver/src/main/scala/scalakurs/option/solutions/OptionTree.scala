package scalakurs.option
package solutions

import scala.annotation.tailrec

class Tree {

  lazy val rootValue = this match {
    case Leaf(l) => Some(l)
    case _ => None
  }

  lazy val mkString: String = {
    @tailrec
    def inner(result: String, toVisit: List[Tree]): String = {
      toVisit.headOption match {
        case Some(Leaf(value)) => inner(result + value, toVisit.tail)
        case Some(Node(left, right)) => inner(result, (left :: right :: Nil).flatten ::: toVisit.tail)
        case _ => result
      }
    }
    inner("", this :: Nil)
  }

  lazy val countVertices: Int = {
    @tailrec
    def inner(count: Int, toVisit: List[Tree]): Int = {
      toVisit.headOption match {
        case Some(leaf: Leaf) => inner(count, toVisit.tail)
        case Some(Node(left, right)) => {
          val next = (left :: right :: Nil).flatten
          inner(count + next.size,  next ::: toVisit.tail)
        }
        case _ => count - 1
      }
    }
    inner(0, this :: Nil)
  }
}

case class Node(left: Option[Tree], right: Option[Tree]) extends Tree

case class Leaf(value: String) extends Tree
