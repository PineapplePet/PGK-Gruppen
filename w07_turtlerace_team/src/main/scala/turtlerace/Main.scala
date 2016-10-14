package turtlerace

import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import java.net.URL
import javax.sound.sampled._



object Main {
  def main(args : Array[String]): Unit = {

    val w = new RaceWindow
    w.draw

    val rand = new Random

    var raceNames = Sequence.nameSeq.toList //Seq med åtta namn från RaceTurtleNames.txt görs om till List
    raceNames = scala.util.Random.shuffle(raceNames) //Blandar listan med namn




    var raceColors = Sequence.colorSeq
    raceColors = scala.util.Random.shuffle(raceColors)

    heat(w,1,"Kvartsfinal 1")


    def heat(window: RaceWindow, heatNummer: Int, titel: String): Vector[RaceTurtle] = {
      val rVector = for (i <- 1 to 8) yield {
        //Skapar 8 RaceTurtles för racet och tar de 8 första namnen från listan raceNames
        var randomNumber = rand.nextInt(3) //Randomizing Traits for RaceTurtles
        if (randomNumber == 0) {
          new RaceTurtle(w, nbr = i, name = raceNames(1) + " ", color = raceColors(1)) with Dizzy
        } else if (randomNumber == 1) {
          new RaceTurtle(w, nbr = i, name = raceNames(1) + " ", color = raceColors(1)) with KeD
        } else if (randomNumber == 2) {
          new RaceTurtle(w, nbr = i, name = raceNames(1) + " ", color = raceColors(1)) with StockMarket
        }
        else {
          new RaceTurtle(w, nbr = i, name = raceNames(1) + " ", color = raceColors(1)) with Portalberoende
        }
      }
      rVector.toVector
      TurtleRace.race(rVector, w, titel).toVector
    }

    

  }

    //var fyraBästa = ArrayBuffer.empty[RaceTurtle]
    //for (i <- 0 to 3) {
     // fyraBästa += winnersKvartsfinal(i)
    //}


    //val winnersKvartsfinal2 = ???

}
