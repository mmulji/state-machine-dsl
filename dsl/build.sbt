name := "State Machine DSL"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.11.7"

libraryDependencies ++= Seq(

  "net.fwbrasil" %% "bond" % "0.0.1",
  "org.scalatest" %% "scalatest" % "2.2.5" % "test" withSources() withJavadoc()
)
