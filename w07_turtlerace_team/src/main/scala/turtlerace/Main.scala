package turtlerace
import cslib.window.SimpleWindow

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.Random



object Main {
  def main(args : Array[String]): Unit = {

    val w = new RaceWindow
    w.draw

    val rand = new Random
    var rVar = 0 //slumptal mellan 0, 1, 2 i for-loopen nedan

    var raceNames = Sequence.nameSeq.toList    //Seq med åtta namn från RaceTurtleNames.txt görs om till List
    raceNames = scala.util.Random.shuffle(raceNames) //Blandar listan med namn

    var raceColors = Sequence.colorSeq
    raceColors = scala.util.Random.shuffle(raceColors)

    val rVector = for(i <- 1 to 8) yield { //Skapar 8 RaceTurtles för racet och tar de 8 första namnen från listan raceNames
      rVar = rand.nextInt(4) //Randomizing Traits for RaceTurtles
      if(rVar == 0){
        new RaceTurtle(w,  nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with Dizzy
      }else if(rVar == 1){
        new RaceTurtle(w,  nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with KeD
      }else if (rVar==2){
        new RaceTurtle(w,  nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with StockMarket
      }
      else
        {new RaceTurtle(w,  nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with Portalberoende}
    }

    val winnersKvartsfinal = TurtleRace.race(rVector, w, "Kvartsfinal").toVector
    w.printRacers(winnersKvartsfinal, w.getEndX - 300, "Results")
    println("Kvartsfinal")
    for (i <- 0 to 7) {
      println(winnersKvartsfinal(i))
    }

    var fyraBästa = ArrayBuffer.empty[RaceTurtle]
    for (i <- 0 to 3) {
      fyraBästa += winnersKvartsfinal(i)
    }
    //w.clear()
    //w.draw()


    // val winnersKvartsfinal2 = ???
  }
}
