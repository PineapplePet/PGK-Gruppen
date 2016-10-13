package turtlerace
import scala.util.Random


                                      //behöver ej ha med parametrar för trait då de aldrig efterfrågas vid inmixning.
trait Dizzy extends RaceTurtle {    // Parametrar efterfrågas bara vid inmixning.
  val stepR = new Random() //får inte ha val utanför objektet.
  override def raceStep() = {
    if(math.random < 0.5){
      turnLeft(5)
    }else{
      turnRight(5)
    }
    forward(stepR.nextInt(5) + 1)
  }
  override def toString: String = super.toString + " Dizzy"
}

trait Koks extends RaceTurtle {
  val stepR = new Random()
  override def raceStep() = {
    for(i <- 1 to 10){
      forward(stepR.nextInt(5) + 1)
    }
    for(i <- 1 to 3){ //Waiting for the peak
      forward(0)
    }
    if(math.random > 0.5){
      turnNorth()
      turnRight(stepR.nextInt(180) + 1)
      forward(50) //drugHybrisRage
    }
  }
  override def toString: String = super.toString + " Koksaren"
}

trait KeD extends RaceTurtle { //Går dubbelt så långt eller inget
  val stepR = new Random()
  override def raceStep() = {
    if(stepR.nextInt(2) < 1){
      forward((stepR.nextInt(5) + 1) * 2)
    }else{
      forward(0)
    }
  }

  override def toString: String = super.toString + " Kvitt eller Dubbelt"
}

trait nameOfTrait extends RaceTurtle { //Mall för trait

  override def raceStep() = ??? //Define your traits characteristics

  override def toString: String = super.toString + " nameOfTrait"
}
