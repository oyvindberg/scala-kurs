#Variabler

```scala
var e: Int = 42 // var <navn>: <Type> = <value> (eksplisitt typet)

//med "type inference":
var i = 43 /look ma, no Type!
```
<aside class='notes'>
    Rekkefølge ikke som Java, lesbarhet
    Scala kompilator antar type hvis ikke angitt for variabler og funksjoner, mindre boilerplate
    var er lite brukt i imperativ Scala kode, "er det egentlig hva jeg vil?" Typisk bruk: performance og mutable Java API
    Enkle typer er deklarert med stor forbkostav: Int
</aside>

--

#Konstanter

```scala
val messageStart: String = "Hei..." // val <navn>: <Type> = <value>

//med "type inference":
val messageEnd = "..og hå"
```

--

#Metoder

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
def plusOne(i: Int) = i + 1 //ta med for "lib interfaces"
```

```scala
//uten parametere: kan droppe "()" (hvis det ikke er sideeffekter)
def foo = "bar"
```

```scala
//default parametere
def createPerson(name: String, home: String = "127.0.0.1") =
    new Person(name, home)

createPerson("Arne")
//res0: Person = Person(Arne, 127.0.0.1)
```

--


```scala
//varargs
def printThings(things: String*) {
    for (thing <- things) println(thing)
}

printThings("arne", "bjarne")
```

--

#no return

```scala
def sideEffect(): Unit = { //Unit ~= void
    println("Dette er en sideeffekt!")
}
```

```scala
//return type inference og ingen "="
def sideEffect() { // () er med pga. sideeffekt
    println("Dette er en sideeffekt!")
}
```


#REPL
Read Evaluate Print Loop
```
$ scala
scala> 2 + 2
res0: Int = 4

scala> :help //printer ut alle tilgjengelige kommandoer
scala> :q    //quit, evt. Ctrl + c

```


#Literals


#Tall
```scala
42
0xCAFE
1000L
8f
1e30f
2.2
1.0e-100
```
<aside class='notes'>
    Scala støtter alle primitive typer i Java
</aside>


#Strenger

```scala
"vanlig string"

s"interpolerte strenger $variabel ${annen.property}"

"""triple quoted string kan gå over flere linjer
og inneholde tegn som " og ' """
```


#Metode, ikke operator
```scala
scala> 2 + 2 // egentlig: 2.+(2)

