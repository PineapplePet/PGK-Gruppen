package turtlerace

import scala.util.Random

/**
  *
  * @param window    The window the turtle should be placed in.
  * @param position  A Point representing the turtle's starting coordinates.
  * @param angle     The angle between the turtle direction and the X-axis
  *                  measured in degrees. Positive degrees indicate a counter
  *                  clockwise rotation.
  * @param isPenDown A boolean representing the turtle's pen position. True if
  *                  the pen is down.
  * @param color     Färgen på linjen som dras bakom en turtle om isPenDown=true
  * @param nbr       "ID"-nummer unikt för varje objekt av turtle
  * @param name      Namnet på ett object av turtle
  */

class RaceTurtle(window: RaceWindow,
                 position: Point = Point(0, 0),
                 angle: Double = 0,
                 isPenDown: Boolean = true, //ändra till false om man vill ha groda
                 color: java.awt.Color = java.awt.Color.CYAN,
                 var nbr: Int,
                 val name: String) extends ColorTurtle(window, position, angle, isPenDown, color) {

  val rand = new Random()

  /**
    * Takes one step of a random length 1 to 5
    */
  def raceStep(): Unit = {
    forward(rand.nextInt(5) + 1)
  }

  /**
    * Restarts the turtle at the finish line.
    * To be used before each race
    */
  def restart: Unit = {
    jumpTo(Point(window.getStartX, window.getStartY(nbr)))
  }

  override def toString: String = s"Trait: #$nbr Name: $name"
}