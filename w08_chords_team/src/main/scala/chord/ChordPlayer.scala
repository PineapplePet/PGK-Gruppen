package chord;
import chord.model._
object ChordPlayer {
 
  /**
   * Will play the chord once and let it ring for the specified time
   */
  def apply(chord: Chord, time: Int): Unit = {
    //Add code to play chord
    val tuningInt: Vector[Int] = (for (i <- chord.tuning.indices) yield {    //tuningInt
      Notes.unapply(chord.tuning(i)).get           //Tar varje ton på resp instrSträng i tuning och omvandlar den tonen till en specifik heltalsrepresentation (typ = Option[Int]).
    }).toVector                                     //.get hämtar ut Int från Option[Int]


    val noteInt: Vector[Int] = Vector()
    for(i <- chord.tuning.indices){
      if(chord.grip(i) > -1){
        noteInt :+ tuningInt(i) + chord.grip(i)
      }
    }
    for (i <- 0 until noteInt.length) {
      SimpleNotePlayer.play(noteInt(i), time)
      try {
        Thread.sleep(time); SimpleNotePlayer.stop; // wait time in milliseconds and than stop the sound
      } catch {
        case e: InterruptedException => println(e)
      }
    }
  }
}