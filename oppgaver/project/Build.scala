import sbt._
import sbt.Keys._

object ScalaExercisesBuild extends Build {

  lazy val root = Project(
    id = "scala-exercises",
    base = file(".")
  ).aggregate(
    typeclasses,
    patternmatching,
    collections,
    typevariance,
    oop
  )

  lazy val typeclasses     = module("typeclasses")()
  lazy val patternmatching = module("patternmatching")()
  lazy val collections     = module("collections")()
  lazy val typevariance    = module("typevariance")()
  lazy val oop             = module("oop")()

  private def module(moduleName: String)(
    projectId: String = moduleName,
    dirName: String   = moduleName
  ) = Project(projectId, file(dirName), settings = commonSettings)

  lazy val commonSettings = Defaults.defaultSettings ++ Seq(
    scalaVersion        := "2.10.2",
    scalaBinaryVersion  := "2.10",
    libraryDependencies := commonDependencies
  )

  lazy val commonDependencies = Seq(
    "org.scalatest" %% "scalatest" % "1.9.1"
  )
}
