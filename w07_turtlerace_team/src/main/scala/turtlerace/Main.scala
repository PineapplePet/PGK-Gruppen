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

    def deltagare(window: RaceWindow, startNummer: Int): Vector[RaceTurtle] = {
      val rVector = for (i <- startNummer to startNummer + 7) yield {
        //Skapar 8 RaceTurtles för racet och tar de 8 första namnen från listan raceNames
        var randomNumber = rand.nextInt(3) //Randomizing Traits for RaceTurtles
        if (randomNumber == 0) {
          new RaceTurtle(w, nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with Dizzy
        } else if (randomNumber == 1) {
          new RaceTurtle(w, nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with KeD
        } else if (randomNumber == 2) {
          new RaceTurtle(w, nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with StockMarket
        }
        else {
          new RaceTurtle(w, nbr = i, name = raceNames(i) + " ", color = raceColors(i)) with Portalberoende
        }
      }
      rVector.toVector
    }

    val kvartsFinaler = for (i <- 0 to 31 by 8) yield {
      deltagare(w, i)
    }

    for (i <- 0 to 3)
      {TurtleRace.race(kvartsFinaler(i), w, s"Kvartsfinal $i+1")
      w.clear()
        w.draw()
      }
    

  }

    //var fyraBästa = ArrayBuffer.empty[RaceTurtle]
    //for (i <- 0 to 3) {
     // fyraBästa += winnersKvartsfinal(i)
    //}


    //val winnersKvartsfinal2 = ???

}
