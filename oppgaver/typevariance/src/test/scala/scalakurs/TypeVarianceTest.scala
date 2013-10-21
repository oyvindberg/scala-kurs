package scalakurs

import org.scalatest.FunSuite

class TypeVarianceTest extends FunSuite {

//  import solutions.FunctionClassVerifier._
  import FunctionClassVerifier._

  test("Implement all MeaninglessEqualityFunction[I, O] with all valid combinations of classes A, B and C as type parameters I and O") {
    assert(validBBFunctions.size === 4)
  }

}
