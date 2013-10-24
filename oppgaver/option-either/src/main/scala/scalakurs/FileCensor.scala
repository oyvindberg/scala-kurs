package scalakurs

import java.io.File


object FileCensor {

  val errorMessage = "Wait for Java 8, you filthy hound! It's backward compatible!!!"
  val censoredReplacement = "*** CENSORED ***"

  // projection should contain errorMessage if file name contains the wrong words
  // Hint: scala.io.Source.fromFile(file)
  def fetchUncensoredContent(file: File): Either[String, Seq[String]] = ???

  // add the text expected from the tests to each of the projections
  // Hint: either.fold
  def formatResponse(response: Either[String, Seq[String]]): String = ???

  // reuse where practical. remember the collection functions from earlier.
  // Hint: filter and map in one operation...
  def fetchCensoredContent(file: File): Either[String, Seq[String]] = ???
}
