package scalakurs

import java.io.File
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class FileCensorTest extends FlatSpec with ShouldMatchers {

//  import solution.FileCensor._
  import FileCensor._

  lazy val erroneousFile = new File("src/test/resources/scala-propaganda.txt")
  lazy val anonymousFile = new File("src/test/resources/unnamed-propaganda.txt")
  
  it should "get a source from a correct, specified file as a Right-projection" in {
    fetchUncensoredContent(anonymousFile) should be ('right)
  }

  it should "get a source from an incorrect or disallowed file as a Left-projection" in {
    fetchUncensoredContent(erroneousFile) should be ('left)
  }

  it should "format Right-projection content with 'Response:\\n' prepended" in {
    formatResponse(fetchUncensoredContent(anonymousFile)) should startWith ("Response:")
  }

  it should "format Left-projection content with 'Error:\\n' prepended" in {
    formatResponse(fetchUncensoredContent(erroneousFile)) should equal (s"Error:\n$errorMessage")
  }

  it should "format the Either, but censor any errors or responses containing the word 'scala'" in {
    formatResponse(fetchCensoredContent(anonymousFile)) should include (censoredReplacement)
  }
}
