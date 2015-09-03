package com.github.mmulji.statemachine

import scala.language.postfixOps


object DSL {


  case class State(name: String)
  case class Message(name: String)


  implicit def createStateMachine = {
    val sm = new StateMachine()
    sm
  }

  implicit def addTransition = new Transition
  implicit def addStates = new States

  class StateMachine {

    var _name: String = ""
    var _currentState: State = null
    var _startingState: State = null
    var _states: Set[State] = null
    var _transitions: Seq[Transition] = null

    def called (i: String) = {
     _name = i
     this
    }

    def has(i : State*) = {
      _states ++ i
      this
    }

    def starting(i : State) = {
      _startingState = i
      this
    }

    def using(i: Transition*) = {
     _transitions = i
     this
    }

    def :=:(stateMachine: StateMachine) = {
      this._name = stateMachine._name
      this._states = stateMachine._states
      this._startingState = stateMachine._startingState
      this._transitions = stateMachine._transitions
    }

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

    var _check : (Any => Boolean) = null
    var _msg : Message = Message("")
    var _from: State = State("")
    var _to: State = State("")

    def when(i: Message) = {
     _msg = i
     this
    }

    def moveFrom(i: State) = {
     _from = i
     this
    }

    def to(i: State) = {
     _to = i
     this
    }

    def when(x: whenFn): Transition = {
      _check = x
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
