name := "State Machine DSL"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.11.7"


lazy val root = (project in file(".")).aggregate(smDSL, smPluginIntellij, smPluginNetbeans)
lazy val smDSL = project.in(file("dsl"))
lazy val smPluginNetbeans = project.in(file("plugin-netbeans")).dependsOn(smDSL)
lazy val smPluginIntellij = project.in(file("plugin-intellij")).dependsOn(smDSL)