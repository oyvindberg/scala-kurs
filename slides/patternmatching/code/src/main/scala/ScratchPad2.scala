import _root_.ScratchPad2.Person

object ScratchPad2 {

  case class Person(name: String, age: Int)

  object Person {
    //def apply(name: String, age: Int): Person = new Person(name, age)

    //def unapply(p: Person): Option[(String, Int)] = Some((p.name, p.age))

    def unapply(s: String): Option[(String, Int)] = s.split(" ") match {
      case Array(name, age) if isInt(age) => Some((name, age.toInt))
      case _ => None
    }
  }


  val person = Person("Ola", 55)


  person match {
    case Person(name, age) => println(name + ", " + age)
  }

  val str: String = ""
  str match {
    case Person(name, age) => println(name + ", " + age)
  }

  object Email {
    def unapply(str: String): Option[(String, String)] = {
      str.split("@") match {
        case Array(user, domain) => Some((user, domain))
        case _ => None
      }
    }
  }


}
