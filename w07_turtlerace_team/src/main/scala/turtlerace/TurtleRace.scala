package turtlerace;

import scala.collection.mutable.ArrayBuffer
import cslib.window._

object TurtleRace extends RaceTurtle{
  /**
    * Perform a race between eight turtles and returns the turtles in finishing order
    */
  def race(turtles: Seq[RaceTurtle], rw: RaceWindow, title: String): List[RaceTurtle] = {
    rw.printRacers(turtles, rw.getStartX, title)
    rw.printTitle(title)
    var winners = ArrayBuffer.empty[RaceTurtle]
    while (position.x < 750) {
      raceStep()
    }
    winners += RaceTurtle
  }
}