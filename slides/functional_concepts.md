### Funksjonelle konsepter ###
- immutability
- referential transparency
- pure function



### Immutability ###
Et objekt kan ikke bli modifisert etter at det er laget



### Immutability - implikasjoner ###
- kan ikke legge til nye elementer i lista
- bruker ikke var, kun val
- 'settere' er ikke lov, det modifiserer et objekt
- Ikke looper, for da må man jo ha en teller som man muterer
<aside class='notes'>
 Poenget er: Ha dette i bakhodet, så blir det enklere å skjønne hvorfor
 Scala har gjort ting så annerledes/vanskelig.
</aside>



### Hvorfor immutable?###
- trådsikkert
- trygt å dele med klienter
- lett å teste
- lett å resonnere rundt
<aside class='notes'>
 Lett å resonnere rundt fordi at metoder og funksjoner er
 referentially transparent
</aside>



### Referential transparency ###
- et uttrykk er referentially transparent hvis man kan
bytte ut uttrykket med verdien

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



### Pure function ###
- ingen side effects
- alltid samme resultat for samme input

