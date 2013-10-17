package scalakurs

import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer

class OptionalTailTest extends FunSuite {

  import OptionalTail._

  test("Add tailOption for Seq[A]") {
    assert(seqOptTail.tailOption(Seq("head", "tail")) === Some(Seq("tail")))
    assert(seqOptTail.tailOption(Seq("head")) === None)
    assert(seqOptTail.tailOption(Seq.empty) === None)
  }

  test("Add syntactic sugar by adding Seq[A]().tailOption") {
    assert(Seq("head", "tail").tailOption === Some(Seq("tail")))
  }

  test("Add tailOption for Stream[A]") {
    assert(Stream("head", "tail").tailOption === Some(Stream("tail")))
    assert(Stream("head").tailOption === None)
    assert(Stream.empty.tailOption === None)
  }

}

