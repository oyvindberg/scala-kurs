#REPL

Read Evaluate Print Loop

```
//1. Via SBT:
$ sbt console //fra prosjekt-dir

//2. Direkte:
$ scala //hvis du har Scala installert

//REPL:
scala> 2 + 2
res0: Int = 4

scala> :help //printer ut alle tilgjengelige kommandoer
scala> :q    //quit, evt. Ctrl + c

```

---

#Variabler

---

##Variabler

```scala
var e: Int = 42 // var <navn>: <Type> = <verdi> (eksplisitt typet)

//med "type inference":
var i = 43 /look ma, no Type!
```
<aside class='notes'>
    Rekkefølge ikke som Java, lesbarhet
    Scala kompilator antar type hvis ikke angitt for variabler og funksjoner, mindre boilerplate
    var er lite brukt i ideomatisk Scala kode, "er det dette jeg egentlig?" Typisk bruk: performance og mutable Java API
    Enkle typer er deklarert med stor forbkostav: Int
</aside>

---

##Konstanter

```scala
val messageStart: String = "Hei..." // val <navn>: <Type> = <verdi>

//med "type inference":
val messageEnd = "..og hå"
```

---

#Metoder

---

##Definisjon
```scala
//def <navn>(<parameter_navn>: <parameter_type>): <retur_Type> = {body...}
def plusOne(i: Int): Int = {
    return i + 1
}
```

```scala
//èn linje:
def plusOne(i: Int): Int = return i + 1
```

```scala
//siste linje blir alltid returnert:
def plusOne(i: Int): Int = i + 1
```

```scala
//infered retur type:
def plusOne(i: Int) = i + 1
```
<aside class='notes'>
    ta med returtyper for public API
</aside>

---

##default parameters

```scala

def createPerson(name: String, home: String = "127.0.0.1") =
    new Person(name, home)

createPerson("Arne")
//res0: Person = Person(Arne, 127.0.0.1)
```

---

##named parameters
```scala
def createPerson(name: String, home: String = "127.0.0.1") =
    new Person(name, home)

createPerson(home = "where the computer is", name="Bjarne")
//res0: Person = Person(Bjarne,where the computer is)
```

---

##varargs
```scala

def printThings(things: String*) {
    for (thing <- things) println(thing)
}

printThings("arne", "bjarne")
```

---

##ingen retur
Unit er Scalas void
```scala
def sideEffect(): Unit = {
    println("Dette er en sideeffekt!")
}
```

```scala
//ekstra syntax
def sideEffect() {
    println("Dette er en sideeffekt!")
}
```