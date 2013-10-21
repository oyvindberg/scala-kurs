package scalakurs

import org.scalatest.FunSuite

class TypeVarianceTest extends FunSuite {

//  import solutions.VarianceVerifier._
  import VarianceVerifier._

  test("Implement all ImplementedFunction[I, O] with all valid combinations of classes A, B and C as type parameters I and O") {
    assert(functions.size === 4)
  }

}
