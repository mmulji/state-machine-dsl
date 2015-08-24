## State Machine DSL

Simple DSL to describe a State Machine in Scala.

The idea is be able to:

- allow a lay person to define a State Machine
- build different executors such as Akka, to run the state machine
- add plugins for IntelliJ and Netbeans so that developers / BA's can create and test visually their State Machines

This repo consists of 3 projects

- DSL  The actual DSL to define a State Machine
- plugin-intelliJ  Visual editor / executor for the DSL in IntelliJ
- plugin-netbeans  Visual editor / executor for the DSL in Netbeans

References

DSL: 
  http://debasishg.blogspot.nl/2008/05/designing-internal-dsls-in-scala.html

Graph: 
  http://www.scala-graph.org/guides/test.html

Scala:
  http://stackoverflow.com/questions/23890507/creating-infix-operators-in-scala
  http://stackoverflow.com/questions/12335388/line-continuation-character-in-scala

Intellij Plugin:
  http://bjorn.tipling.com/how-to-make-an-intellij-idea-plugin-in-30-minutes


