package turtlerace

import scala.collection.mutable.ArrayBuffer
import cslib.window._

object TurtleRace {
  /**
    * Perform a race between eight turtles and returns the turtles in finishing order
    */
  def race(turtles: Seq[RaceTurtle], rw: RaceWindow, title: String): List[RaceTurtle] = {
    rw.printRacers(turtles.toVector, rw.getStartX, "Racers")
    rw.printTitle(title)

    var winners = ArrayBuffer.empty[RaceTurtle]

    while (winners.size < 8) {
      for (i <- 0 to 7) {
        if (turtles(i).x < rw.getEndX) {
          turtles(i).raceStep()
        }
        else if (!winners.contains(turtles(i))) {
          winners += turtles(i)
        }
      }
      SimpleWindow.delay(10)
    }
    winners.toList
  }
}

/**
  * Returnerar sekvens med namn tagna från RaceTurtleNames.txt
  */
object NameSequence{
    def nameSeq: Seq[String] = {
      FileUtils.readLines("/h/d3/t/mas14dhu/Desktop/PGK-Gruppen/w07_turtlerace_team/src/main/scala/turtlerace/RaceTurtleNames.txt")
    }
}

/**
  * Returnerar sekvens med färger från Turtle Colors.txt
  */
object ColorSequence{
  def colSeq: Seq[String] = {
    FileUtils.readLines()
  }
}
