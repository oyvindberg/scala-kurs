### Funksjonelle konsepter ###
<aside class='notes'>
  Ikke et kurs om funksjonell programmering, men viktig å kjenne til de
  viktigste konseptene.
  Funksjonelle aspektet viktig(ste) grunn til at Scala er et bedre valg en
  Java
  Ha dette i bakhodet, så blir det enklere å skjønne en del av
  finurlighetene til Scala
</aside>



### Immutability ###
Et objekt kan ikke bli modifisert etter at det er laget



### Immutability - implikasjoner ###
- kan ikke endre en datastruktur
- bruker ikke var, kun val
- 'settere' er ikke lov
- Ikke tradisjonelle kontrollstrukturer som looper



```java
// java
List<Integer> list = new ArrayList<>();
for (int i = 1; i <= 10; i++) {
        list.add(i * 2)
}
```
<aside class='notes'>
  <ul>
    <li>java lager lista først og legger til et element i lista</li>
    <li>hver gang du legger til et element, muterer man lista,</li>
    <li>variabelen i er en sak som man muterer, men innenfor dette scopet er det ok.</li>
    <li>Off-by-one-feil veldig vanlig.</li>
  </ul>
</aside>



```java
package java.util;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    // + a bunch of other methods
}
```
<aside class='notes'>
  <ul>
    <li>eksempel på idiotisk bruk at settere, fra java.util</li>
    <li>veldig lett å lage en ugyldig dato, eks. 30. februar</li>
    <li>når man klarer å gjøre sånne idiotiske ting som en del av java,
      hvor mye galskap gjør den jevne utvikleren?
    (riktignok deprecated i dag)</li>
  </ul>
</aside>



### Hvorfor immutable?###
- trådsikkert
- trygt å dele med klienter
- lett å teste
- lett å resonnere rundt
<aside class='notes'>
<ul>
<li> trådsikkert: Alle tråder har samme bilde av hva variabelen er, den endrer seg ikke </li>
<li> Dele med klienter - f.eks. at en klasse kan eksponere en liste uten å være redd for at den blir endret </li>
<li> lett å teste - fjerner tidsaspektet, minimerer antall variabler big time </li>
<li> Lett å resonnere rundt fordi at metoder og funksjoner er referentially transparent
   ... kommer tilbake til dette. </li>
</ul>
</aside>



### Pure functions ###
En funksjon som alltid returnerer den samme verdien basert på den samme input,
og ikke har side-effekter.
<aside class='notes'>
    Dvs resultatet avhenger kun av input
</aside>



```scala
// pure functions
def add(x: Int, y: Int) = x + y

def inc(x: Int) = x + 1

```



```scala
// impure functions
var global = 0
def f(x: Int) = x + global

def inc() = global + 1

```



```java
// impure function
Collections.sort(List<T> list) // returnerer void
```



```
public class Bil implements Comparable {....}
public class Bilforhandler {
    // lots of code omitted

    public List[Bil] biler {
        return biler;
    }
}

public class Client {
    public Bilforhandler bfh;

    public List[Bil] biler {
        // muterer Bilforhandler-klassen
        Collections.sort(bfh.biler);
    }
}
```



```scala
// pure
> val list = List('d', 'e', 'a')
//list: List[Char] = List(d, e, a)

> val sortedList  = list.sorted
//sortedList: List[Char] = List(a, d, e)

> list
// res0: List[Char] = List(d, e, a)
```
<aside class='notes'>
Sort er et eksempel på hvor (Java) språket virkelig ikke hjelper deg.
(selv om det kan være eksempler sort in-place gir mening)
Hva hvis klientet sletter elementer fra lista???
</aside>



### Referential transparency ###
Et uttrykk er referentially transparent hvis man kan
bytte ut uttrykket med verdien.



```scala
def square(x: Int) = x * x

square(2 + 4)
=> square(6)
=> 6 * 6
=> 36

```
<aside class='notes'>
<ul>
  <li> ligner mistenkelig på matte!</li>
  <li> skjønner hvorfor Scala ikke har return, right?
  <li> ikke mulig å få til hvis koden har side-effekter</li>
  <li> pure functions er referentially transparent </li>
  <li> uttrykk kan også være referentially transparent </li>
  <li> fjerner tidsaspektet - gjør den enklere å resonnere rundt</li>
</ul>
</aside>



```scala
> val x = new StringBuilder("Hello")
// x: java.lang.StringBuilder = Hello
> val y = x.append(", World")
// y: java.lang.StringBuilder = Hello, World
> val r1 = y.toString
// r1: java.lang.String = Hello, World
> val r2 = y.toString
// r2: java.lang.String = Hello, World

> val x = new StringBuilder("Hello")
// x: java.lang.StringBuilder = Hello
> val r1 = x.append(", World").toString
// r1: java.lang.String = Hello, World
> val r2 = x.append(", World").toString
//r2: java.lang.String = Hello, World, World
```



### Shared mutable state ###
> If multiple threads access the same mutable state variable without
> appropriate synchronization, your program is broken
>
> -- Brian Goetz, author of Java Concurrency in Practice
<aside class='notes'>
    shared = på tvers av tråder <br/>
    mutable = at den kan endres <br/>
</aside>



### Two (three) ways to fix it ###
* Don't share the state variable across threads
* Make the state variable immutable
* (Use synchronization whenever accessing the state variable)



### Oppsummering ###
- Collections, variabler, objekter, ALT bør være immutable
- mutable state på et så lite scope som mulig
- foretrekk pure functions
- hvis impure function -  returner Unit
- shared mutable state er fy-fy
<aside class='notes'>
    - hvis impure function - eks. skrive til fil, gjøre betaling
    Unit impliserer at det skjer en side-effekt.
    - skummelt med funksjonelle idiomer i Java (eks. rekursjon, lazy evaluation)
</aside>



### Oppgaver ###
FunctionalTest
