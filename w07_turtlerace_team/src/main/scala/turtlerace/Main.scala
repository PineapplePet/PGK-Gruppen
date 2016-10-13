package turtlerace
import cslib.window.SimpleWindow

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.Random



object Main {
  def main(args : Array[String]): Unit = {

    val w = new RaceWindow
    w.draw

    val rand = new Random //Randomizing Traits for RaceTurtles
    var rVar = 0 //slumptal mellan 0, 1, 2 i for-loopen nedan
    val rVector = for(i <- 1 to 8) yield {
      rVar = rand.nextInt(3)
      if(rVar == 0){
        new RaceTurtle(w,  nbr = i, name = s"$i") with Dizzy
      }else if(rVar == 1){
        new RaceTurtle(w,  nbr = i, name = s"$i") with KeD
      }else{
        new RaceTurtle(w,  nbr = i, name = s"$i") with Abstinence
      }
    }

    val winnersKvartsfinal = TurtleRace.race(rVector, w, "Kvartsfinal").toVector
    w.printRacers(winnersKvartsfinal, w.getEndX - 100, "Results")
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
