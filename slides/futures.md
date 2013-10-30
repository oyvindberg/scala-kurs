# FUTURES #
Hvordan gjøre ting med noe som enda ikke har skjedd aka. *mindblown*

---

## Hvorfor? ##

Hvorfor trenger man å abstrahere over noe som enda ikke har skjedd?

- Tillatter enklere håndtering av parallellitet, man bare setter i gang noe og sier at det «kommer til å skje»
- Asynkronitet trenger ikke blokkeres

---

## Hvordan? ##

- Man registrerer callbacks på `Futures` ved å eksplisitt registrere på 
```
onComplete, onSuccess, onFailiure
```
- Datatransformasjon gjøres ved å kalle 
```
map, flatMap, reduce
```
- Man kan blocke Futures med `Await.result(future, duration)`, men bruk heller callbacks. (Har gjort det i testene til oppgavene)
- Man oppretter en Future ved å wrappe `def future[T](body: =>T): Future[T]` rundt koden som skal kjøres asynk

--

## Hvordan? contd. ##

Opprette `Future`
```
def heavyWordMagic(str: String): Array[Byte] = 
  MessageDigest.getInstance("MD5").digest(str.getBytes)

val wordFutures: Seq[Future[Array[Byte]]] = 
  Seq("word", "is", "bird", "the", "").map { str => 
    future {
      heavyWordMagic(str)
    }
  }
```

Transformere `Future`
```
val upperCase: Seq[Future[String]] = wordFutures.map(_.map(_.toString))
val futureStr: Future[String] = Future.reduce(upperCase)(_ + " " + _)
```

Realisere `Future`
```
futureStr.onSuccess{ case str => println(str) }
// [B@2c9c9f3b [B@5e99f15e [B@4cb582d7 [B@3055f58b [B@20a11899 
```

--

Nøste `Future`
```
def weatherStatus(lat: Double, lon: Double): Future[WeatherStatus] = {
  for {
    location <- geoService.getLocation(lat, lon)
    weather  <- weatherService.getWeather(location.id)
  } yield weather.status
}
```

--

## Oppgaver ##
Gjør disse for introduksjon til Futures
`scalakurs.myfutures.MyFuturesTest`

Gjør disse som en bonus for å gjøre litt arbeid i parallell
`scalakurs.futures.PiCalculatorTest`

