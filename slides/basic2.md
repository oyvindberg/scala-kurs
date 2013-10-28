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

##Ta som parameter
Flere måter å sende med funksjoner på
```scala
def format(i: Int, formatter: Int => String) = formatter(i)

//function literal
val starsOfLength = length => "*" * length
format(42, starsOfLength)

//anonym funksjon
format(2, i => i.toString)
format(3, _.toString)
```

---

- definere funksjon som val (val length:String => Int =)
- vise hvordan du tar i mot en funksjon som funksjonsparameter
- vise hvordan du passer som parameter og hvordan du skriver en inline
- vise funksjon fra ()
- vise call by name
- ta funksjon som parameter