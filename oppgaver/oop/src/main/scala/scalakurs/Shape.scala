package scalakurs

import scala.math.Pi

abstract class Shape(val center: Point) {
  def name: String

  def area: Double

  def circumference: Double

  def draw: Unit
}

trait Drawing extends Shape {
  def draw = s"Drawing $name with area $area and circumference $circumference with center at $center"
}

class Circle(center:Point, radius: Double) extends Shape(center) with Drawing {

  def name: String = "circle"

  def area: Double = Pi * radius * radius

  def circumference: Double = Pi
}

class Square(center: Point, length: Double) extends Rectangle(center, length, length) with Drawing {

  override def name: String = "square"
}


class Rectangle(center: Point, height: Double, width: Double) extends Shape(center: Point) with Drawing {

  def name: String = "ractangle"

  def area: Double = height * width

  def circumference: Double = (height * 2) + (width * 2)
}

case class Point(x: Int, y:Int)

