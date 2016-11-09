package chord;
import chord.model._
object ChordPlayer {
 
  /**
   * Will play the chord once and let it ring for the specified time
   */
  def apply(chord: Chord, time: Int): Unit = {

    //Omvandling av ackord till toner:
    // Omvandla först tuning till en heltalsrepresentation

    // Sedan ska grip adderas till stämningen tuning för varje sträng

    SimpleNotePlayer.play( ,time)
    try {
      Thread.sleep(time); SimpleNotePlayer.stop; // wait time in milliseconds and than stop the sound
    } catch { case e: InterruptedException => println(e) }
  }
}