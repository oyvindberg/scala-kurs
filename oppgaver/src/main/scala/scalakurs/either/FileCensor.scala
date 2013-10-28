package scalakurs.either

import java.io.File


object FileCensor {

  val errorMessage = "Wait for Java 8, you filthy hound! It's backward compatible!!!"

  // projection should contain errorMessage if file name contains the wrong words
  // Hint: scala.io.Source.fromFile(file)
  def fetchUncensoredContent(file: File): Either[String, Seq[String]] = ???

  // add the text expected from the tests to each of the projections
  // Hint: either.fold
  def formatResponse(response: Either[String, Seq[String]]): String = ???

  // Syntax for ignoring case in regex is "(?i)expr"
  def censorLine(line: String): String = ???

  // reuse where practical. remember the collection functions from earlier.
  def fetchCensoredContent(file: File): Either[String, Seq[String]] = ???
}
