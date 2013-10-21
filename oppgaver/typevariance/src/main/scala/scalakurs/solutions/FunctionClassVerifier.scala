package scalakurs.solutions

import scalakurs._

object FunctionClassVerifier {

  // Try to implement MeaninglessEqualityFunction with all possible variance combinations.
  // Remember that the type of the Set is Function[B, B], and the function is defined as Function[-I, +O]!
  def validBBFunctions = Set[B => B](
    new MeaninglessEqualityFunction[B, B],
    new MeaninglessEqualityFunction[A, C],
    new MeaninglessEqualityFunction[A, B],
    new MeaninglessEqualityFunction[B, C]
  )

}

