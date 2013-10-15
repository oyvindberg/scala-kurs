# Java + Scala



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



### Scala oversettes til Java bytecode
- Scala-features som har en ekvivalent Java-feature oversettes til tilnærmet lik bytecode
- Annen Scala-kode må ta i bruk en enkoding vi skal se noen eksempler på



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

```scala
class Person(@BeanProperty val name: String, @BeanProperty var age: Int)
```

```java
public class Person2 {
  public java.lang.String name();
  
  public int age();
  public void age_$eq(int);
  public void setAge(int);
  public int getAge();
  
  public Person(java.lang.String, int);
}
```



### traits

Scala:
```scala
trait Model {
  def value: Any
}
```

Java:
```scala
$ scalac Model.scala
$ javap Calc.class
Compiled from "Model.scala"
public interface Model {
  public abstract java.lang.Object value();
}
```



### trait med implementert metode

Scala:
```scala
trait Model {
  def value: Any
}
```

```scala
public interface Model {
  public abstract java.lang.Object value();
}
// Ekstra klasse:
public abstract class Model$class {
  public static java.lang.String printValue(Model);
  public static void $init$(Model);
}
```



### Java <-> Scala, generelt
- Å kalle Java fra Scala er enkelt
- Kan være litt mer arbeid å gå andre veien
- Bruk javap ved problemer med bruk av Scala fra Java!
