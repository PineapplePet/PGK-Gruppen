package turtlerace

trait Dizziness extends RaceTurtle {  //behöver ej ha med parametrar för trait då de aldrig efterfrågas vid inmixning.
                                      // Parametrar efterfrågas bara vid inmixning.
  override def raceStep() = {

  }

  override def toString: String = super.toString + " Dizzy"
}

trait x extends RaceTurtle {
override def raceStep() = ???

  override def toString: String = super.toString + " Dizzy"
}

trait y extends RaceTurtle {
  override def raceStep() = ???

  override def toString: String = super.toString + " Dizzy"
}