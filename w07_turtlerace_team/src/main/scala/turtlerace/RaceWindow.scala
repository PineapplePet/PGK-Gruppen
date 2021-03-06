package turtlerace
import cslib.window._
import java.io.{ByteArrayInputStream, File}
import javax.imageio.ImageIO

class RaceWindow extends SimpleWindow(800,600,"Race"){

  private val startX = 50
  private val endX = 750

  val f = ImageIO.read(new File(getClass.getClassLoader.getResource("turtlerace/racebana.png").getPath))
  val f2 = ImageIO.read(new File(getClass.getClassLoader.getResource("turtlerace/racebana2.png").getPath))


  /**
   * Draws a race in the RaceWindow
   */

  def draw(): Unit = {

    moveTo(0,0)
    drawImage(f2)
    for(i <- 1 to 8){
      moveTo(60, i*40 + 30)
      writeStartNumbers(i.toString)
    }
  }

  def printTitle(title: String): Unit = {
    moveTo(50, 20)
    writeStartNumbers(title)
  }

  /**
    * Returns the RaceTurtles in the race in a diagram underneath the race.
    */
  def printRacers(vector: Vector[RaceTurtle], x: Int, titel: String): Unit = {
    val newLine = 15
    moveTo(x, 450)
    writeText(titel)
    var i = 0
    while(i < vector.size) {
      moveTo(x, 450 + newLine * (i+1))
      writeText(s"$i. " + vector(i))
      i += 1
    }

  }

  /**
   * Returns the Y-coordinate for the turtle with start number n
   */
  def getStartY(n: Int): Int = { n*40 + 30}
  
  /**
   * Returns the X-coordinate of the starting position
   */
  def getStartX: Int = { startX }
  
  /**
   * Returns the X-coordinate of the finish line
   */
  def getEndX: Int = { endX }


}