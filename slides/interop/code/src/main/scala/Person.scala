import scala.beans.BeanProperty

class Person(val name: String, var age: Int)

class Person2(@BeanProperty val name: String, @BeanProperty var age: Int)
