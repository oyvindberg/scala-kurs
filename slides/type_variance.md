# Type variance #
- Hensikten med typevarians er å definere arverelasjoner
- Typeparametre defaulter til invarians
- De kan eksplisitt defineres til å være ko- eller kontravariant

Noen eksempler:
```
List[+A]
Writer[-A]
Function1[-T, +R]
```

---

## Invariance ##
`SomeType[A]`

- Bør brukes i de aller fleste muterbare strukturer
- Alle type-konstruktører i Scala defaulter til nonvarians
- Låser typen

```
class Cell[T](t: T) {
  private var current = t
  def get = current
  def set(x: T) { current = x }
}

val c1 = new Cell[String]("abc")
val c2: Cell[Any] = c1    // TImpl <: TSuper, 
c2.set(1)                 //   but class Cell is invariant in type T
val s: String = c1.get    
```

--

### Java vs. Scala ###
T[]
```
String[] a1 = { "abc" };  // fra String
Object[] a2 = a1;         // via Object
a2[0] = new Integer(17);  // Runtime: Exception in thread "main" 
String s = a1[0];         //   java.lang.ArrayStoreException
```

Array[T]
```
val a1 = Array("abc")     // fra String
val a2: Array[Any] = a1   // Compile time: String <: Any, 
a2(0) = 17                //   but class Array is invariant in type T
val s: String = a2(0)      
```

---

## Covariance ##
`SomeType[+A]`

- `A <: B` __=>__ `SomeType[A] <: SomeType[B]`
- Veldig nyttig hvis man har immutable objecter og ønsker å gjøre disse så generell som mulig
- Dyr __=>__ Katt

```
class Invariant[A]
def doesItCompile(i: Invariant[Any]) {}
doesItCompile(new Invariant[String]) 
// Note: String <: AnyRef, but class Queue is invariant in type A.
// You may wish to define A as +A instead. (SLS 4.5)
```

```
// doesItCompile krever en mer spesifikk type
class Covariant[+A]
def doesItCompile(i: Covariant[Any]) {}
doesItCompile(new Covariant[String]) 
// Kompilerer som en helt!
```

<aside class="notes">
  Suppose you have a collection C[+T]. What the +T means is that if U <: T, then C[U] <: C[T]. Fair enough. But what does it mean to be a subclass? It means that every method should work that worked on the original class. So, suppose you have a method m(t: T). This says you can take any t and do something with it. But C[U] can only do things with U, which might not be all of T! So you have immediately contradicted your claim that C[U] is a subclass of C[T]. It's not. There are things you can do with a C[T] that you can't do with a C[U].

  Now, how do you get around this?

  One option is to make the class invariant (drop the +). Another option is that if you take a method parameter, to allow any superclass as well: m[S >: T](s: S). Now if T changes to U, it's no big deal: a superclass of T is also a superclass of U, and the method will work. (However, you then have to change your method to be able to handle such things.)
</aside>

---

## Contravariance ##
`SomeType[-A]`

- `B >: A` __=>__ `SomeType[A] >: SomeType[B]`
- `Katt` __=>__ `Dyr`

```
trait EventListener[-E] { 
  def listen(e: E) 
}

def addKeyEventListener(l: EventListener[KeyEvent]) //KeyEvent <: Event
def addMouseEventListener(l: EventListener[MouseEvent]) //MouseEvent <: Event

class LogEventListener extends EventListener[Event] {
   def listen(e: Event) { log(event) }
}
```

---

## Dagligdagse variansproblemer ##

Hvorfor funker ikke dette?
```
scala> class Test[+A] {
| def test(a: A): String = a.toString 
|}
<console>:8: error: covariant type A occurs in
contravariant position in type A of value a
```

--

### `Function1[-T, +R]` ###

- Disse er kontravariante på parametre og kovariante på returtype
- Hvis `A <: B` og `C <: D` så kan vi erstatte `Function1[A, D]` med `Function1[B, C]`

```
class Test[+A] {
 def test(a: A): String = a.toString 
}
```

- Type A skulle egentlig vært invariant eller kontravariant, men her er den kovariant
- Kan løses med en bounded type, hvor vi sier at input til test alltid er en supertype av A!

```
class Test[+A] {
 def test[B >: A](b: B): String = b.toString 
}
```

--

Og det er hvorfor muterbare strukturer ikke kan være kovariante!

```
trait Mutable[+T] {
    var t: T // generate a setter:
}            // def t_=(t: T) {this.t = t}
```


