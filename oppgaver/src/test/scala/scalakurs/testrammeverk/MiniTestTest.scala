package scalakurs.testrammeverk

/* I denne oppgaven må testene kommenteres inn etterhvert som de skal løses.
*
* For å løse oppgavesettet trengs ihvertfall følgende:
*
* - flere parametersett
* - sende funksjoner rundt på flere måter
* - lage en liten algebra for test-resultater
* - pimping av typer for å legge på syntax
* - closures
*
*
* Oppgave stjålet fra https://github.com/arktekk/scala-kurs-oppgaver
*  (der finnes også et par andre oppgavesett som anbefales :)
* */

class Oppgave1 extends solutions.MiniTest {

  //success
  test("2 + 2 == 4"){
    assertEq(2 + 2, 4)
  }

  //success
  test("2 + 2 != 5"){
    assertNotEq(2 + 2, 5)
  }

  //fail
  test("3 + 2 == 4"){
    assertEq(3 + 2, 4)
  }

}

class Oppgave2 extends Oppgave1 {

  test("håndter exceptions"){
    sys.error("catch me if you can ;-)")
  }

}

class Oppgave3 extends Oppgave2 {

  test("støtter pending tests"){
    pending("because I am lazy")
  }

}

class Oppgave4 extends Oppgave3 {

  test("fancy syntax"){
    3 + 2 === 5
  }

  test("fancy syntax fail"){
    3 + 2 === 4
  }

  test("fancy not syntax"){
    3 + 2 !== 4
  }

  test("fancy not syntax fail"){
    3 + 2 !== 5
  }

}

class Oppgave5 extends Oppgave4 {

  var i = 0

  before {
    i = i + 5
  }

  after {
    i = i + 10
  }

  test("i == 5"){
    // i -> before
    // 0 + 5
    assertEq(i, 5)
  }

  test("i == 20"){
    // i -> before -> after -> before
    // 0 + 5 + 10 + 5 == 20
    assertEq(i, 20)
  }

}

object RunTests extends Oppgave5 with App
