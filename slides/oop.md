## Object-Oriented Scala ##



```scala
class Person(id: Int, name: String)
```
<aside class="notes">
        ikke public class -> public by default
        Trenger ikke body.
        parametrene til konstruktoren
        Private felter.
</aside>



```scala
class Person(val id: Int, val name: String)
```
<aside class="notes">
        Kompilatoren genererer accessors (tilsvarende get)
        Både klasser, metoder og felter er public by default, gitt at de har var/val
        Også muligheter for å definere klasser med abstract class -> som i Java
</aside>



```scala
class Person(val id: Int, val name: String) {
  // def name: String
  // def id: Int
}
```
<aside class="notes">
        Transparant for klient om det er et felt eller en metode
        Metode og felter har samme namespace => kan bruke val for å override def
        MEN gjør den lazy
        OBS: Hvis metoder (def) er definert uten paranteser kan du ikke kalle
            de MED paranteser
</aside>



```scala
class Person(var id: Int, var name: String) {
  // def name: String
  // def name_=(s: String): Unit

  // def age: Int
  // def age_=(i: Int): Unit
}
scala>val p = new Person(29, "nina")
```
<aside class="notes">
        Både setter og gettere
        Brukes sjelden i praksis, med unntak når du skal være Java-kompatibel
</aside>



```scala
class Person(@BeanProperty val id: Int,
             @BeanProperty var name: String) {
  // def getName(): String
  // def setName(name:String): Unit
  // def getId:Int
}
```
<aside class="notes">
        Kompatibel med Java, f.eks. Spring MVC og Hibernate som krever Javabean
        Finnes også en BooleanBeanProperty som lager isMetode istf get
</aside>



```scala
class Person(id: Int, name: String) {
  println("Person created")

  def this(id: Int, name: String, address: String) = {
    this(name, age)
  }
}
```
<aside class="notes">
        Konstruktor er bodyen!
        Lage flere konstruktører med this, må kalle primær konstruktur først!
        Men - ser aldri bruk av this da det finnes bedre alternativer.
</aside>



### Companion object ###
```scala
class Person(val id: Int, val name: String, val address: Option[String])

object Person {

}
```
<aside class="notes">
        Companion object - må være i samme fil (funker dårlig i REPL uten scoping)
        Ikke statiske metoder - object er singleton
</aside>



```scala
class Person(val id: Int, val name: String, val address: Option[String])

object Person {

  def apply(id: Int, name: String, address: Option[String]) =
        new Person(id, name, address)

  def apply(id: Int, name: String) = new Person(id, name, None)

  def apply(name: String) = new Person(0, name, None)

}
```
```scala
scala> val p = Person(1, "Ola")
// p: Person = Person@306b208
```



### Default arguments ###

```scala
class Person(val id: Int, val name: String, 
                    val address: Option[String] = None) {

  override def toString() = "(" + id + ", " + name + ", " + address + ")"
}
```
```scala
scala> val p = new Person(1, "Ola", Some("Grensen 5-7"))
p: Person = (1, Ola, Some(Grensen 5-7))

scala> val p2 = new Person(2, "Kari")
p2: Person = (2, Kari, None)
```



### Named arguments ###
```scala
class Person(val id: Int, val name: String, 
                    val address: Option[String] = None) {

  override def toString = "(" + id + ", " + name + ", " + address + ")"
}
```
```scala
scala> val p = new Person(name="Ola", id=1)
p: Person = (1, Ola, None)
```



### Traits ###
```scala
trait DatabaseConnection {
  def db: DB
}
```
<aside class="notes">
   Litt som interfaces is java - men veldig mye mer!
   Kan gjøre det samme som klasser, bare ikke konstruktorer
   Når skal man bruke traits og når klasser?
   - traits bra hvis det skal gjenbrukes i klasser som ikke har noe med hverandre å gjøre (cross-cutting conserns)
</aside>



### Diamond problem ###

![alt text](images/diamond-of-death.png)



```scala
class IntQueue {
    def get:Int = 0
    def put(x: Int) = println(x)
}

trait Doubling extends IntQueue {
    abstract override def put(x:Int) = super.put(x * 2)
}

trait Incrementing extends IntQueue {
    abstract override def put(x:Int) = super.put(x + 1)
}

class DoubleThenIncrement extends Incrementing with Doubling {
   override def put(x:Int) = super.put(x) 
}
```
```scala
> val q = new DoubleThenIncrement
> q.put(2)
// 5
```
<aside class="notes">
- multiple inheritance - ambiguity
- traits are mixins - not really inheritance - no ambiguity
- den siste mixet inn vinner
</aside>



```scala
trait DatabaseConnection {
  def db: DB
}

trait InMemoryDbConnection extends DatabaseConnection {
  lazy val db = H2Database{....}
}

trait BilforsikringRepository extends DatabaseConnection {
  lazy val db = PostgreSql{....}
}

trait BilforsikringRepositoryTest extends InMemoryDbConnection {

}

```
<aside class="notes">
    NB: Extends her betyr ikke arv, Scala syntax
    krever at det må være først
</aside>



```scala
trait Loggable {
 self =>

 val logger = Slf4jLoggerFactory.getLogger(self.getClass())

 def debug[T](msg: => T):Unit = {
      if (logger.isDebugEnabled()) logger.debug(msg.toString)
  }
}
```
<aside class='notes'>
        self type -> trait vet hvilken klasse den er mikset inn i
</aside>



### Imports ###
```scala
import java.util.Date
import java.sql.{Date => SqlDate}
import java.sql._
```
<aside class="notes">
    Kan importere hvorsomhelst i fila
    Mulig å rename og ekskludere deler av scopet
</aside>



### Case classes: ###
```scala
case class Person(name: String, age: Int)
```



```java
public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
      this.name=name;
      this.age=age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String toString(){
        return "Person("+name+","+age+")";
    }

    public int hashCode(){
        return name.length() * age;
    }

    public boolean equals(Object o){
        if(o == null) return false;

        if(!(o instanceof Person))
            return false;

        if(getName() == null)
            return false;

        Person p = (Person) o;
        if(!(getName().equals(p.getName())))
            return false;

        if(!(getAge() == p.getAge()))
            return false;

        return true; 
    }
}
```
<aside class="notes">
    Why do we care? Kode kan genereres, og ikke typinga som begrenser oss 
</aside>



> [..] a good programmer can reasonably maintain about 20,000 lines of code

> [..] language doesn't matter. It's still 20,000 lines of code.
> -- <cite>Guido Van Rossum, creator of Python</cite>



### Case classes reduserer boilerplate: ###

- Implementasjoner av toString, hashCode og equals legges til
```scala
scala> Person("Ola", 10) == Person("Ola", 10)
res3: Boolean = true
```
- Får en factory-metode med samme navn som klassen:
```scala
val person = Person("Stig", 29)
```
- 'val' legges til foran alle argumenter i parameter-listen:
```scala
scala> person.name
res1: String = Stig
```
- 'copy'-metode legges til:
```scala
val person2 = person.copy(age = person.age + 1)
```



### javap ###
```scala
$ javap Person.class
Compiled from "Person.scala"
public class Person implements scala.Product,scala.Serializable {
  public static final scala.Function1<scala.Tuple2<java.lang.String, 
    java.lang.Object>, Person> tupled();
  public static final scala.Function1<java.lang.String, 
    scala.Function1<java.lang.Object, Person>> curry();
  public static final scala.Function1<java.lang.String, 
    scala.Function1<java.lang.Object, Person>> curried();
  public scala.collection.Iterator<java.lang.Object> productIterator();
  public scala.collection.Iterator<java.lang.Object> productElements();
  public java.lang.String name();
  public int age();
  public Person copy(java.lang.String, int);
  public int copy$default$2();
  public java.lang.String copy$default$1();
  public int hashCode();
  public java.lang.String toString();
  public boolean equals(java.lang.Object);
  public java.lang.String productPrefix();
  public int productArity();
  public java.lang.Object productElement(int);
  public boolean canEqual(java.lang.Object);
  public Person(java.lang.String, int);
}
```
<aside class="notes">
    - men her finnes f.eks. ikke apply!
    - case class kompileres ned til to class-filer, en som heter Person.class og en som har en ekstra $
</aside>



### javap ###
```scala
$ javap Person$.class
Compiled from "Person.scala"
Compiled from "Person.scala"
public final class Person$ extends scala.runtime.AbstractFunction2 implements scala.ScalaObject,scala.Serializable {
  public static final Person$ MODULE$;
  public static {};
  public final java.lang.String toString();
  public scala.Option unapply(Person);
  public Person apply(java.lang.String, int);
  public java.lang.Object readResolve();
  public java.lang.Object apply(java.lang.Object, java.lang.Object);
}
```
<aside class="notes">
 En ulempe med case classes: Klassene og metodene blir litt større
 (pga ekstra metoder og implisitte fields)
</aside>



## Access modifiers ##
- public by default (classes/objects/methods/fields)
- keywords private og protected
- private virker som i Java
- protected veldig forskjellig.
<aside class='notes'>
   private[this] også mulig, da er det kun samme instans
   som har tilgang - det er som oftest dette du vil
</aside>



### Protected ###
- to former: protected og protected[something]
- protected - kun tilgjengelig fra subclasses (IKKE pakken)
- ønsker du pakke-protected: protected[pakkenavn]



### Pakker og filnavn ###
- pakkenavn trenger ikke å matche mappestruktur
- public klasser kan ligge i filer som heter hvasomhelst (eks. feature.scala)
- en fil inneholder typisk en rekke klasser, objekter, og traits
<aside class="notes">
    Idiomatisk Scala har mange små klasser og objekter. Vanlig å gruppere ting i
    filer etter features.
</aside>



### Oppsummering/konklusjon ###
- flere muligheter en Java
- case class når immutable, får fornuftig hashCode, equals og toString gratis
- traits kan ha delvis implementasjon eller være ren abstrakt
- bruk traits hvis du kan
- ikke statiske metoder, de skal være i et object



### Oppgaver! ###
I scalakurs/oop:
- IntQueueTest (traits)
- ShapeTest (arv)
