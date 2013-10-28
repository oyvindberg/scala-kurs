package scalakurs.oop

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite


class ShapeTest extends FunSuite with ShouldMatchers {

  val origo = Point(0,0)

  test("circle with radius 2") {
    val circle = new Circle(origo, 2)
    circle.area should be (12.56 plusOrMinus 0.2)
  }

/** Oppgave 1: Implementer rectangle slik at testen kjører **/

//  test("a rectangle with height of 4 and width of 6") {
//    val rectangle = new Rectangle(origo, height = 4, width = 6)
//    rectangle.name should be ("rectangle")
//    rectangle.area should be (24)
//    rectangle.circumference should be (20)
//  }

/** Oppgave 2: Implementer square (arv fra rectangle) slik at testen kjører  **/

//  // 3: Implement square by extending rectangle, and make the tests pass
//  test("a square with sides of 4") {
//    val square = new Square(origo, length = 4)
//    square.name should be ("square")
//    square.area should be (16)
//    square.circumference should be (16)
//  }

/** Oppgave 3 - "tegn" alle shapes slik at testen kjører **/

//  test("Draw elements to screen") {
//    val circle = new Circle(origo, 5)
//    val square = new Square(origo, length = 4)
//    val rectangle = new Rectangle(origo, height = 4, width = 6)
//    val list = List(circle, square, rectangle)
//    Shapes.draw(list)
//  }

}
