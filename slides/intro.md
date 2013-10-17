#Intro



#Literals




#tall
```scala
42
0xCAFE
1000L
8f
1e30f
2.2
1.0e-100
```




#strenger

```python
"vanlig string"

s"interpolerte strenger $variabel ${annen.property}"

"""triple quoted string kan gå over flere linjer
og inneholde tegn som " og ' """
```




#annet
```scala
'a' '\u0041'
true false
null
<root/>                  // xml
’tataaa                  // symbol
```



#Variabler




##variabler

```scala

var i = 25
i += 1

var i2: Int = 25 //eksplisitt typet
```



##values
```scala
val d = 0.0
d = d + 1.0
//error: reassignment to val

val Φ = (math.sqrt(5) + 1)/2
```



#Metodedefinisjoner



##Full definisjon
```java
//java
public int plusOne(int i){
    return i + 1;
}

```
```scala
def plusOne(i: Int): Int = {
    return i + 1
}
```



##inferred returtype

```scala
def plusOne(i: Int) = {
    return i + 1
}
```



##return
Kodeblokker returnerer siste verdi
```scala
def plusOne(i: Int) = {
    i + 1
}
```



##braces
Enlinjers kodeblokker trenger ikke braces
```scala
def plusOne(i: Int) = i + 1

def plusTwo(i: Int) = {
    val increasedByOne = i + 1
    increasedByOne + 1
}
```



##no return
void -> Unit
```scala
def pointOf(): Unit = {
    println("here")
}
```

ekstra syntax
```scala
def pointOf() {
    println("here")
}
```



##varargs
```scala
def printThings(things: String*) {
    for (thing <- things) println(thing)
}

printThings("arne", "bjarne")
```



##default parameters
```scala
def createPerson(name: String, home: String = "127.0.0.1") =
    new Person(name, home)

createPerson("Arne")
//res0: Person = Person(Arne, 127.0.0.1)
```




##flere parametersett

```scala
def unless(exp:Boolean)(code: => Unit) = if (!exp) code

unless(x < 5) {
  println("x was not less than five")
}
```



##lokale funksjoner
```scala
def factorial(of: Int) = {
  def fact(i: Int, acc: Int): Int =
     if (i <= 1) acc else fact(i - 1, i * acc)

  fact(of, 1)
}
```



#Funksjonskall



##stil
```scala
//metode uten parametere kalles uten parenteser
def noarg: Int = ???
val ret = noarg

//tomt parametersett indikerer sideeffekt
def applySideEffect() { ??? }
applySideEffect()

..mer her?
```



##Scalas «operatorer»

forskjellen på metodekall og operator? *infix notasjon*
```scala
"skolebrød".contains("skole")
"skolebrød" contains "brød"
```

og *ikke-alfanumeriske identifiere* <3
```scala
(2).-(1).-(1)
res0: Int = 0
```



##named parameters
```scala
def createPerson(name: String, home: String = "127.0.0.1") =
    new Person(name, home)

createPerson(home = "where the computer is", name="Bjarne")
//res0: Person = Person(Bjarne,where the computer is)
```



# kontrollstrukturer
- mangel av kontrollstrukturer
- expressions istedet for statements
- if/else
- for
- while?




##lazy

## equality? == versus eq

##tuples
- vise vanlig bruk

## null </3
- Option

##funksjoner
- definere funksjon som val (val length:String => Int =)
- vise hvordan du tar i mot en funksjon som funksjonsparameter
- vise hvordan du passer som parameter og hvordan du skriver en inline
- vise funksjon fra ()
- vise call by name
- ta funksjon som parameter