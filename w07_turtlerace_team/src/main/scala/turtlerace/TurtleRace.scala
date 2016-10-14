package turtlerace

import scala.collection.mutable.ArrayBuffer
import cslib.window._
import java.awt.Color

object TurtleRace {
  /**
    * Perform a race between eight turtles and returns the turtles in finishing order
    */
  def race(turtles: Seq[RaceTurtle], rw: RaceWindow, title: String): List[RaceTurtle] = {
    rw.printRacers(turtles.toVector, rw.getStartX, "Racers")
    rw.printTitle(title)

    var winners = ArrayBuffer.empty[RaceTurtle]

    while (winners.size < 4) {
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

object Sequence{
  /**
    * Returnerar sekvens med namn tagna från RaceTurtleNames.txt
    */
  def nameSeq: Vector[String] = {
      FileUtils.readLines("/h/d3/t/mas14dhu/Desktop/PGK-Gruppen/w07_turtlerace_team/src/main/scala/turtlerace/RaceTurtleNames.txt")
    }

/**
  * Returnerar sekvens med färger från RaceTurtleColors.txt
  */
  def colorVector: Vector[Color] = { //Blev för lång så kan kortas ned kod mässigt :O
    val colorStringVector = FileUtils.readLines("/h/d3/t/mas14dhu/Desktop/PGK-Gruppen/w07_turtlerace_team/src/main/scala/turtlerace/RaceTurtleColors.txt")

    var colorColorVector = new Array[java.awt.Color](colorStringVector.size)
    for(i <- 0 until (colorStringVector.size - 1)){
      if (colorStringVector(i) == "black"){
        colorColorVector(i) = Color.black
      }else if (colorStringVector(i) == "lightGray"){
        colorColorVector(i) = Color.lightGray
      }else if (colorStringVector(i) == "blue"){
        colorColorVector(i) = Color.blue
      }else if (colorStringVector(i) == "magenta"){
        colorColorVector(i) = Color.magenta
      }else if (colorStringVector(i) == "cyan"){
        colorColorVector(i) = Color.cyan
      }else if (colorStringVector(i) == "orange"){
        colorColorVector(i) = Color.orange
      }else if (colorStringVector(i) == "darkGray"){
        colorColorVector(i) = Color.darkGray
      }else if (colorStringVector(i) == "pink"){
        colorColorVector(i) = Color.pink
      }else if (colorStringVector(i) == "gray"){
        colorColorVector(i) = Color.gray
      }else if (colorStringVector(i) == "red"){
        colorColorVector(i) = Color.red
      }else if (colorStringVector(i) == "green"){
        colorColorVector(i) = Color.green
      }else {
        colorColorVector(i) = Color.yellow
      }
    }

    colorColorVector.toVector //Returnerar FärgSekvens
  }
}
