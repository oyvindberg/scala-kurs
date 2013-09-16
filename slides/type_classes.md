# Type classes #
From Haskell with love

---

## Historie ##
- Opprinnelig fra Haskell-verdenen
- Brukt som «class of types», ikke i kontekst OO-klasse
- Ikke en språkkonstrukt, men et pattern
- Ikke en del av Scala-dokumentasjonen

---

## Definisjon ##
- En kontrakt som definerer oppførselen til en type
- Er definert utenfor typen - kan utvide lukkede typer
- Alle typer som er definert for typeklassen har typeklassens oppførsel

---

## Eksempel ##
- Man driver med kommunikasjon over flere protokoller, hvor boolean er definert forskjellig
- Man bruker «t, true, 1, 1.0» som boolean-verdier, og vi ønsker å få dette typed

```
asBoolean(1)      // true
asBoolean("true") // true
asBoolean(123)    // false
```

--

### Definisjon og implementasjon ###
```
trait BooleanLike[A] {
  def asBool(a: A): Boolean
}

object BooleanLike {
  implicit val intBooleanLike = new BooleanLike[Int] {
    def asBool(a: Int) = a match {
      case 1 => true
      case _ => false
    }
  }

  def asBoolean[A](a: A)(implicit bla: BooleanLike[A]) = bla.asBool(a)
}
```

--

### Men,  hva om? ###

```
@implicitNotFound("No implicit for ${A} found in scope. 
      Implement one in the BooleanLike companion object.")
trait BooleanLike[A] {
  def asBool(a: A): Boolean
}
```

--

### Litt syntaktisk krydder for sjel og IDE ###
```
object BooleanLike {
  ...
  
  implicit class RichNumberLike[A : BooleanLike](a: A) {
    def boolean = implicitly[BooleanLike[A]].asBool(a)      
  }
}
```

--

### Og voila! ###
```
scala> import BooleanLike._
import BooleanLike._

scala> asBoolean(1) //typen er inferred
res1: Boolean = true

scala> asBoolean(123)
res2: Boolean = false
```
```
scala> asBoolean("true")
<console>:24: error: No implicit for String found in scope. Implement one in the BooleanLike companion object.
              booleanLike[String]("true")
```
```
scala> 1.boolean
res4: Boolean = true

scala> 123.boolean
res5: Boolean = false
```
