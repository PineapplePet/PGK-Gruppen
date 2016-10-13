package turtlerace

import scala.util.Random

/**
  *
  * @param window    The window the turtle should be placed in.
  * @param isPenDown A boolean representing the turtle's pen position. True if
  *                  the pen is down.
  * @param color     Färgen på linjen som dras bakom en turtle om isPenDown=true
  * @param nbr       "ID"-nummer unikt för varje objekt av turtle
  * @param name      Namnet på ett object av turtle
  */

class RaceTurtle(window: RaceWindow,
                 isPenDown: Boolean = true, //ändra till false om man vill ha groda
                 color: java.awt.Color = java.awt.Color.CYAN,
                 var nbr: Int,
                 val name: String) extends ColorTurtle(window, position = Point(window.getStartX, window.getStartY(nbr)), angle = 0, isPenDown, color) {

  val rand = new Random()

  /**
    * Takes one step of a random length 1 to 5
    */
  def raceStep(): Unit = {
    forward(rand.nextInt(5) + 1)
  }

  /**
    * Takes one step of a length, x: Int. (for use within traits)
    */
  def raceStep(x: Int): Unit = {
    forward(x)
  }

  /**
    * Stops the Turtle a certain amount of ticks, default 3 ticks
    */
  def stepStop(ticks: Int = 3): Unit = {
    var i = 0
    while(i < ticks){
      forward(0)
      i += 1
    }
  }

  /**
    * Sekvens med namn tagna från .txt som innan varje race blandas.
    * sedan väljs de 8 första namnen ut och tilldelas RaceTurtle nbr i
    */
  def NameSequence: Seq = {

  }

  /**
    * Restarts the turtle at the finish line.
    * To be used before each race
    */
  def restart: Unit = {
    jumpTo(Point(window.getStartX, window.getStartY(nbr)))
  }

  override def toString: String = s"#$nbr Name: $name"
}