package turtlerace

import cslib.window.SimpleWindow._

import scala.util.Random


                                      //behöver ej ha med parametrar för trait då de aldrig efterfrågas vid inmixning.
trait Dizzy extends RaceTurtle {    // Parametrar efterfrågas bara vid inmixning.
  val stepR = new Random() //får inte ha val utanför objektet.
  override def raceStep() = {
    if (position.y > 450){
      position = Point(position.x, this.window.f2.getHeight) //Gjort window
    } else if (position.y < 0){
      position = Point(position.x, 0)
    }

    if(math.random < 0.5){
      turnLeft(5)
    }else{
      turnRight(5)
    }
    forward(stepR.nextInt(5) + 1)

  }
  override def toString: String = super.toString + " Dizzy"
}

trait StockMarket extends RaceTurtle {
  val stepR = new Random()
  override def raceStep() = {

    if(math.random > 0.5){
      turnNorth()
      turnRight(stepR.nextInt(180) + 1)
      forward(4)
    }
  }
  override def toString: String = super.toString + " StockMarket"
}


trait Portalberoende extends RaceTurtle {
  val stepR = new Random()
  val i = 0
  override def raceStep() = {
    if(i % 2 == 0){

    }
      penUp()
      forward(stepR.nextInt(3) + 1)
      penDown()
    delay(10)
    forward(1)
  }
  override def toString: String = super.toString + "Portalberoende"
}

trait KeD extends RaceTurtle { //Går dubbelt så långt eller inget
  val stepR = new Random()
  override def raceStep() = {
    if(math.random < 0.5){
      forward((stepR.nextInt(2) + 1) * 3)
    }else{
      forward(0)
    }
  }

  override def toString: String = super.toString + " Kvitt eller Dubbelt"
}

trait hax extends RaceTurtle { //fuskar och hoppar direkt till slutet (låg chans)
  val stepR = new Random()
  override def raceStep() = {
    //hoppar till mål (<0.1% chans) annars går 0.5 i x-led
    if (math.random < 0.001) {
      position = Point(750, position.y)
    }
    else {
      forward(0.5)
    }
  }
  override def toString: String = super.toString + " hax"
}

trait Ghostery extends RaceTurtle { //Mall för trait

  override def raceStep() = ??? //Define your traits characteristics

  override def toString: String = super.toString + " nameOfTrait"
}

trait nameOfTrait extends RaceTurtle { //Mall för trait

  override def raceStep() = ??? //Define your traits characteristics

  override def toString: String = super.toString + " nameOfTrait"
}
