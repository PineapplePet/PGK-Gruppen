package turtlerace

import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import java.net.URL
import javax.sound.sampled._

import cslib.window.SimpleWindow



object Main {
  def main(args : Array[String]): Unit = {

    val w = new RaceWindow
    w.draw

    val rand = new Random

    var raceNames = Sequence.nameSeq.toList //Seq med åtta namn från RaceTurtleNames.txt görs om till List
    raceNames = scala.util.Random.shuffle(raceNames) //Blandar listan med namn



    var raceColors = Sequence.colorVector
    raceColors = scala.util.Random.shuffle(raceColors)


    for (i <- 1 to 4) yield {
      val lol = heat(w, 1, s"Kvartsfinal $i")
      w.printRacers(lol, w.getEndX - 200, "Winners" )
      SimpleWindow.delay(1500)
      w.clear()
      w.draw()
    }


    def heat (window: RaceWindow, startNummer: Int, titel: String): Vector[RaceTurtle] = {
      val rVector = for (i <- 1 to 8) yield {
        //Skapar 8 RaceTurtles för racet och tar de 8 första namnen från listan raceNames
        var randomNumber = rand.nextInt(5) //Randomizing Traits for RaceTurtles
        if (randomNumber == 0) {
          new RaceTurtle(w, nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with Dizzy
        } else if (randomNumber == 1) {
          new RaceTurtle(w, nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with KeD
        } else if (randomNumber == 2) {
          new RaceTurtle(w, nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with StockMarket
        }
        else if (randomNumber == 3) {
          new RaceTurtle(w, nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with hax
        }
        else {
          new RaceTurtle(w, nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with Portalberoende
        }
      }
      TurtleRace.race(rVector, w, titel ).toVector
    }




    

  }

    //var fyraBästa = ArrayBuffer.empty[RaceTurtle]
    //for (i <- 0 to 3) {
     // fyraBästa += winnersKvartsfinal(i)
    //}


    //val winnersKvartsfinal2 = ???

}
