package turtlerace

import cslib.window.SimpleWindow

object Main {
  def main(args : Array[String]): Unit = {

    val w = new RaceWindow
    w.draw

    val rVector = for(i <- 1 to 8) yield {
       new RaceTurtle(w, Point(w.getStartX, w.getStartY(i)),  nbr = i, name = s"$i")
    }
    w.printRacers(rVector.toVector, w.getStartX, "Racers")

  }
}
