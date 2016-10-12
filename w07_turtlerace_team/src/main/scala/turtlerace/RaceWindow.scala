package turtlerace;
import cslib.window._
import java.awt.{Color, color}
import java.io.File
import javax.imageio.ImageIO

class RaceWindow extends SimpleWindow(800,600,"Race"){

  private val startX = 50
  private val endX = 750


  val f = ImageIO.read(new File(getClass.getClassLoader.getResource("turtlerace/racebana.png").getPath))
  val f2 = ImageIO.read(new File(getClass.getClassLoader.getResource("turtlerace/racebana2.png").getPath))

  /**
   * Draws a race in the RaceWindow
   */


  def draw: Unit = {

    drawImage(f2)
    for(i <- 1 to 8){

      moveTo(60, i*40 + 30)
      writeStartNumbers(i.toString)

    }
  }

  def printTitle(title: String): Unit = {

    moveTo(50, 10)
    writeStartNumbers(title)


  }
  
  /**
   * Returns the Y-coordinate for the turtle with start number n
   */
  def getStartY(n: Int): Int = { n*40 + 30}
  
  /**
   * Returns the X-coordinate of the starting position
   */
  def getStartX: Int = { startX}
  
  /**
   * Returns the X-coordinate of the finish line
   */
  def getEndX: Int = { endX}
}