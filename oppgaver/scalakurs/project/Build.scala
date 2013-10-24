import sbt._
import Keys._

object Build extends sbt.Build {
   override def settings = super.settings ++ Seq(
    scalaVersion := "2.10.2"
   )

   lazy val root = Project("root", file(".")) dependsOn(oop, patternMatching, functional)
   lazy val oop = Project("oop", file("oop")) settings(
     name := "oop",
     libraryDependencies += scalatest
   )

   lazy val patternMatching = Project("patternmatching", file("patternmatching")) settings(
     name := "patternmatching",
     libraryDependencies += scalatest
   )

   lazy val functional = Project("functional", file("functional")) settings(
     name := "functional concepts",
     libraryDependencies += scalatest
   )

   lazy val scalatest = "org.scalatest" %% "scalatest" % "1.9.1"
}
