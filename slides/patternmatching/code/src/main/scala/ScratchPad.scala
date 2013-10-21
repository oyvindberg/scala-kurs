object ScratchPad {

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

}
