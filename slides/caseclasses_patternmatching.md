### Case classes ###
```scala
scala> case class Person(name: String, age: Int)
```
```scala
scala> Person("Stig", 2)
// res2: Person = Person(Stig,2)
```
```scala
scala> Person("Stig", 2) == Person("Stig", 2)
// res1: Boolean = true
```
```scala
scala> case class Person(name: String, age: Int, dead: Boolean = false)
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



#### Constant patterns ####
```scala
def isStig(person: Person): Boolean = {
  person match {
    case Person("Stig", age) => true
    case Person(name, age) => false
  }
}
```



#### Wildcard patterns ####
```scala
def isStig(person: Person): Boolean = {
  person match {
    case Person("Stig", _) => true
    case _ => false
  }
}
```



#### Lister ####
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



### Pattern guards ###
```scala
// TODO Find a less silly example
def printPersonIfOlderThan28(person: Person) {
  person match {
    case Person(name, age) | if age > 28 => println(name )
    case _ => 
  }
}
```



### TODO Sealed classes ###
```scala
// foo
```


### TODO Option matching ###
```scala
// foo
```



### TODO Patterns in variable matching ###
```scala
// foo
```



### TODO Case sequences as partial functions ###
```scala
// foo
```




### TODO Patterns in for comprehensions (bare hvis for-comprehensions har blitt tatt før denne delen) ###
```scala
// foo
```



### TODO Extractors ###
```scala
// foo
```
