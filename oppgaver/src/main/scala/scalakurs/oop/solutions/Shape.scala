package scalakurs.oop.solutions

abstract class Shape(val center: Point) {
  def name: String

  def area: Double

  def circumference: Double

}

trait Drawing extends Shape {
  def draw(): Unit = println(s"Drawing $name with area $area and circumference $circumference with center at $center")
}


class Circle(center:Point, radius: Double) extends Shape(center) {

  def name: String = "circle"

  def area: Double = math.Pi * radius * radius

  def circumference: Double = 2 * math.Pi * radius
}

class Square(center:Point, length: Double) extends Rectangle(center, length, length) {
  override def name = "square"
}

class Rectangle(center: Point, width: Double, height: Double) extends Shape(center) {
  def name: String = "rectangle"

  def area: Double = height * width

  def circumference: Double = (2 * width) + (2 * height)
}

case class Point(x: Int, y:Int)


object Shapes {

  def draw(shapes: List[Drawing]): Unit = shapes.foreach(_.draw())

}

