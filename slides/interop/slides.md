# Java/Scala interoperabilitet



### Javap
- Verktøy som følger med JDKen
- Dekompilerer Java klasse-filer

Eksempel:
```scala
// Foo.scala:
class Foo {
  def bar = "bar"
}
```

Scalac og Javap:
```scala
$ scalac Foo.scala 
$ javap Foo.class
Compiled from "Foo.scala"
public class Foo {
  public java.lang.String bar();
  public Foo();
}
```



Kan velge å se byte-kode:
```scala
$ javap -c Foo.class
Compiled from "Foo.scala"
public class Foo {
  public java.lang.String bar();
    Code:
       0: ldc           #11       // String bar
       2: areturn       

  public Foo();
    Code:
       0: aload_0       
       1: invokespecial #17       // Method java/lang/Object."<init>":()V
       4: return        
}
```



### Scala oversettes til Java-byte-kode
- Scala- og Java-features som er like oversettes stort sett til samme type byte-kode
- Annen Scala-kode må bruke en form for byte-kode-"encoding" vi skal se noen eksempler på



### Java <-> Scala, generelt
- Å kalle Java fra Scala er enkelt
- Kan være mer arbeid å kalle Scala fra Java 



### Val og var

```scala
class Person(val name: String, var age: Int)
```

```java
public class Person {
  public java.lang.String name();
  
  public int age();
  public void age_$eq(int);
  
  public Person(java.lang.String, int);
}
```



get og set kan genereres med @BeanProperty:
```java
public class Person2 {
  public java.lang.String name();
  
  public int age();
  public void age_$eq(int);
  public void setAge(int);
  public int getAge();
  
  public Person2(java.lang.String, int);
}
```



### traits

Scala:
```scala
trait Calc {
  def add(a: Int, b: Int): Int
  def subtract(a: Int, b: Int): Int
  def mult(a: Int, b: Int): Int
}
```

Java:
```java
public interface Calc {
  public abstract int add(int, int);
  public abstract int subtract(int, int);
  public abstract int mult(int, int);
}
```



