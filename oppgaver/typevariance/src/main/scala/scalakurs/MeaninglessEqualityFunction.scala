package scalakurs

sealed class A
sealed class B extends A
sealed class C extends B

class MeaninglessEqualityFunction[-I, +O](implicit  mi: Manifest[I], mo: Manifest[O])
  extends Function[I, O] {

  override def equals(obj: scala.Any): Boolean = mi.runtimeClass == mo.runtimeClass

  def apply(v1: I): O = mo.runtimeClass.asInstanceOf[O]
}
