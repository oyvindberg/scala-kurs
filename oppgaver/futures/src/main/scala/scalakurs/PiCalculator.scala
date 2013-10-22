package scalakurs


object PiCalculator extends App {

  // π = 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - ... + 1/n)
  def calculatePiFor(start: Int, nrOfElements: Int) = {
    (start until (start + nrOfElements)).foldLeft(0.0) (
      (acc, i) => acc + 4.0 * Math.pow(-1, i) / (2 * i + 1)
    )
  }

  def calculate(nrOfElements: Int, nrOfWorkers: Int) = ???

}
