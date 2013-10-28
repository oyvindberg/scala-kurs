package scalakurs.collections.solutions

object MapOppgaver {
  def nyttMap[K, V](key: K, value: V): Map[K, V] = Map(key -> value)

  def leggTilAssosiasjon[K, V](map: Map[K, V], key: K, value: V): Map[K, V] = map + (key -> value)

  def taBortAssosiasjon[K, V](map: Map[K, V], key: K): Map[K, V] = map - key

  def taBortAssosiasjon[K, V](map: Map[K,V], predicate: ((K,V)) => Boolean): Map[K, V] =
    map filterNot predicate

  def brukFunksjonPåAlleVerdier[K, V, VV](map: Map[K, V], f: V => VV): Map[K,VV] =
    map.mapValues(f)

  def mapMedDefault[K, V](l: List[(K, V)], default: V): Map[K, V] =
    l.toMap.withDefaultValue(default)

  def hentMedFallbackMap[K, V](key: K, mapA: Map[K, V], mapB: Map[K, V]): V = (mapA orElse mapB)(key)
}


