package scalakurs.either.solutions

import java.io.File
import scala.io.Source


object FileCensor {

  val errorMessage = "Wait for Java 8, you filthy hound! It's backward compatible!!!"
  val censoredReplacement = "*** CENSORED ***"

  // projection should contain errorMessage if file name contains the wrong words
  // scala.io.Source.fromFile(file)
  def fetchUncensoredContent(file: File): Either[String, Seq[String]] =
    if (file.getPath.contains("scala"))
      Left(errorMessage)
    else
      Right(Source.fromFile(file).getLines().toSeq)

  // add the text expected from the tests to each of the projections
  // Hint: either.fold
  def formatResponse(response: Either[String, Seq[String]]): String =
    response.fold(
      err => s"Error:\n$err",
      res => s"Response:\n${res.mkString("\n")}"
    )

  // reuse where practical. remember the collection functions from earlier.
  // Hint: filter and map in one operation...
  def fetchCensoredContent(file: File): Either[String, Seq[String]] =
    fetchUncensoredContent(file).right.map(_.collect {
      case str if str.toLowerCase.contains("scala") => censoredReplacement
    })
}
