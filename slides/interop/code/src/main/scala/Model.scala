trait Model {
  def value: Any
  def printValue: String = value.toString
}
