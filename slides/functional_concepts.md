### Funksjonelle konsepter ###
<aside class='notes'>
  Ikke et kurs om funksjonell programmering, men viktig å kjenne til de
  viktigste konseptene.
  Poenget er: Ha dette i bakhodet, så blir det enklere å skjønne en del
  av finurlighetene til Scala
</aside>



- immutability
- pure function
- referential transparency
- side effect
- shared mutable state



### Immutability ###
Et objekt kan ikke bli modifisert etter at det er laget



### Immutability - implikasjoner ###
- kan ikke legge til nye elementer i en datastruktur
- bruker ikke var, kun val
- 'settere' er ikke lov, det modifiserer et objekt
- Ikke looper, for da må man jo ha en teller som man muterer



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



### Hvorfor immutable?###
- trådsikkert
- trygt å dele med klienter
- lett å teste
- lett å resonnere rundt
<aside class='notes'>
 - trådsikkert: Alle tråder har samme bilde av hva variabelen er, den endrer seg ikke
 - Dele med klienter - f.eks. at en klasse kan eksponere en liste uten å være redd for at den blir endret
 - Lett å resonnere rundt fordi at metoder og funksjoner er referentially transparent
</aside>



### Pure functions ###
En funksjon som alltid returnerer den samme verdien basert på den samme input
Dvs resultatet avhenger kun av input



### Referential transparency ###
- et uttrykk er referentially transparent hvis man kan
bytte ut uttrykket med verdien.

```scala
val x = 2
val y = x * x => val y = 4
```



```scala
var global = 0

def f(x: Int) = x + global

def inc() = global + 1
```



```scala
def add(x: Int, y: Int) = x + y

def inc(x: Int) = x + 1

```



### Shared mutable state ###
> If multiple threads access the same mutable state variable without
> appropriate synchronization, your program is broken
> -- Brian Goetz, author of Java Concurrency in Practice
<aside class='notes'>
    shared = på tvers av tråder
    mutable = at den kan endres
</aside>



### Three (two) ways to fix it ###
* Don't share the state variable accross threads
* Make the state variable immutable
* Use synchronization whenever accessing the state variable



### Oppsummering ###
- Collections, variabler, objekter osv bør være immutable
- mutable state på et så lite scope som mulig
- foretrekk pure functions
- shared mutable state er fy-fy



### Oppgaver ###
