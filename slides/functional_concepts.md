### Funksjonelle konsepter ###
<aside class='notes'>
  Ikke et kurs om funksjonell programmering, men viktig å kjenne til de
  viktigste konseptene.
  Poenget er: Ha dette i bakhodet, så blir det enklere å skjønne en del
  av finurlighetene til Scala
</aside>



### Immutability ###
Et objekt kan ikke bli modifisert etter at det er laget



### Immutability - implikasjoner ###
- kan ikke legge til nye elementer i en datastruktur
- bruker ikke var, kun val
- 'settere' er ikke lov
- Ikke tradisjonelle looper



```java
// java
List<Integer> list = new ArrayList<>();
for (int i = 1; i <= 10; i++) {
        list.add(i * 2)
}
```
<aside class='notes'>
    - java lager lista først og legger til et element i lista
    - hver gang du legger til et element, muterer man lista,
    - variabelen i er en sak som man muterer, men innenfor dette scopet er det ok.
    - Off-by-one-feil veldig vanlig.
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
    - eksempel på idiotisk bruk at settere, fra java.util
    - når man klarer å gjøre sånne idiotiske ting som en del av java,
      hvor mye galskap gjør den jevne utvikleren?
    (riktignok deprecated i dag)
</aside>



### Hvorfor immutable?###
- trådsikkert
- trygt å dele med klienter
- lett å teste
- lett å resonnere rundt
<aside class='notes'>
 - trådsikkert: Alle tråder har samme bilde av hva variabelen er, den endrer seg ikke
 - Dele med klienter - f.eks. at en klasse kan eksponere en liste uten å være redd for at den blir endret
 - lett å teste - fjerner tidsaspektet, minimerer antall variabler big time
 - Lett å resonnere rundt fordi at metoder og funksjoner er referentially transparent
   ... kommer tilbake til dette.
</aside>



### Pure functions ###
En funksjon som alltid returnerer den samme verdien basert på den samme input
<aside class='notes'>
    Dvs resultatet avhenger kun av input
</aside>



```scala
// pure functions
def add(x: Int, y: Int) = x + y

def inc(x: Int) = x + 1

```



```scala
var global = 0

// impure functions
def f(x: Int) = x + global

def inc() = global + 1
```



### Referential transparency ###
Et uttrykk er referentially transparent hvis man kan
bytte ut uttrykket med verdien.




```scala
val x = 2
val y = x * x => val y = 4
```
<aside class='notes'>
<ul>
  <li> pure functions er referentially transparent </li>
  <li> uttrykk kan også være referentially transparent </li>
  <li> fjerner tidsaspektet </li>
</ul>
</aside>



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
- Collections, variabler, objekter osv bør være immutable
- mutable state på et så lite scope som mulig
- foretrekk pure functions
- shared mutable state er fy-fy



### Oppgaver ###
