package scalakurs

// Helper class!
// The only thing interesting here is the type variance on MeaninglessEqualityFunction
class ImplementedFunction[-I, +O](implicit  mi: Manifest[I], mo: Manifest[O])
  // Oh, yes, the whole point of this exercise.
  extends Function[I, O] {

  // Override equals to ensure no-cheat mode and test verification
  override def equals(obj: scala.Any): Boolean = mi.runtimeClass == mo.runtimeClass

  // Just implement some bogus apply on the function,
  // so you guys won't have to bother.
  def apply(v1: I): O = mo.runtimeClass.asInstanceOf[O]
}
