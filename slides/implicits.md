#Implicits



# Hva?
- Støtte i compileren for å hjelpe deg å skrive kode



##Implicit conversions (I)

Konvertere fra en type til en annen ved behov
```scala
def decimalYear(dt: org.joda.time.DateTime): Double = {
    val daysInYear = if (dt.year.isLeap) 366.0 else 365.0
    dt.getYear + dt.getDayOfYear / daysInYear
}

implicit def date2datetime(d: java.util.Date) = new DateTime(d.getTime())

decimalYear(new java.util.Date)
//res0: Double = 2013.813698630137
```



##Implicit conversions (II)
Legge ekstra funksjonalitet til eksisterende type
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
Legge på hva som oppleves som syntax

```scala
/* Lager tupler av ting som blir satt sammen med → */
class ArrowAssoc[A](val x: A) {
 def →[B](y: B): (A, B) = (x, y)
}
implicit def any2ArrowAssoc[A](x: A): ArrowAssoc[A] = new ArrowAssoc(x)

1 → "one"
//res0: (Int, String) = (1,one)
```



##Implicit conversion (class)
Genererer konverteringsfunksjonen for deg
```scala
implicit class DateParser(val s: String) extends AnyVal {
    def parseDate: LocalDate = LocalDate.parse(s);
}
"2013-01-1".parseDate
//res0: org.joda.time.LocalDate = 2013-01-01
```



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
