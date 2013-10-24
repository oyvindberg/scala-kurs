import java.net.URL
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import scalakurs.ContentFetcher

class ContentFetcherTest extends FlatSpec with ShouldMatchers {

  import ContentFetcher._

  it should "get a source from a correct, specified url as a Right-projection" in {
    getContent(new URL("http://www.finn.no")).isRight should be (true)
  }

  it should "get a source from an incorrect or disallowed url as a Left-projection" in {
    getContent(new URL("http://www.scala-lang.org/")).isLeft should be (true)
  }

}
