package scalakurs.futures
package solutions

import scala.concurrent.{Await, Future, future}
import scala.concurrent.duration._

object PiCalculator extends App {

  import scala.concurrent.ExecutionContext.Implicits.global

  // π = 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - ... + 1/n)
  def calculatePiFor(start: Int, nrOfElements: Int) = {
    (start until (start + nrOfElements)).foldLeft(0.0) (
      (acc, i) => acc + 4.0 * Math.pow(-1, i) / (2 * i + 1)
    )
  }

  def calculate(nrOfElements: Int, nrOfWorkers: Int) = {
    val workSize = nrOfElements / nrOfWorkers
    val delegatedWork = (0 to workSize).map { start =>
      future {
        calculatePiFor(start * workSize, workSize)
      }
    }

    val asyncApprox = Future.reduce(delegatedWork)(_ + _)
    Await.result(asyncApprox, 10 seconds)
  }
}

