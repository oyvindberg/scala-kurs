# Containertyper fra ferskvaredisken #

---

# Option[A] #
(╯°□°)╯︵sɹǝʇuıodllnu

--

## Hva? ##

```
sealed abstract class Option[+A] {...}
case class Some[+A](x: A) extends Option[A]
case class None extends Option[Nothing]
```

- `Option[A]`er en container for typen `A`
- Hvis `A` er tilstede, så er `Option[A]` en instanse av `Some[A]`
- Hvis `A` ikke er tilstede, så er `Option[A]` en instanse av `None`

--

## Hvorfor? ##

```
def hello(str: String) = s"Hello, $str"

scala> Option(null)
res1: Option[Null] = None

scala> res1.map(hello)
res2: Option[String] = None

scala> Option("Foo")
res3: Option[String] = Some(Foo)

scala> res3.map(hello)
res4: Option[String] = Some(Hello, Foo)
```

- Abstraherer over `Option[String]` i stedet for å null-checke og returnere null eller kaste exception
- Tvinger deg til å håndtere `None`-caset når verdien skal realiseres
- Som vanlig i Scala: Compile-time checks i stedet for runtime!
- Ofte kan `None` i seg selv være semantisk verdifull

--

## Hvordan ? ##

```
def getAd(int: adId): Option[Ad]
def getOrg(int: orgId): Option[Organisation]
```

«Imperativ» bruk av nøstet `Option`
```
val adOpt = getAd(1337)
// Ser helt greit ut om man bare skal nøste to Options, 
// men man må bygge kontrollstrukturene selv. URK!
val orgOpt = if (adOpt.isDefined) getOrg(adOpt.get.orgId) else None
```

`map` og `flatMap` til unsetning!
```
// Option[Option[Organisation]], hmmm!
val orgOptOpt = getAd(1337).map(ad => getOrg(ad.orgId)) 
// Option[Organisation]
val orgOpt = orgOptOpt.flatten
```

--

### Just `flatMap` that shit ###

```
getAd(1337).flatMap(ad => getOrg(ad.orgId)) 
```

--

## Og litt sukkerstrø på topp ##

for-comprehensions
```
for {
  ad  <- getAd(1337)
  org <- getOrg(ad.orgId)
} yield org
```

Kommer med alle filtre, folds, maps som man burde forvente
```
val name: Option[String] = request.getParameter("name")
val upper = name.map(_.trim).filter(_.nonEmpty).map(_.toUpperCase)
println(upper.mkString)
```

Og selvfølgelig pattern matching
```
request.getParameter("name") match {
  case Some(param) if param.trim.nonEmpty => println(param.trim.toUpperCase)
  case _ => println("")
}

```

---

# Either[A, B] #
Hva om du faktisk har lyst til å legge litt mer i dette `None`-caset som vi så på i `Option`?

--

## Hva? ##

```
sealed abstract class Either[+A, +B]
case class Left[+A, +B](a: A) extends Either[A, B]
case class Right[+A, +B](b: B) extends Either[A, B]
```

- `Either[A,B]` er en container for type `A` eller type `B`
- Hvis en `Either[A,B]` inneholder en `A`, så er den en `Left`, og hvis `B` så er det en `Right`
- Det er ingenting i semantikken til denne typen som sier noe om den ene eller andre siden er en suksess eller feil, og man kan bruke denne i alle tilfeller hvor man forventer den ene eller andre typen

--

## Hvordan? ##

`Either.fold(..)` er bra praksis for Eithers, siden man uansett har bare to mulige cases
```
scala> val fooOrBar: Either[String, String] = Right("bar")
scala> fooOrBar.fold(
     |   l => s"This is a LEFTY-$l", 
     |   r => s"This is a RIGHTY-$r")
res0: String = This is a RIGHTY-bar
```

Men man kan også bruke pattern matching

```
scala> val fooOrBar: Either[String, String] = Left("foo")
scala> fooOrBar match {
     |   case Left(l) => s"This is a LEFTY-$l"
     |   case Right(r) => s"This is a RIGHTY-$r"
     | }
res1: String = This is a LEFTY-foo
```

--

## Exception-drevet utvikling suger! ##
Ja, da, men det trenger det egentlig ikke å gjøre. La oss ta vare på denne `Exception`-greia uten å spy ut hele stack tracen
```
scala> def getThatAd(id: Int) = {
     |   if(Random.nextBoolean()) 
     |     s"I'm an ad with id $id!" 
     |   else 
     |     throw new Exception("No ad of that sort in the db?")
     | }
     
scala> try {
     |   Right(getThatAd(1337))
     | } catch {
     |   case ex: Exception => Left(ex)
     | }
```

```
res1: scala.util.Either[Throwable,String] = 
        Right(I'm an ad with id 1337!)
```

```
res2: scala.util.Either[Throwable,String] = 
        Left(java.lang.Exception: No ad of that sort in the db?)
```

--

Det finnes noe deilig sukker for dette også, som man kan bruke om man vil

```
scala> scala.util.control.Exception.allCatch.either(getThatAd(1337))
res0: scala.util.Either[Throwable,String] = Left(...)
```