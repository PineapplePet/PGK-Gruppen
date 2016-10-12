package turtlerace

import cslib.window.SimpleWindow

import scala.util.Random

class RaceTurtle(private val w: RaceWindow, var nbr: Int, val name: String) extends Turtle(w: SimpleWindow, Point(w.getStartX, w.getStartY(nbr)), 0, true) {
  val rand = new Random()

  /**
    * Takes one step of a random length 1 to 5
    */
  def raceStep(): Unit = {
    Turtle.forward(rand.nextInt(5))
  }

  /**
    * Restarts the turtle at the finish line.
    * To be used before each race
    */
  def restart: Unit = {
      Turtle.jumpTo(w.getStartX, w.getStartY(nbr))
  }

  override def toString: String = ???
}