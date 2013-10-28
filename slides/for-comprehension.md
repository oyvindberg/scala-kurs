# For comprehension #

---

```java
// java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

```scala
// scala
for (i <- 1 to 10) { println(i) }
```

```scala
// type-annotering kan være greit for debugging
for (i: Int <- 1 to 10) { println(i) }
```

<aside class="notes">
i sin enkleste form veldig lik som i java
</aside>

---

```java
// java
List<Integer> list = new ArrayList<>();
for (int i = 1; i <= 10; i++) {
    list.add(i * 2);
}
```

```scala
// scala
val list: Seq[Int] = for (i <- 1 to 10) yield i * 2
```

<aside class="notes">
    for er en expression (ikke statement) <br/>
    dette betyr at den returnerer en verdi
</aside>

---

```java
// java
List<Punkt> punkter = new ArrayList<>();
for (int x = 1; x <= 10; x++) {
    for (int y = 1; y <= 10; y++) {
        punkter.add(new Punkt(x, y));
    }
}
```

```scala
// scala
val punkter: Seq[Punkt] = for {
    x <- 1 to 10
    y <- 1 to 10
} yield new Punkt(x, y)
```

<aside class="notes">
    man kan nøste flere for løkker <br/>
    bruker da krøllparentees for å slippe å ha semikolon etter hver generator
</aside>

---

```java
// java
boolean even(int i) { return i % 2 == 0; }

List<Integer> partall = new ArrayList<>();
for (int i = 1; i <= 10; i++) {
    if (even(i)) {
        partall.add(i);
    }
}
```

```scala
// scala
def even(i: Int): Boolean = i % 2 == 0

val partall: Seq[Int] = for {
    i <- 1 to 10
    if even(i)
} yield i
```

<aside class="notes">
    man kan filtrere før resultatet treffer yield
</aside>

---

```scala
// scala
for {
    i <- 1 to 10
    if even(i)
} yield {
  // yield kan være en blokk
  logger.debug("inne i blokken")
  i
}
```

<aside class="notes">
    yield kan være en blokk
</aside>

---

```scala
// scala
val listeMedFornavn   = List("Adolf",  "Henry",  "Josef")
val listeMedEtternavn = List("Hitler", "Rinnan", "Stalin")

val listeMedStigmatiserendeNavn: List[String] = for {
    fornavn: String   <- listeMedFornavn
    etternavn: String <- listeMedEtternavn
} yield s"$fornavn $etternavn"
```

```java
// java
List<String> listeMedStigmatiserendeNavn = new ArrayList<>();
for (String fornavn : listeMedFornavn) {
    for (String etternavn : listeMedEtternavn) {
        listeMedStigmatiserendeNavn.add(fornavn + " " + etternavn);
    }
}
```

<aside class="notes">
    fungerer også på lister
</aside>

---

```scala
val navnOption: Option[String] = ...
val alderOption: Option[Int] = ...
val adresseOption: Option[String] = ...

val person: Option[Person] = for {
  navn <- navnOption
  alder <- alderOption
  adresse <- adresseOption
} yield new Person(navn, alder, adresse)
```

<aside class="notes">
Man kan bruke Option i for-comprehension <br/>

(Option brukes for å unngå NPE.
Tenk på Option som en liste med ett eller ingen elementer) <br/>
mer om Option senere <br/>
</aside>

---

```java
// java
List<String> navnOption = ...
List<Integer> alderOption = ...
List<String> adresseOption = ...

List<Person> p = new ArrayList<>();
for (String navn: navnOption) {
    for (Integer alder: alderOption) {
        for (String adresse: adresseOption) {
            p.add(new Person(navn, alder, adresse));
        }
    }
}
return p;
```

<aside class="notes">
Tenk på Option som en liste med ett eller ingen elementer
Hva ville skjedd om getAlder returnerte en tom liste?
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

# Oppgaver #
ForComprehensionsTest (FCT)

```scala
sbt:
> ~ test-only scalakurs.for_comprehensions.ForComprehensionsTest
```

<aside class="notes">
<ul>
<li>finn alle faktorer av et tall</li>
<li> Pytagoreiske tripler </li>
</ul>
</aside>
