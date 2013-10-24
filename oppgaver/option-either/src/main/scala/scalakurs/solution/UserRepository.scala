package scalakurs.solution

sealed trait Gender
case object Female extends Gender
case object Male extends Gender

case class User(id: Int,
                firstName: String,
                lastName: String,
                age: Int,
                gender: Option[Gender],
                spouseId: Option[Int]) {

  val printable = ((gender, spouseId) match {
    case (Some(Male), _)         => "Mr. "
    case (Some(Female), Some(_)) => "Mrs. "
    case (Some(Female), None)    => "Ms. "
    case _                       => ""
  }) + s"$firstName $lastName"
}

object UserRepository {

  private val users = Map(
    1 -> User(1, "John",    "Doe", 32, Some(Male),   Some(2)),
    2 -> User(2, "Jane",    "Doe", 30, Some(Female), Some(1)),
    3 -> User(3, "Doni",    "Doe", 15, None,         None)
  )

  def findById(id: Int): Option[User] = users.get(id)

  def findAll = users.values

  def findAllWithSpouse = findAll.filter(_.spouseId.isDefined)

  def findPairById(id: Int): Option[(User, User)] = for {
    user     <- findById(id)
    spouseId <- user.spouseId
    spouse   <- findById(spouseId)
  } yield (user, spouse)

}
