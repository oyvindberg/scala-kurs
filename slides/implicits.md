#Implicits



# Hva?
- Støtte i compileren for å hjelpe deg å skrive kode



# Hvordan?
<br/>
###implicit parameters
- f()           => f(x)

<br/>
###implicit conversions:

- f(p: *Type*)   => f(p: *AnnenType*)
- *Type*.f(p)    => *AnnenType*.f(p)



## Umiddelbare effekter

 - Fjerning av repeterende kode
 - Nydelige APIer



## Muliggjør
 - programmering med typeklasser
 - assimilasjon av eksterne typer



##Ingen magi
<table align="center">
<tr><td> **Marking**        </td><td> markert med keywordet implicit</td></tr>
<tr><td> **Scope**          </td><td> importert, deklarert, eller assosiert med type</td></tr>
<tr><td> **Non-Ambiguity**  </td><td> to passende implisits samtidig vil ikke bygge\*</td></tr>
<tr><td> **One-at-a-time**  </td><td> ingen nøsting, *f(x)* vil aldri bli omskrevet til *f(y2z(x2y(x)))*\*\*</td></tr>
<tr><td> **Explicits-First**</td><td> ignorerer implisits om koden bygger uten</td></tr>
</table>
<br/>
\* En implicit kan bli foretrukket om den er i klart nærmere scope
\*\* men *x2y()* vil selv kunne ta implisitt parameter




##implicit parameters (I)
Lar compileren fylle ut resterende parametre til funksjonskall
```scala
case class Drink(asString: String)
object MyFavorites{
    implicit val drink = Drink("Sjokolademelk")
}
import MyFavorites.drink
def greetMsg(name: String)(implicit drink: Drink) =
    s"Hello $name! Can i get you a ${drink.asString}?"

greetMsg("Øyvind")
//res0: String = Hello Øyvind! Can i get you a Sjokolademelk?
```



##implicit parameters (II)

Ofte brukt til å for eksempel

- Finne riktig typeklasse-instans
- Passe kontekster du vil ha sjekket compile-time som for eksempel database-transaksjoner eller trådkoordinatorer

```scala
    def save(s: Something)(implicit s: Session)
    def act[T](initialValue: T)(implicit context: ExecutionContext)
```



##Implicit parameters (III)

Gir tvilsom verdi ved bruk til ren latskap

```scala
implicit val prefix = "Hei, "
def prefixed(s: String)(implicit prefix: String) = prefix + s
prefixed("Arne")
//res0: String = Hei, Arne
```



##Implicit conversions (I)

Funksjon som konverterer fra en type til en annen ved behov
```scala
import org.joda.time.DateTime

implicit def date2datetime(d: java.util.Date) = new DateTime(d.getTime())

new java.util.Date().plusYears(3)
//res0: org.joda.time.DateTime = 2016-10-10T17:49:05.411+02:00
````



##Implicit conversions (II)
Brukt til å legge ekstra funksjonalitet til eksisterende type
```scala
class RichInt(val self: Int){
  def until(end: Int): Range = Range(self, end)
  ...
}

implicit def intWrapper(x: Int) = new RichInt(x)

scala> 2 until 4
//res0: scala.collection.immutable.Range = Range(2, 3)
```



##Implicit conversions (III)
Brukt til å legge på hva som oppleves som syntax

```scala
/* Har tilsammen effekten å lage tupler av ting som blir satt sammen med → */
class ArrowAssoc[A](val x: A) {
 def →[B](y: B): (A, B) = (x, y)
}
implicit def any2ArrowAssoc[A](x: A): ArrowAssoc[A] = new ArrowAssoc(x)

/* Denne apply-funksjonen, som tar i mot et variabelt antall tupler, får
    det i sum til å se ut som at vi har et map literal i scala */
object Map{
    def apply[A, B](elems: (A, B)*) = ...
}

/* Dette er hva konsumenten av APIet ser */
Map(1 → "one", 2 → "two", 3 → "three")
```



##Implicit conversion (class)
Får
```scala
implicit class DateString(val s: String) extends AnyVal {
    def parseDate: java.util.Date = {
        new java.text.SimpleDateFormat("yyyy-MM-dd").parse(s)
    }
}
"2013-01-01".parseDate
//res0: java.util.Date = Tue Jan 01 00:00:00 CET 2013
```