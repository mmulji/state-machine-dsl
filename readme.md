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

