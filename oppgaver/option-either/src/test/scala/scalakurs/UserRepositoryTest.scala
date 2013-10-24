package scalakurs

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class UserRepositoryTest extends FlatSpec with ShouldMatchers {

  import UserRepository._

  it should "return a Some[User] if id is found" in {
    findById(1) should be ('defined)
  }

  it should "return a None if id is not found" in {
    findById(-1) should be ('empty)
  }

  it should "return all users" in {
    findAll.size should be (3)
  }

  it should "return all users with a spouse" in {
    findAllWithSpouse.map(_.id) should be (Seq(1, 2))
  }

  it should "return a Some[(User,User)] of User and it's spouse" in {
    findPairById(1) should be ('defined)
    findPairById(1).map { case (u, s) => (u.id, s.id) }.get should be (1 -> 2)
  }

  it should "return a None if user or spouse not found" in {
    findPairById(-1) should be ('empty)
    findPairById(3) should be ('empty)
  }

  it should "return a printable name with title based on gender and marital status" in {
    findAll.map(_.printable) should be (Seq("Mr. John Doe", "Mrs. Jane Doe", "Doni Doe"))
  }

}
