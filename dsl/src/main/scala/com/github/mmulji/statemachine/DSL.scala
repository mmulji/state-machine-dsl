package com.github.mmulji.statemachine

object DSL {

  case class State(name: String)
  case class Message(name: String)

  implicit def addStateMachine = new StateMachine()
  implicit def addTransition = new Transition
  implicit def addStates = new States

  class StateMachine {

   var name: String = ""
   var states: Seq[State] = null
   var transitions: Seq[Transition] = null

   def called (i: String) = {
     name = i
     this
   }

   def has(i : State*) = {
     states = i
     this
   }

   def using(i: Transition*) = {
     transitions = i
     this
   }

   def start = {}
   def stop = {}
  }

  class States {

   var states : Seq[State] = Seq[State]()

   def addStates: States = new States
   def ~> (b: State*) = {
     this.states = b
     this
   }
  }

  class Transition {

   var when : (Any => Boolean) = null
   var msg : Message = Message("")
   var _from: State = State("")
   var _to: State = State("")

   def using(i: Message) = {
     msg = i
     this
   }

   def from(i: State) = {
     _from = i
     this
   }

   def to(i: State) = {
     _to = i
     this
   }

  }

  class Transitions {

   var transitions: Seq[Transition] = Seq[Transition]()

   def has(i: Transition*): Transitions = {
     transitions = i
     this
   }

  }

}
