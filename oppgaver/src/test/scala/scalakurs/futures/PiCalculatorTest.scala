package scalakurs.futures

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import scala.concurrent.duration._

class PiCalculatorTest extends ShouldMatchers with FlatSpec {

  import PiCalculator._
//  import solutions.PiCalculator._

  it should "use an algorithm giving a sufficient approximation" in {
    val pi = calculatePiFor(start = 0, nrOfElements = 10000)
    pi should be > 3.14
    pi should be < 3.15
  }

  it should "be really fast, splitting up the problem, executing in parallel" in {
    isImplemented {
      onTime(100 milliseconds) {
        calculate(nrOfElements = 100000000, nrOfWorkers = 1000000)
      }
    }
  }

  def onTime[F](maxTime: Duration)(block: => F) = {
    val start = System.currentTimeMillis()
    block
    val time = System.currentTimeMillis() - start
    time should be <= maxTime.toMillis
  }

  def isImplemented[R](block: => R): R = {
    try block catch {
      case e : scala.NotImplementedError => fail("not implemented")
    }
  }

}
