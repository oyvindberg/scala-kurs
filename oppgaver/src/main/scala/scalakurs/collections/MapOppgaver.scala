package scalakurs.collections

object MapOppgaver {
  def nyttMap[K, V](key: K, value: V): Map[K, V] = ???

  def leggTilAssosiasjon[K, V](map: Map[K, V], key: K, value: V): Map[K, V] = ???

  def taBortAssosiasjon[K, V](map: Map[K, V], key: K): Map[K, V] = ???

  def taBortAssosiasjon[K, V](map: Map[K,V], predicate: ((K,V)) => Boolean): Map[K, V] = ???

  def brukFunksjonPåAlleVerdier[K, V, VV](map: Map[K, V], f: V => VV): Map[K,VV] = ???

  def mapMedDefault[K, V](l: List[(K, V)], default: V): Map[K, V] = ???

  def letMedFallbackMap[K, V](key: K, mapA: Map[K, V], mapB: Map[K, V]): V = ???
}


