package scalakurs.typevariance

class A
class B extends A
class C extends B

object VarianceVerifier {

  // Try to implement ImplementedFunction with all possible variance combinations.
  // Remember that the contained type expected by the Set is _Function[B, B]_,
  // and the function is defined as Function[-I, +O]!
  def functions = Set[B => B](

    // Now think variance until the tests turn green!
    // new ImplementedFunction[???, ???]
  )

}

