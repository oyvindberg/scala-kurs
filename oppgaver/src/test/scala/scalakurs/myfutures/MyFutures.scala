package scalakurs.myfutures

import work._
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * futures exercises stolen and adapted from github.com/arild/scala-workshop ,
 *  accompanying slides at http://arild.github.io/scala-workshop
 */
object MyFutures {

  /* futures lages ved å wrappe ting i future() */
  def computeSquare(n: Int): Future[Int] = {
    ???
  }

  /* dette er snakk om å komponere to futures. En typisk måte å gjøre det på er via map */
  def computeSquare(f: Future[Int]): Future[Int] = {
    ???
  }

  /* ligner på computeSquare(), men må gjøre en liste-operasjon */
  def findMaxFactor(work: FactorNumber): Future[Long] = {
    ???
  }

  def findMaxFactor(work: Future[FactorNumber]): Future[Long] = {
    ???
  }

  /* Future.recoverWith eller Future.fallbackTo */
  def computeRiskySumFallbackOnSafeSum(riskyWork: SumSequence, safeWork: SumSequence): Future[Int] = {
    ???
  }

  /* Trenger ikke regne ut max faktor for alle elementene i lista i parallell. Det er neste oppgave */
  def findSumOfAllMaxFactors(work: Seq[FactorNumber]): Future[Long] = {
    ???
  }

  /* Seq[Future[Long]] kan gjøres om til Future[Seq[Long]] ved å bruke Future.sequence(fs: List[Future]]) */
  def findMaxFactorOfAllMaxFactorsInParallel(work: Seq[FactorNumber]): Future[Long] = {
    ???
  }
}

/**
 * This is not important for making the the tests pass, but might be beneficial for understanding
 * this object can be ran directly from intellij because it extends App .
 */
object ExampleUsage extends App {

  def futureHelloWorld() = {
    println("Test print before future")
    val hello = "hello"
    val f = future {
      Thread.sleep(10)
      hello + " future!"
    }
    println("Test print after future")
    f onSuccess { case s => println(s) } //Completely asynchronous
    Await.ready(f, Duration.Inf) //Blocks until the future is ready
  }

  def simpleTransformation() = {
    val f1 = future {
      Thread.sleep(1000)
      println("Original future done")
      1 + 1
    }

    val f2 = f1.map(x => { // Completely asynchronously
      Thread.sleep(1000)
      println("Transformation future done")
      x + 1
    })

    f2 onSuccess { case v => println("Result: " + v) }
    Await.ready(f2, Duration.Inf)
  }

  futureHelloWorld()
  // simpleTransformation
}
