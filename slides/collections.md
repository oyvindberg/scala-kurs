# Collections #



### Collection "Literals"###
```scala
List(1, 2, 3)
1 to 10 == Range(1, 10)
Map("josef" -> "stalin")
```



### Mutable / Immutable ###
mutable.List / immutable.List

mutable.Map / immutable.Map

(immutable er foretrukket)




### List ###
```scala
List(1, 2, 3)     ==     1 :: 2 :: 3 :: Nil
```



### List ###
```scala
class List[A] {
  ..
  def mkString: String 
  // List(1, 2, 3).mkString => "123"
  
  def mkString(sep: String): String 
  // List(1, 2, 3).mkString(", ") => "1, 2, 3"

  def mkString(start: String, sep: String, end: String): String 
  // List(1, 2, 3).mkString("< ", " | ", " >") => "< 1 | 2 | 3 >"
  ..
}
```



### List ###
```scala
class List[A] {
  ..
  def isEmpty: Boolean 
  def nonEmpty: Boolean 

  def size: Int 
  def length: Int 
  ..
}
```



### List (forts.) ###
```scala
class List[A] {
  ..
  def head: A        // første element
  def tail: List[A]  // resten

  def last: A        // siste element
  def init: List[A]  // resten
  ..
}
```



### List (forts.) ###
```scala
class List[A] {
  ..
  def headOption: Option[A] 
  def lastOption: Option[A] 
  ..
}

Er det for tidlig å introdusere Option?
```



### List (forts.) ###
```scala
class List[A] {
  ..
  def take(n: Int): List[A] 
  def drop(n: Int): List[A] 
  ..
}
```



### List (forts.) ###
```scala
class List[A] {
  ..
  def min: A 
  def max: A 
  ..
}
```



### List (forts.) ###
```scala
class List[A] {
  ..
  def sorted: List[A] // noe forenklet
  ..
}
```



### List ###
```scala
class Gamer(nick: String, alder: Int)

val gamers = List(gamer1, gamer2, .....)
```

Hvordan sorterer man gamers?
Hva er gamers.max ?



### List ###
Her introduseres høyereordens funksjoner
