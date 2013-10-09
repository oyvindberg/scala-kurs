// Traditional way
trait EmailHelpers {
  def isEmail(s: String): Boolean
  def domain(s: String): String
  def user(s: String): String  
}

// Test it
object Testing extends EmailHelpers {
  def isEmail(s: String): Boolean = false
  def domain(s: String): String = ""
  def user(s: String): String = ""

  val s = ""
  if (isEmail(s)) println(user(s)  + "AT" + domain(s))
  else println("not an email address")
}

object Email {
  // Injection method
  def apply(user: String, domain: String) = user + "@" + domain

  // Extraction
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}
