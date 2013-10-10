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

mutable.Map / immutable.Map

<aside class="notes">
    immutable er foretrukket
</aside>

---

## List ##
```scala
List(1, 2, 3)     ==     1 :: 2 :: 3 :: Nil
```

---

```scala
class List[A] {
  ..
  def mkString: String 
  // List(1, 2, 3).mkString => "123"
  
  def mkString(sep: String): String 
  // List(1, 2, 3).mkString(", ") => "1, 2, 3"

  def mkString(start: String, sep: String, end: String): String 
  // List(1, 2, 3).mkString("< ", " | ", " >") => "< 1 | 2 | 3 >"
  ..
}
```

---

```scala
class List[A] {
  ..
  def isEmpty: Boolean 
  def nonEmpty: Boolean 

  def size: Int 
  def length: Int 
  ..
}
```
<aside class="notes">
    size == length
</aside>

---

```scala
class List[A] {
  ..
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

### List ###
```scala
class Gamer(nick: String, clan: String, rank: Int)

val gamers = List(gamer1, gamer2, .....)

gamers.sorted ???
```

<aside class="notes">
Hvordan sorterer man gamers?
Hva er gamers.max ?
</aside>

---

### høyereordens funksjoner ###
```scala
def nick(g: Gamer): String = g.nick

val gamersSortedByNick = gamers.sortBy(nick)

val gamersSortedByClan = gamers.sortBy((g: Gamer) => g.clan)

val gamersSortedByRank = gamers.sortBy(_.rank)
```

---

andre funksjoner som bør nevnes:
map
groupBy
filter
flatMap
