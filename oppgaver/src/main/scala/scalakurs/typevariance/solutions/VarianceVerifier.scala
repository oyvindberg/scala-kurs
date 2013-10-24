package scalakurs.typevariance
package solutions

object VarianceVerifier {

  // Try to implement ImplementedFunction with all possible variance combinations.
  // Remember that the contained type expected by the Set is _Function[B, B]_,
  // and the function is defined as Function[-I, +O]!
  def functions = Set[B => B](

    // Now think variance until the tests turn green!
    // new ImplementedFunction[???, ???]
    new ImplementedFunction[B, B],
    new ImplementedFunction[A, C],
    new ImplementedFunction[B, C],
    new ImplementedFunction[A, B]
  )

}

