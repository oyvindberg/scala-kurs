## OOP

```scala
class Person {

}
object Person {

}
```

```scala
class Person(name: String, age: Int) {

}
```

```scala
class Person(val name: String, val age: Int) {
  // def name(): String
  // def age(): Int
}
```

```scala
class Person(var name: String, var age: Int) {
  // def name(): String
  // def name_=(s: String): Unit

  // def age(): Int
  // def age_=(i: Int)
}
```

```scala
class Person(@BeanProperty val name: String,
            @BeanProperty var age: Int) {
  // def getName(): String
  // def getAge(): Int
  // def setAge(age: Int): Unit
}
```

```scala
class Person(name: String, age: Int) {
  println("Person created")

  def this(name: String, age: Int, address: String) = {
    this(name, age)
  }
}
```

### Traits ###
```scala
trait DatabaseConnection {

}
```
