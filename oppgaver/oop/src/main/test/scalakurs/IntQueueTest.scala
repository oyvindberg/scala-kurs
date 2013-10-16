package scalakurs

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite

class IntQueueTest extends ShouldMatchers with FunSuite {

  // OddNumberFiltering, Doubling, Incrementing, NegativeNumberFiltering

  test("stackable traits") {
    val queue: IntQueue = ??? // hint: new BasicIntQueue with ??? with ???
    queue.put(-10)
    queue.put(11)
    queue.put(20)

    queue.get() should be(-19)
  }

  test("stackable traits 2") {
    val queue: IntQueue = ??? // hint: new BasicIntQueue with ??? with ??? with ???
    queue.put(-10)
    queue.put(11)
    queue.put(20)

    queue.get() should be(24)
  }

  test("stackable traits 3") {
    val queue: IntQueue = ??? // hint: new BasicIntQueue with ??? with ???
    queue.put(-10)
    queue.put(11)
    queue.put(20)

    queue.get() should be(-18)
  }

  test("stackable traits 4") {
    val queue: IntQueue = ??? // hint: new BasicIntQueue with ??? with ??? with ???
    queue.put(-10)
    queue.put(11)
    queue.put(20)

    queue.get() should be(40)
  }

  // #1: new BasicIntQueue with Incrementing with Doubling
  // #2: new BasicIntQueue with Doubling with Incrementing with NegativeNumberFiltering
  // #3: new BasicIntQueue with Doubling with Incrementing
  // #4: new BasicIntQueue with Doubling with NegativeNumberFiltering with OddNumberFiltering

}
