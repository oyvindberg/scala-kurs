# Type variance #

---

## Nonvariant ##
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

## Covariant ##
`SomeType[+A]`

- SomeType[A] er en subtype av SomeType[B] siden A er en subtype av B
- Veldig nyttig hvis man har immutable objecter og ønsker å gjøre disse så generell som mulig

```
class Cell[+T](t: T) {
  def get = t
  def set[B >: T](b: B) = new Cell(b)
}

val c1 = new Cell[String]("abc")
val c2: Cell[Any] = c1
val s = c2.set(1).get
```

---

## Contravariant ##
`SomeType[-A]`

- Alle metodeparametre forventes å være kontravariant