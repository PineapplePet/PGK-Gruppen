package turtlerace

import cslib.window.SimpleWindow
import scala.util.Random

class RaceTurtle(window: RaceWindow,
                 position: Point = Point(0, 0),
                 angle: Double = 0,
                 isPenDown: Boolean = false,
                 color: java.awt.Color,
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