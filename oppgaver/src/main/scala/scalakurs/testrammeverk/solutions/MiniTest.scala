package scalakurs.testrammeverk
package solutions

import scala.collection.mutable

trait MiniTest {

  sealed trait Result
  case class  Pending(msg: String)              extends Result
  case class  Failed[A](expected: A, actual: A) extends Result
  case object Success                           extends Result

  private val befores = mutable.ArrayBuffer.empty[() => Unit]
  private val afters  = mutable.ArrayBuffer.empty[() => Unit]

  def before(e: => Unit) = befores += (() => e)
  def after(e: => Unit)  =  afters += (() => e)

  def test(msg: String)(r: => Result) = {
    try {
      befores.foreach(before => before())

      r match {
        case Success          => println(s"Success  ($msg)")
        case Pending(m)       => println(s"Pending  ($msg) because $m")
        case Failed(exp, act) => println(s"Failure! ($msg): expected " + exp + " but got " + act)
      }

      afters.foreach(after => after())
    }
    catch {
      case e: Throwable       => println(s"Failure! ($msg) Exception: " + e.getMessage)
    }
  }

  def assertEq[A](a: => A, expected: A) = {
    val res = a
    if (res == expected) Success else Failed(expected, res)
  }

  def assertNotEq[A](a: => A, expected: A) = {
    val res = a
    if (res != expected) Success else Failed(expected, res)
  }

  def pending(msg: String) = Pending(msg)

  implicit class EqualsOp[A](a1: A) {
    def ===(a2: A) = assertEq(a1, a2)
    def !==(a2: A) = assertNotEq(a1, a2)
  }
}
