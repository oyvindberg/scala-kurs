# Interop med Java



### Scala er kompatibelt med java:

- Scala kompilerer til Java bytecode
- Scala-klasser er Java-klasser (og motsatt)
- I Java-kode kan man arve fra Scala-klasser (og motsatt)



Eksempel: Vanlig klasse
```scala
class Animal {
  def sound = "generic animal sound"
}
```

Java-kode (fra javap):
```java
$ scalac Animal.scala
$ javap Animal.class
Compiled from Animal.scala"
public class Animal {
  public java.lang.String sound();
  public Anima();
}
```



Eksempel: Abstrakt klasse
```scala
abstract class Animal {
  def sound: String
}

```

Java-kode (fra javap):
```java
$ scalac Animal.scala
$ javap Animal.class
Compiled from Animal.scala"
public abstract class Animal {
  public abstract java.lang.String sound();
  public Animal();
}
```




### traits

Scala:
```scala
trait Animal {
  def sound: String
}
```

Java:
```scala
$ scalac Animla.scala
$ javap Animal.class
Compiled from "Animal.scala"
public interface Animal {
  public abstract java.lang.String sound();
}
```




### Men hva med Scala-features uten en Java-ekvivalent?




### trait med implementasjon av metoder
Scala:
```scala
trait Animal {
  def sound: String

  def eat: Unit = println("Spiser litt da")
}

class Cow extends Animal {
  val sound = "moo"
}
```



Java:
```scala
public interface Animal {
  public abstract java.lang.String sound();
  public abstract void eat();
}
public abstract class Animal$class { // Klasse med implementasjon av eat
  public static void eat(Animal) {
     System.out.println("Spiser litt da");
  }
}
public class Cow implements Animal {
  public void eat() {
    Animal$class.eat(this); // Delegerer til Animal$class
  }
  public java.lang.String () {
    return "moo";
  }
  public Cow();
}

```



### Java <-> Scala, generelt
- Å kalle Java fra Scala er enkelt
- Kan være litt mer arbeid å gå andre veien
- Bruk javap ved problemer med bruk av Scala fra Java!
