package com.github.mmulji.statemachine.executors

import com.github.mmulji.statemachine.DSL
import com.github.mmulji.statemachine.DSL.{Message, StateMachine}


trait Executor {

  this : StateMachine =>

  object MachineState extends Enumeration {
    type MachineState = Value
    val Unvalidated, Validated, Idle, Running, Stopped, Failed = Value
  }

  var _machineState = MachineState.Unvalidated
  var _state : DSL.State = _startingState

  // Check all States are arrived at
  def validate = {
    require(_name.size > 0)
    require(_machineState == MachineState.Unvalidated)
    require(_states.size > 1)
    require(_states.contains(_startingState))
    require(_transitions.size > 0)
    // require(_transitions.forall(_ => _.))
  }


  def start = {
    require(_machineState == MachineState.Validated)
  }

  def stop = {

  }

  def sendMessage(msg : Message) = {

    import scala.util.control.Breaks._

    require(_machineState == MachineState.Running)

    breakable {
      for (tr <- _transitions) {
        if ((tr._msg == msg) && (tr._check(msg))) {
          _currentState = tr._to
          break()
        }
      }
    }
  }


}
