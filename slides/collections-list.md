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

<aside class="notes">
Half Life -> Black Mesa<br/>
Oddworld -> RuptureFarms 1029<br/>
BioShock -> <br/>
</aside>

---


### Mutable / Immutable ###
mutable.List / immutable.List <br/>
mutable.Set / immutable.Set <br/>
mutable.Map / immutable.Map <br/>

<aside class="notes">
    immutable er foretrukket (og default)
</aside>

---

## List ##
```scala
List()        == Nil
List(1, 2, 3) == 1 :: 2 :: 3 :: Nil

1 :: List(2, 3)        => List(1, 2, 3): List[Int] // prepend
List(1, 2) :+ 3        => List(1, 2, 3): List[Int] // append
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
gamers.filter(_.rank < 10)
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

val allGamers = bestGamer :: gamers.map(g => g.copy(rank = g.rank + 1))
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

NumeriskeListerTest (NLT)

```scala
sbt:
> ~ test-only scalakurs.collections.NumeriskeListerTest
```

scaladoc: [immutable.List][1]

[1]: http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.List