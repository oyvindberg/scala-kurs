# Pattern matching #



> Generally speaking, pattern matching is a technique for assigning names to things
> and decomposing data structures and objects with a known structure into its underlying parts.
> 
> -- <cite>[Pattern Matching in Scala][1]</cite>

[1]: http://wiki.ifs.hsr.ch/SemProgAnTr/files/PatternMatchingInScala.pdf



Fancy greet-metode:
```scala
def greet(person: Person) {
  if (person.gender == MALE)
    println("Hello, Mr. " + person.name)
  else if (person.gender == FEMALE)
    println("Hello, Mrs. " + person.name)
  else
    println("Hello, " + person.name)
} 
```
Med pattern matching:
```scala
def greet(person: Person) {
  person match {
    case Person(MALE, name)   => println("Hello, Mr. " + name)
    case Person(FEMALE, name) => println("Hello, Mrs. " + name)
    case Person(_, name)      => println("Hello, " + name)
  }
}
```



### Syntaks: ###
> selector match { alternatives }

```scala
def fib(n: Int) : Int = n match {
  case 0 => 0
  case 1 => 1
  case _ => fib(n-1) + fib(n-2)
}
```



### Noen forskjeller fra Java's 'switch': ###

- match er et uttrykk i Scala og vil alltid resultere i en verdi
- ingen "fall-through"
- hvis ingen patterns matcher blir det kastet en Exception (MatchError)



### Egenskaper: ###
- Kan brukes til å prøve å matche objekter med patterns som selv er strukturerte og inneholder variabler
- Patterns kan tillegges "guards" for flere regler
- Patterns kan nøstes
- Scala-kompilatoren kan hjelpe til med å finne mulige manglende kombinasjoner



### Case classes: ###
```scala
case class Person(name: String, age: Int)
```
Generer boilerplate-kode som gjør at vi kan pattern matche mot objekter av klassen!



### Andre fordeler med case classes: ###
- Factory-metode med samme navn som klassen:
```scala
val person = Person("Stig", 29)
```
- 'val' foran alle argumenter i parameter-listen:
```scala
scala> person.name
res1: String = Stig
```
- Implementasjoner av toString, hashCode og equals
```scala
scala> Person("Ola", 10) == Person("Ola", 10)
res3: Boolean = true
```
- 'copy'-metode: 
```scala
val person2 = person.copy(age = person.age + 1)
```



### Ulemper med case classes: ###

- Klassene og metodene blir litt større (pga ekstra metoder og implisitte fields)
- Kan være at man ikke vil gi tilgang til alle parameterne



## Noen patterns ##



### Konstanter og variabler: ###
```scala
def isStig(person: Person): Boolean = {
  person match {
    case Person("Stig", age) => true
    case Person(name, age) => false
  }
}
```



### Wildcards ###
```scala
def isStig(person: Person): Boolean = {
  person match {
    case Person("Stig", _) => true
    case _ => false
  }
}
```



### Lister ###
```scala
def startsWith123(list: List[Int]): Boolean = {
  list match {
    case List(1, 2, 3, _*) => true
    case _ => false
  }
}
```



### Tupler ###
```scala
def printTuple(x: Any) {
  x match {
    case (a, b) => println(a + " " + b)
    case _ => 
  }
}
```



### Type casts ###
```scala
def size(x: Any) {
  x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case l: List[_] => l.length
    case _ => -1
  }
}
```



### Guards ###
```scala
// TODO Find a less silly example
def printPersonIfOlderThan28(person: Person) {
  person match {
    case Person(name, age) | if age > 28 => println(name )
    case _ => 
  }
}
```



### Sealed classes ###
```scala
sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, l: Expr, r: Expr) extends Expr

def describe(e: Expr) = {
  e match {
    case Var(name) => "A variable with name = " + name
    case Number(num) => "A number with value = " + num
  }
}
```
Kompilatorhjelp:
"match may not be exhaustive.
It would fail on the following inputs: BinOp(_, _, _), UnOp(_, _)"


### Option matching ###
```scala
foo match {
  case Some(value) => println value
  case None => _
}
```




### Pattern matching ###
```scala
abstract class Tree

case class Node(value: Int, left: Tree, right: Tree) extends Tree

case class Leaf() extends Tree
```
```scala
def lol(p: Tree): String = {
  p match {
    case Node(v, _, _) if v < 18 => s"lol! Value is ${v}"
    case a@Node(20, _, _) => a.toString
    case t: Leaf => "Leaf"
    case _ => "Whut?"
  }
}
```



```scala
def sumTree(tree: Tree): Int = {
  tree match {
    case Branch(value, left: Tree, right: Tree) => value +
      sumTree(left) + sumTree(right)
    case Leaf(value) => value
  }
}
```



```scala
def sumTree(tree: Tree): Int = {
  // selector match {alternatives}
  tree match {
    // Case pattern => expression:
    case Branch(value, left: Tree, right: Tree) => value +
      sumTree(left) + sumTree(right)
    case Leaf(value) => value
  }
}
```




### Case sequences as partial functions ###
Kan skrive funksjoner som en sekvens av case-uttrykk:
```scala
val generalSize: Any => Option[Int] = {
    case l: List[_] => Some(l.size)
    case a: Array[_] => Some(a.length)
    case _ => None
}

val someList: List[Any] = List("foo", List(1, 2, 3), Map("a" -> "b"))

someList.collect(generalSize).sum // res0: Int = 7
```



### Extractors: Pattern matching uten case classes ###
```scala
// foo
```
