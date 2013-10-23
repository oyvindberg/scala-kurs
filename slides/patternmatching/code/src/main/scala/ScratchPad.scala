object ScratchPad {

  sealed abstract class Gender
  case object MALE extends Gender
  case object FEMALE extends Gender
  case class Person(gender: Gender, name: String)

  def greet(person: Person) {
    person match {
      case Person(MALE, name)   => println("Hello, Mr. " + name)
      case Person(FEMALE, name) => println("Hello, Mrs. " + name)
      case Person(_, name)      => println("Hello, " + name)
    }
  }


  val list: List[Int] = List(1,2,3)

  val seq: Seq[Int] = Seq(1,2,3)

  list match {
    case 1 :: 2 :: 3 :: Nil => println("true")
    case _ => println("false")
  }

  seq match {
    case 1 :: 2 :: 3 :: Nil => println("true")
    case _ => println("false")
  }

  val stream = Stream("1", "2", "3")

  def bleh (seq: Stream[String]) = {
    seq match {
      case "1" +: "bleh" +: rest => println("bleh")
    }
  }

  bleh(stream)

  seq match {
    case 0 +: rest => println("Found list starting with 0!")
    case _ =>
  }

  abstract class Tree
  case class Node(value: Int, left: Tree, right: Tree) extends Tree
  case class Leaf(value: Int) extends Tree

  def leftLeaf(tree: Tree): Option[Leaf] = {
    tree match {
      case Node(_, leaf @ Leaf(_), child) => Some(leaf)
      case _ => None
    }
  }


}
