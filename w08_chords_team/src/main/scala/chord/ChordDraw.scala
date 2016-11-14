package chord
import cslib.window.SimpleWindow
import chord.model._

object ChordDraw {
  val w = new SimpleWindow(400, 600, "Chord draw")
  /**
   * Draws the chord c in a SimpleWindow
   */
  def apply(c: Chord): Unit = {
    SimpleWindow.setExitOnLastClose(false)
    w.clear
    val nbrOfStrings = c.tuning.length
    //Code to draw fret board and grip
    w.moveTo(50, 90)
    for (i <- 0 until c.tuning.length) {  //skriver stämningen över staplarna
      w.writeText(c.tuning(i))
      w.moveTo(x+50, y)
    }

    var x = 50
    var y = 100
    for (i <- 0 until nbrOfStrings) {  //ritar nbrOfStrings stycken staplar
      for (i <- 0 until 10) {          //ritar kvadrater in vertikal stapel
        w.moveTo(x, y)
        w.lineTo(x + 50, y)
        w.lineTo(x, y + 50)
        w.lineTo(x - 50, y)
        w.lineTo(x, y - 50)
        y += 50
      }
      w.moveTo(x + 50, 100)
    }



    play(c)
  }
  
  /**
   * Waits for mouse click and plays the note of the string clicked on
   */
  def play(c: Chord): Unit = ???

  /**
   * Draws a cross with center i the coordinate (x,y)
   */
  def cross(x: Int, y: Int): Unit = ???
}