package scalakurs

object ContentFetcher {

  import scala.io.Source
  import java.net.URL

  // scala.io.Source.fromURL(url)
  def getContent(url: URL): Either[String, Source] =
    if (url.getHost.contains("scala"))
      Left("Wait for Java 8, you filthy hound! It's backward compatible!!!")
    else
      Right(Source.fromURL(url))

  def formatResponse(response: Either[String, Source]): String =
    response.fold(
      err => s"Error:\n$err",
      res => s"Response:\n${res.getLines().mkString("\n")}"
    )

}
