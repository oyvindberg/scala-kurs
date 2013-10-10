# Collections #

---

### Collection "Literals"###
```scala
List(1, 2, 3)
1 to 10 == Range(1, 10)
Map("Resident Evil" -> "Umbrella Corp",
    "Portal"        -> "Aperture",
    "Half Life"     -> "???",
    "Oddworld"      -> "???",
    "Bioshock"      -> "???"
     )
```

---


### Mutable / Immutable ###
mutable.List / immutable.List
mutable.Set / immutable.Set
mutable.Map / immutable.Map

<aside class="notes">
    immutable er foretrukket (og default)
</aside>

---

## List ##
```scala
List()        == Nil
List(1, 2, 3) == 1 :: 2 :: 3 :: Nil

1 :: List(2, 3)        => List(1, 2, 3): List[Int] // append
List(1, 2) :+ 3        => List(1, 2, 3): List[Int] // prepend
List(1) ::: List(2, 3) => List(1, 2, 3): List[Int] // join
```

---

```scala
List(1, 2, 3).mkString                    => "123"
List(1, 2, 3).mkString(", ")              => "1, 2, 3"
List(1, 2, 3).mkString("< ", " | ", " >") => "< 1 | 2 | 3 >"
```

---

```scala
class List[A] {
  ..
  def isEmpty: Boolean 
  def nonEmpty: Boolean 

  def size: Int 

  def min: A
  def max: A

  def sorted: List[A] // returnerer en sortert liste
  ..
}
```
<aside class="notes">
    ved "sorted" blir den opprinnelige listen er ikke endret
</aside>


---

```scala
class List[A] {
  ..
  def head: A               // første element
  def tail: List[A]         // alle elementer utenom det første

  def last: A               // siste element
  def init: List[A]         // alle elementer utenom det siste

  def headOption: Option[A] // None ved tom liste
  def lastOption: Option[A] // None ved tom liste
  ..
}
```
<aside class="notes">
    mangler tailOption og initOption
</aside>

---

##### tailOption #####
```scala
def tailOption[A](list: List[A]): Option[List[A]] =
    list.headOption.map(list.tail)
```
<aside class="notes">
    Forutsetter at Option og map er gjennomgått
    Denne hadde vært fin å pimpe på List
</aside>

---

```scala
class Gamer(nick: String, clan: String, rank: Int)

val gamers = List(gamer1, gamer2, .....)
```

```scala
gamers.sorted ???
```

<aside class="notes">
Hvordan sorterer man gamers?
Hva er gamers.max ?
</aside>

---

### høyereordens funksjoner på List ###
```scala
class Gamer(nick: String, clan: String, rank: Int)

val gamers = List(gamer1, gamer2, .....)
```

```scala
class List[A] {
  ..
  def sortBy[B](f: (A) => B): List[A]
  ..
}
```

```scala
def nick(g: Gamer): String = g.nick

val gamersSortedByNick = gamers.sortBy(nick)

val gamersSortedByClan = gamers.sortBy((g: Gamer) => g.clan)

val gamersSortedByRank = gamers.sortBy(_.rank)
```

---

### Filter ###
```scala
class Gamer(nick: String, clan: String, rank: Int)

val gamers = List(gamer1, gamer2, .....)
```

```scala
class List[A] {
  ..
  def filter(p: (A) => Boolean): List[A]
  ..
}
```

```scala
gamers.filter(_.clan == "aimbots")
gamers.filter(_.rank > 10)
```

---

### map ###
```scala
class Gamer(nick: String, clan: String, rank: Int)

val gamers = List(gamer1, gamer2, .....)
```

```scala
class List[A] {
  ..
  def map[B](f: (A) => B): List[B]
  ..
}
```

```scala
val bestGamer = Gamer("Mrs. Robinson", "1337 Squad", 1)

val allGamers = bestGamer :: gamers.map(g => g.copy(rank = g.rank + 1)
```

---

### groupBy ###
```scala
class Gamer(nick: String, clan: String, rank: Int)

val gamers = List(gamer1, gamer2, .....)
```

```scala
class List[A] {
  ..
  def groupBy[K](f: (A) => K): Map[K, List[A]]
  ..
}
```

```scala
gamers.groupBy(_.clan) => Map[String, List[Gamer]]
```

---

# Oppgaver #

collections List*

---

## Map ##
```scala
class Map[A, +B] {
  ..
  def isEmpty: Boolean
  def nonEmpty: Boolean

  def size: Int

  def mkString: String
  def mkString(sep: String): String
  def mkString(start: String, sep: String, end: String): String
  ..
}
```
<aside class="notes">
    mye likt som List
</aside>

---

```scala
class Map[A, +B] {
  ..
  def filter(p: ((A, B)) ⇒ Boolean): Map[A, B]
  def filterKeys(p: (A) ⇒ Boolean): Map[A, B]

  def map[B](f: (A) ⇒ B): Map[B]
  def mapValues[C](f: (B) ⇒ C): Map[A, C]

  def partition(p: ((A, B)) ⇒ Boolean): (Map[A, B], Map[A, B])

  def default(key: A): B

  def orElse[A1 <: A, B1 >: B](that: PartialFunction[A1, B1]): PartialFunction[A1, B1]
  ..
}
```

---

# Oppgaver #
collections Map*

---

### Strenger kan behandles som collections ###

---

# Oppgaver #
collections String*
