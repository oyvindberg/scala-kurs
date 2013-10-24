import java.net.URL
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import scala.io.{BufferedSource, Source}
import scalakurs.ContentFetcher

class ContentFetcherTest extends FlatSpec with ShouldMatchers {

  import ContentFetcher._

  it should "get a source from a correct, specified url as a Right-projection" in {
    getContent(new URL("http://www.finn.no")).isRight should be (true)
  }

  it should "get a source from an incorrect or disallowed url as a Left-projection" in {
    getContent(new URL("http://www.scala-lang.org/")).isLeft should be (true)
  }

  it should "format Right-projection content with 'Response:\\n' prepended" in {
    formatResponse(Right[String, Source](new Source {
      protected val iter: Iterator[Char] = "foo\nbar".toIterator
    })) should equal ("Response:\nfoo\nbar")
  }

}
