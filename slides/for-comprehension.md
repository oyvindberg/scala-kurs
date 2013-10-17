# For comprehension#

---

```scala
for (i <- 1 to 10) { println i }
```

<aside class="notes">
likt som i java
</aside>

---

```scala
for (i <- 1 to 10) yield i * 2

=> Vector(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
```

<aside class="notes">
    for er en expression (ikke statement)
</aside>

---

```scala
def even(i: Int): Boolean = ...

for {
    i <- 1 to 10
    if even(i)
} yield i

=> Vector(2, 4, 6, 8, 10)
```

<aside class="notes">
    man kan filtrere før resultatet treffer yield
</aside>

---

```scala
for {
    i <- 1 to 10
    if even(i)
} yield {
  val a = ...
  val b = ...
  val c = ...
  (a, b, c)
}
```

<aside class="notes">
    yield kan være en blokk
</aside>

---

```scala
val fornavn   = List("Adolf",  "Henry",  "Josef")
val etternavn = List("Hitler", "Rinnan", "Stalin")

val enListeMedOndskap: List[String] = for {
    f: String <- list1
    e: String <- list2
} yield s"$f $e"
```

<aside class="notes">
    fungerer også på lister
</aside>

---

```scala
def getNavn: Option[String] = ...
def getAlder: Option[String] = ...
def getAdresse: Option[String] = ...

val person: Option[Person] = for {
    navn <- getNavn
    alder <- getAlder
    adresse <- getAdresse
} yield new Person(navn, alder, adresse)
```

<aside class="notes">
Tenk på Option som en liste med ett eller ingen elementer
</aside>

---

```scala
for {
    e1 <- expr1
    e2 <- expr2 if predicate(e2)
} yield (e1, e2)
```
oversettes til
```scala
expr1.flatMap { e1 =>
    expr2.filter(predicate).map { e2 =>
        (e1, e2)
    }
}
```

<aside class="notes">
for-comprehension kan brukes på alle datatyper som
implementerer map, flatMap og filter
</aside>

---

Oppgaver:

Pytagoreiske tripler

finn alle faktorer av et tall

ekstraoppgave:

implementer map, flatMap og filter i en enkel Either

