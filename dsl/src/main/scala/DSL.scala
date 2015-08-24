/**
*
* DSL:
* http://debasishg.blogspot.nl/2008/05/designing-internal-dsls-in-scala.html
*
* Graph:
* http://www.scala-graph.org/guides/test.html
*
* Scala:
* http://stackoverflow.com/questions/23890507/creating-infix-operators-in-scala
* http://stackoverflow.com/questions/12335388/line-continuation-character-in-scala
*
* Intellij Plugin:
* http://bjorn.tipling.com/how-to-make-an-intellij-idea-plugin-in-30-minutes
* */






object DSL {

  case class State(name: String)
  case class Message(name: String)

  implicit def addStateMachine = new StateMachine()
  implicit def addTransition = new Transition
  implicit def addStates = new States

  class StateMachine {

   var name: String = ""
   var states: Seq[State] = null
   var services: Seq[Service] = null
   var transitions: Seq[Transition] = null

   def called (i: String) = {
     name = i
     this
   }

   def has(i : State*) = {
     states = i
     this
   }

   def runs(i: Service*) = {
     services = i
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

  class Service {

   var name: String = ""
   var executor: (Any) => Unit = null
   var characteristics: Seq[(String, String)] = Seq[(String, String)]()

   def called (i: String) = {
     name = i
     this
   }

   def properties (i: (String, String)*) = {
     characteristics = i
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



// when <event> check <condition> move from <state> to <state>
