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



### Syntaks: ###
> selector match { alternatives }

Eksempel:
```scala
def fib(n: Int) : Int = n match {
  case 0 => 0
  case 1 => 1
  case _ => fib(n-1) + fib(n-2)
}
```



### Egenskaper: ###
- Kan matche objekter med objekter
- Patterns kan tillegges "guards" for flere regler
- Patterns kan nøstes
- Scala-kompilatoren kan hjelpe til med å finne mulige manglende kombinasjoner



### Typer patterns: ###

- Wildcard pattern
- Constant pattern
- Variable pattern
- Constructor pattern
- Sequence pattern
- Typed pattern



### Wildcard pattern ###
_ matcher hva som helst:
```scala
def printNameIfPerson(x: Any) = {
  x match {
    case Person(name, _) => println("Name: " + name)
    case _ => println("Not a person")
  }
}
```



### Constant pattern: ###
Matcher bare seg selv:
```scala
def describe(x: Any) = {
  x match {
    case 5  => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }
}
```



### Variable pattern: ###
Matcher hva som helst (på samme måte som wildcard patterns), men binder
variabelen til objektet man matcher på:
```scala
def printNameIfPerson(x: Any) = {
  x match {
    case Person(name, _) => println("Name: " + name)
    case somethingElse => println("Not a person: " + somethingElse)
  }
}
```



### Constructor pattern: ###
Sjekker klassetilhørighet og constructor-argumenter for objekter:
```scala
abstract class Tree
case class Node(value: Int, left: Tree, right: Tree) extends Tree
case class Leaf(value: Int) extends Tree

def bothDescendantsAreLeaves(tree: Tree) = {
  tree match {
    case Node(_, Leaf(_), Leaf(_)) => true
    case _ => false
  }
}
```



### Sequence pattern: ###
Kan matche på sekvens-typer som List og Array på samme måte som case-klasser:
```scala
list match {
  case List(0, _, _) => println("Found three-element list starting with 0!")
  case _ =>
}
```
Kan bruke _* for å matche et vilkårlig antall elementer:

```scala
list match {
  case List(0, _*) => println("Found list starting with 0!")
  case _ =>
}
```



### Tuple pattern: ###
```scala
def printTuple(x: Any) {
  x match {
    case (a, b) => println(a + " " + b)
    case _ =>
  }
}
```



### Typed pattern: ###
```scala
def generalSize(x: Any) {
  x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case l: List[_] => l.length
    case _ => -1
  }
}
```



### Option matching ###
```scala
foo match {
  case Some(value) => println value
  case None => _
}
```



### Variabel-binding: ###

```scala
def leftLeaf(tree: Tree) {
  tree match {
    case Node(_, leaf @ Leaf(_), child) => leaf
  }
}
```



### Pattern guard ###
Man kan kun bruke en pattern-variabel én gang så dette er ikke lov:
```scala
def leftAndRightAreEqual(tree: Tree) {
  tree match {
    case Node(_, child, child) => true
    case _ => false
  }
}
```

Løses med pattern guard:
```scala
def leftAndRightAreEqual(tree: Tree) = {
  tree match {
    case Node(_, left, right) if left == right => true
    case _ => false
  }
}
```



### Rekkefølge: ###
Kompilerer ikke: (error: unreachable code)
```scala
def sillyTreeMatch(tree: Tree) {
  tree match {
    case tree: Tree => println("Matched some tree")
    case Node(_, left, right) => println("Matched node")
    case Leaf(_) => println("Matched node")
  }
}
```
Kompilerer hvis vi bytter om:
```scala
def sillyTreeMatch(tree: Tree) {
  tree match {
    case Leaf(_) => println("Matched leaf")
    case Node(_, left, right) => println("Matched node")
    case tree: Tree => println("Matched some tree")
  }
}
```



### Kompilatorhjelp please ###
Kompilerer uten advarsler:
```scala
def sillyTreeMatch(tree: Tree) {
  tree match {
    case Leaf(_) => println("Matched leaf")
  }
}
```
Hva om vil vil at kompilatoren skal advare om at vi mangler patterns?



### Sealed classes ###
```scala
sealed  abstract class Tree
case class Node(value: Int, left: Tree, right: Tree) extends Tree
case class Leaf(value: Int) extends Tree

def sillyTreeMatch(tree: Tree) {
  tree match {
    case Leaf(_) => println("Matched leaf")
  }
}
```
warning: match is not exhaustive!"



### Patterns i variabel-definisjoer: ###
```scala
val someTuple = (1,2)
val (num1, num2) = someTuple
```



### Case sequences som partial functions ###
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



### Recap ###
TODO: Finn ut om vi skal ha en slik slide... kan være greit
å ha for å oppsummere mange av de ulike variantene pattern matching
som har blitt vist
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



### Extractors: Pattern matching uten case classes ###
Eksempel: Vi har trær med både "generelle" noder og binærnoder

```scala
abstract class Tree(v: Int)
case class Node(v: Int, children: List[Tree]) extends Tree(v)
case class BinaryNode(v: Int, left: Tree, right: Tree) extends Tree(v)
case class Leaf(v: Int) extends Tree(v)
```

Problem: Scala vet ikke hvordan man matcher en Node med en BinaryNode:
```scala
val node = Node(0, List(Leaf(1), Leaf(2)))
node match {
  case BinaryNode(value, left, right) => println("Binary node!")
  case Node(value, children) => println("Some node")
  case _ => "Not a node"
}
// => Some node
```




Løsning: Vi definerer en måte å gå fra en Node til elementene av en BinaryNode:

```scala
object BinaryNode {
  def unapply(node: Node): Option[(Int, Tree, Tree)] = {
    node match {
      case Node(value, List(left, right)) => Some(value, left, right)
      case _ => None
    }
  }
}
```

```scala
val node = Node(0, List(Leaf(1), Leaf(2)))
node match {
    case BinaryNode(value, left, right) => println("Binary node!")
    case Node(value, children) => println("Some node")
    case _ => println("Not a binary node")
}
// => Binary node!
```



Litt mer forklaring: Når man definerer
```scala
case class BinaryNode(v: Int, left: Tree, right: Tree) extends Tree(v)
```

genererer Scala kode blant annet en 'apply'-metod og en 'unapply'-metode:
```scala
object BinaryNode {
  def apply(value: Int, left: Tree, right: Tree): BinaryNode = {
    new BinaryNode(value, left, right)
  }
  def unapply(binaryNode: BinaryNode): Option[(Int, Tree, Tree)] = {
    Some((binaryNode.v, binaryNode.left, binaryNode.right))
  }
}
```

- apply: Bygger objekter fra deler
- unapply: Trekker ut underliggende deler fra objekter



unapply er den metoden Scala bruker for å gjøre pattern matching, og vår
BinaryNode hadde

```scala
  def unapply(binaryNode: BinaryNode): Option[(Int, Tree, Tree)]
```

men manglet
```scala
  def unapply(node: Node): Option[(Int, Tree, Tree)]
```
og det var det vi la til!



### Extractors, oppsummert ###
- Extractors kan være nyttig hvis man f.eks. har et API og man vil muliggjøre
  pattern matching uten å måtte bruke/eksponere case classer
- Nyttig for å lage egne patterns (TODO: Epost-String eksempel?)
- Gir litt dårligere ytelse enn å la Scala generere unapply via case
