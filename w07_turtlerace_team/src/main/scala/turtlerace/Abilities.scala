package turtlerace

                                      //behöver ej ha med parametrar för trait då de aldrig efterfrågas vid inmixning.
trait Snurrig extends RaceTurtle {  // Parametrar efterfrågas bara vid inmixning.
  override def raceStep() = {

  }

  override def toString: String = super.toString + " Snurrig"
}

trait Koksare extends RaceTurtle {
override def raceStep() = ???

  override def toString: String = super.toString + " Koksare"
}

trait KeD extends RaceTurtle {
  override def raceStep() = ???

  override def toString: String = super.toString + " Kvitt eller Dubbelt"
}