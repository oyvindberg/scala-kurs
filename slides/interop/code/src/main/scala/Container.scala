trait Container[M[_]] {

  def put[A](x: A, m: M[A]): M[A]

  def first[A](m: M[A]): Option[A]
}

trait  ListContainer extends Container[List] {
  def put[A](x: A, m: List[A]): List[A] =  x :: m

  def first[A](m: List[A]): Option[A] = m.headOption
}

object StringListContainer extends ListContainer {
  val stringList: List[String] = List("ja")
  val intList: List[Int] = List(1)

  val list2: List[String] = put("da", stringList)

  //val one: Option[Int] = first(intList)
}