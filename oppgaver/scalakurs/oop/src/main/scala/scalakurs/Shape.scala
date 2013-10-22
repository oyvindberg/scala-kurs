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

class Circle(center:Point, radius: Double) extends Shape(center) {

  def name: String = "circle"

  def area: Double = Pi * radius * radius

  def circumference: Double = Pi

}

// TODO:
// class Square ...

// class Rectangle

case class Point(x: Int, y:Int)

