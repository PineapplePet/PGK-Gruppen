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

object Sequence{
  /**
    * Returnerar sekvens med namn tagna från RaceTurtleNames.txt
    */
  def nameSeq: Seq[String] = {
      FileUtils.readLines("/h/d3/t/mas14dhu/Desktop/PGK-Gruppen/w07_turtlerace_team/src/main/scala/turtlerace/RaceTurtleNames.txt")
    }

/**
  * Returnerar sekvens med färger från RaceTurtleColors.txt
  */
  def colorSeq: List[Color] = { //Blev för lång så kan kortas ned kod mässigt :O
    val colorStringSeq = FileUtils.readLines("/h/d3/t/mas14dhu/Desktop/PGK-Gruppen/w07_turtlerace_team/src/main/scala/turtlerace/RaceTurtleColors.txt")
    val colorColorSeq = new Array[Color](colorStringSeq.size)
    for(i <- 0 to (colorStringSeq.size - 1)){
      if (colorStringSeq(i) == "black"){
        colorColorSeq(i) = Color.black
      }else if (colorStringSeq(i) == "lightGray"){
        colorColorSeq(i) = Color.lightGray
      }else if (colorStringSeq(i) == "blue"){
        colorColorSeq(i) = Color.blue
      }else if (colorStringSeq(i) == "magenta"){
        colorColorSeq(i) = Color.magenta
      }else if (colorStringSeq(i) == "cyan"){
        colorColorSeq(i) = Color.cyan
      }else if (colorStringSeq(i) == "orange"){
        colorColorSeq(i) = Color.orange
      }else if (colorStringSeq(i) == "darkGray"){
        colorColorSeq(i) = Color.darkGray
      }else if (colorStringSeq(i) == "pink"){
        colorColorSeq(i) = Color.pink
      }else if (colorStringSeq(i) == "gray"){
        colorColorSeq(i) = Color.gray
      }else if (colorStringSeq(i) == "red"){
        colorColorSeq(i) = Color.red
      }else if (colorStringSeq(i) == "green"){
        colorColorSeq(i) = Color.green
      }else {
        colorColorSeq(i) = Color.yellow
      }
    }

    colorColorSeq.toList //Returnerad FärgSekvens
  }
}
