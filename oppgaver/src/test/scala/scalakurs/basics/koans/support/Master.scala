package scalakurs.basics.koans.support

import org.scalatest.Stopper

object Master extends Stopper {
  var studentNeedsToMeditate = false

  override def apply() = studentNeedsToMeditate

  type HasTestNameAndSuiteName = {
    val suiteName: String
    val testName: String
  }


  def studentFailed (event: HasTestNameAndSuiteName): String = {
    studentNeedsToMeditate = true
    meditationMessage(event)
  }

  private def meditationMessage(event: HasTestNameAndSuiteName) = {
    "Please meditate on koan \"%s\" of suite \"%s\"" format (event.testName, event.suiteName)
  }

}
