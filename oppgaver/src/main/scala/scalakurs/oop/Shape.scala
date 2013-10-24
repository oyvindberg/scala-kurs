package scalakurs.oop

abstract class Shape(val center: Point) {
  def name: String

  def area: Double

  def circumference: Double

}

trait Drawing extends Shape {
  def draw = s"Drawing $name with area $area and circumference $circumference with center at $center"
}

class Circle(center:Point, radius: Double) extends Shape(center) {

  def name: String = "circle"

  def area: Double = math.Pi * radius * radius

  def circumference: Double = math.Pi
}

// TODO:
// class Square ...

// class Rectangle

case class Point(x: Int, y:Int)

