import com.github.mmulji.statemachine.DSL._
import org.scalatest.{Matchers, WordSpecLike}


class CreateStateMachine
  extends Matchers
  with WordSpecLike {

  "Sample DSL code" must {
    "compile" in {

      val stateMachine =
          (addStateMachine called "Bob"
            has ( State("one"), State("two"), State("three"))
            using (
              addTransition from State("") to State("Two")
              using Message(""),
            addTransition from State("") to State("Two")
              using Message("")
            ))
      }
    }

}



// when <event> check <condition> move from <state> to <state>
