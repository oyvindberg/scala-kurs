package scalakurs

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) {
    buf += x
  }
}

trait OddNumberFiltering extends IntQueue {
  abstract override def put(x: Int): Unit = if (x % 2 == 0) super.put(x)
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x * 2)
}

trait NegativeNumberFiltering extends IntQueue {
  abstract override def put(x: Int): Unit = if (x > 0) super.put(x)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x + 1)
}
