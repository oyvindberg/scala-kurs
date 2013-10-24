package scalakurs.option

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class OptionTreeTest extends FlatSpec with ShouldMatchers {

  import Trees._

  it should "see if the root node contains some leaf and then return its value" in {
    tree1.mkString should equal("baz")
  }

  it should "count vertices in the tree" in {
    tree2.countVertices should equal(7)
  }

  it should "traverse the tree depth first, left to right, and create a word by concatenating all the leaf values" in {
    tree2.mkString should equal("foo")
  }
}


object Trees {

  ////////////////
  //     *      //
  //      \     //
  //       *    //
  ////////////////

  lazy val tree1 =
    Node(
      None,
      Some(Leaf("baz")))


  ////////////////
  //      *     //
  //     /\     //
  //    *  *    //
  //   /\   \   //
  //  f  o   *  //
  //        /   //
  //       *    //
  //      /     //
  //     o      //
  ////////////////

  lazy val tree2 =
    Node(
      Some(Node(
        Some(Leaf("f")),
        Some(Leaf("o")))),
      Some(Node(
        None,
        Some(Node(
          Some(Node(
            Some(Leaf("o")),
            None
          )),
          None)))))
}
