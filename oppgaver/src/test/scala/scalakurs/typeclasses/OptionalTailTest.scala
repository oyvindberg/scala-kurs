package scalakurs.typeclasses

class OptionalTailTest extends FunSuiteHelper {

//  import solutions.OptionalTail._
  import OptionalTail._

  test("tailOption for head :: tail :: Nil returns Some(tail :: Nil)") {
    assert(tailOption(Seq("head", "tail")) === Some(Seq("tail")))
  }

  test("tailOption for head :: Nil returns None") {
    assert(tailOption(Seq("head")) === None)
  }

  test("tailOption for Nil returns None") {
    assert(tailOption(Seq.empty) === None)
  }

  test("Add Seq[A]().tailOption") {
    assert(Seq("head", "tail").tailOption === Some(Seq("tail")))
  }

  test("Add tailOption for Stream[A]") {
    assert(Stream("head", "tail").tailOption === Some(Stream("tail")))
    assert(Stream("head").tailOption === None)
    assert(Stream.empty.tailOption === None)
  }

}

