package scalakurs.option

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
