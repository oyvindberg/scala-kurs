package scalakurs

import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer

class OptionalTailTest extends FunSuite {

  import OptionalTail._

  test("tailOption for Seq[A]") {
    assert(seqOptTail.tailOption(Seq("head", "tail")) === Some(Seq("tail")))
    assert(seqOptTail.tailOption(Seq("head")) === None)
    assert(seqOptTail.tailOption(Seq.empty) === None)
  }

  test("add syntactic sugar by adding Seq[A]().tailOption") {
    assert(Seq("head", "tail").tailOption === Some(Seq("tail")))
  }

  test("tailOption for Stream[A] and the syntactic sugar still works") {
    assert(Stream("head", "tail").tailOption === Some(Stream("tail")))
    assert(Stream("head").tailOption === None)
    assert(Stream.empty.tailOption === None)
  }

}

