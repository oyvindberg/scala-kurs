##flere parametersett

```scala
def unless(exp:Boolean)(code: => Unit) = if (!exp) code

unless(x < 5) {
  println("x was not less than five")
}
```

---

##lokale funksjoner
```scala
def factorial(of: Int) = {
  def fact(i: Int, acc: Int): Int =
     if (i <= 1) acc else fact(i - 1, i * acc)

  fact(of, 1)
}
```

---

##generisk funksjon
```scala
def reverseList[T](ts: List[T]) = ts.reverse
```

--

##stil
```scala
//metode uten parametere kalles uten parenteser
def secretNumber: Int = ???
val ret = secretNumber

//tomt parametersett indikerer sideeffekt
rollback()

//kan bruke blokker - disse skriver begge ut 2
println{
  val i = 1
  i + 1
}
println(2)
```

---

##«Operatorer»

Infix notasjon
```scala
"skolebrød".contains("skole")
"skolebrød" contains "brød"
```

Ikke-alfanumeriske identifiere
```scala
class BigDecimal{
  def +(that: BigDecimal): BigDecimal = ...
  ...
}
```

et voilà
```scala
val a: BigDecimal = 1e25
a + 0.01
//res0: scala.math.BigDecimal = 10000000000000000000000000.01
```

---

##Statements er expressions
```scala
val res1 = if (x > y) x else y
//res1: Int = 3

val res2 = try {1/0} catch {case e: ArithmeticException => -1}
//res2: Int = -1

//mer generelt:
val res3 = {
    2.3
    3.2
}
//res3: Double = 3.2
```

---

##lazy
utsatt kjøring av kode
```scala
lazy val content = {
  println("henter")
  Source.fromURL(new URL("..."))
}
println("start")
person.name
//start
//henter
```

---

##Strenger

```scala
"vanlig string"

s"interpolerte strenger $variabel ${annen.property}"

"""triple quoted string kan gå over flere linjer
og inneholde tegn som " og ' """
```

---

## equality
```scala
new String("Kake") == new String("Kake") //true  (javas equals)
new String("Kake") eq new String("Kake") //false (javas ==)

"a" ne "b" //true
"a" != "b" //true
```

---

##tupler
```scala
val t = (1, "Hola", 313)
//t: (Int, String, Int) = (1,Hola,313)

//hent ett av elementene (1-indeksert)
t._1

//pakk ut tuppel
val (i, s, bil) = t

//returnere flere ting fra funksjon
def minmax(a: Int, b: Int): (Int, Int) =
  if (a < b) (a, b) else (b, a)

```

---

#funksjoner

---

##Anonyme funksjoner
```scala
def format(i: Int, formatter: Int => String) = formatter(i)

format(2, (i: Int) => i.toString)
//res0: String = 2

format(3, _.toString)
//res1: String = 3

```

---

##Funksjonsliteraler
```scala
def format(i: Int, formatter: Int => String) = formatter(i)

val starsOfLength1: Int => String = (length) => "*" * length

format(42, starsOfLength)
//res0: String = ******************************************
```

---

##Call by name
delayed computation

```scala
def time[T](f: => T) = {
    val t0  = System.currentTimeMillis
    val ret = f
    logger.debug(s"evaluation took ${System.currentTimeMillis - t0} ms")
    ret
}

time {
  (0 to 100000).foreach(_ => new Exception)
}
//evaluation took 292 ms
```

---

##Partial application
kan fylle ut parametersett av gangen
```scala
def add(i1: Int)(i2: Int) = i1 + i2

val oneAdder = add(1) _
//oneAdder: Int => Int = <function1>

oneAdder(1)
//res0: Int = 2
```

---

# Oppgaver #
BasicsTest

