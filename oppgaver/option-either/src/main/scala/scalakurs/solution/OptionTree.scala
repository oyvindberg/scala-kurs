package scalakurs.solution

import scala.annotation.tailrec

class Tree {

  def mkString: String = {
    @tailrec
    def inner(result: String, toVisit: List[Tree]): String = {
      toVisit.headOption match {
        case None => result
        case Some(Leaf(value)) => inner(result + value, toVisit.tail)
        case Some(Node(left, right)) => inner(result, (left :: right :: Nil).flatten ::: toVisit.tail)
      }
    }
    inner("", this :: Nil)
  }

  def countVertices: Int = {
    @tailrec
    def inner(count: Int, toVisit: List[Tree]): Int = {
      toVisit.headOption match {
        case None => count - 1
        case Some(leaf: Leaf) => inner(count, toVisit.tail)
        case Some(Node(left, right)) => {
          val next = (left :: right :: Nil).flatten
          inner(count + next.size,  next ::: toVisit.tail)
        }
      }
    }
    inner(0, this :: Nil)
  }
}

case class Node(left: Option[Tree], right: Option[Tree]) extends Tree

case class Leaf(value: String) extends Tree
