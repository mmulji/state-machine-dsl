package com.github.mmulji.statemachine

import com.github.mmulji.statemachine.DSL._
import com.github.mmulji.statemachine.executors.Executor
import org.scalatest.{Matchers, WordSpecLike}


class RepinStateMachine
  extends DSL.StateMachine
  with Executor
  with Matchers
  with WordSpecLike {

  "Sample DSL code" must {
    "compile" in {

      val stateMachine =
          (createStateMachine called "Bob"
            has ( State("one"), State("two"), State("three"))
            starting State("one")
            using (
              addTransition
                when Message("")
                moveFrom State("") to State("Two")
                when((x: Any) => { x.asInstanceOf[String].contains("true") }),
              addTransition
                when Message("")
                moveFrom State("") to State("Two")
                when((x: Any) => { x.asInstanceOf[String].contains("true") })
              ))
      }
    }

}

// when <event> check <condition> move from <state> to <state>
