package turtlerace

object Main {
  def main(args : Array[String]): Unit = {

    val w = new RaceWindow
    w.draw

    val rVector = for(i <- 1 to 8) yield {
       new RaceTurtle(w,  nbr = i, name = s"$i")
    }
    val winnersKvartsfinal = TurtleRace.race(rVector, w, "Kvartsfinal").toVector
    w.printRacers(winnersKvartsfinal, w.getEndX - 100, "Results")

  }
}
