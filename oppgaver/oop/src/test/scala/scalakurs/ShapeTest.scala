package scalakurs

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite


class ShapeTest extends FunSuite with ShouldMatchers {

  val origo = Point(0,0)

  // 1: Make this compile and run green
  test("circle with radius 2") {
    val circle = new Circle(origo, 2)
    circle.draw should not be ""
    circle.area should be >= 12.56
    circle.area should be <= 12.6
  }

  // 2: Implement rectangle and make the tests pass
  test("a rectangle with height of 4 and width of 6") {
    val rectangle = new Rectangle(origo, height = 4, width = 6)
    rectangle.area should be (24)
    rectangle.circumference should be (20)
    rectangle.draw should not be ""
  }

  // 3: Implement square by extending rectangle, and make the tests pass
  test("a square with sides of 4") {
    val square = new Square(origo, length = 4)
    square.area should be (16)
    square.circumference should be (16)
    square.draw should not be ""
  }

}
