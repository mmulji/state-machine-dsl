package com.github.mmulji.statemachine

object DSLx {

  case class Message(name: String)
  case class State(name: String)

  def statemachine(name: String, startingState: State)(op : => Unit) : Unit = {}
  def states(op : => Unit) : Unit = {}
  def transitions(op : => Unit) : Unit = {}
  def transitionsx(op : => Unit) : Unit = {}
  def when(message: Message, from: State, to: State)(op : => Boolean) : Unit = {}


  // Example State Machine:
  statemachine(name = "Bob", startingState = State("1")) {

    states {
      State("1")
      State("2")
      State("3")
    }

    transitions {

      when(message = Message(""), from = State(""), to = State("")) {
        false
      }

      when(message = Message(""), from = State(""), to = State("")){
        true
      }
    }

  }


}
