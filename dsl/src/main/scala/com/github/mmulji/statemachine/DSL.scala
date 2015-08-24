package com.github.mmulji.statemachine

object DSL {

  case class State(name: String)
  case class Message(name: String)

  implicit def addStateMachine = {
    val sm = new StateMachine()
    sm
  }

  implicit def addTransition = new Transition
  implicit def addStates = new States

  class StateMachine {

   var _name: String = ""
   var _states: Seq[State] = null
   var _transitions: Seq[Transition] = null

   def called (i: String) = {
     _name = i
     this
   }

   def has(i : State*) = {
     _states = i
     this
   }

   def using(i: Transition*) = {
     _transitions = i
     this
   }

   def start = {}
   def stop = {}
  }

  class States {

   var _states : Seq[State] = Seq[State]()

   def addStates: States = new States
   def ~> (b: State*) = {
     this._states = b
     this
   }
  }

  class Transition {

    type whenFn = Any => Boolean

    var _when : (Any => Boolean) = null
    var _msg : Message = Message("")
    var _from: State = State("")
    var _to: State = State("")

    def using(i: Message) = {
     _msg = i
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

    def when(x: whenFn): Transition = {
      _when = x
      this
    }

  }

  class Transitions {

   var _transitions: Seq[Transition] = Seq[Transition]()

   def has(i: Transition*): Transitions = {
     _transitions = i
     this
   }

  }

}
