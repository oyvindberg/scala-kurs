package scalakurs.myfutures.solution

import scalakurs.myfutures.work._
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global

object MyFutures {

  def computeSquare(n: Int) = future(n * n)

  def computeSquare(f: Future[Int]) = f.map(n => n * n)

  def findMaxFactor(work: FactorNumber) = future(work.perform().max)

  def findMaxFactor(work: Future[FactorNumber]) = work.map(w => w.perform().max)

  def computeRiskySumFallbackOnSafeSum(riskyWork: SumSequence, safeWork: SumSequence) = {
    val riskyRes = future(riskyWork.perform())
    val safeRes  = future(safeWork.perform())

    riskyRes recoverWith {
      case e: IllegalArgumentException => safeRes
    }
  }

  def findSumOfAllMaxFactors(work: Seq[FactorNumber]) = future(work.map(w => w.perform().max).sum)

  def findMaxFactorOfAllMaxFactorsInParallel(work: Seq[FactorNumber]) = {
    val futureFactors: Seq[Future[Long]] = work.map(w => future(w.perform().max))
    val result       : Future[Seq[Long]] = Future.sequence(futureFactors)
    result.map(s => s.max)
  }
}