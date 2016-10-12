package turtlerace;
import cslib.window._

import java.io.File
import javax.imageio.ImageIO

class RaceWindow extends SimpleWindow(800,400,"Race"){

  private val startX = 50
  private val endX = 750


  val seelpic = ImageIO.read(new File("/h/d7/s/ol4084da-s/ProgZip/workspace/PGK-Gruppen/w07_turtlerace_team/src/main/scala/turtlerace/racebana.png"))
  /**
   * Draws a race in the RaceWindow
   */
  def draw: Unit = ???
  
  /**
   * Returns the Y-coordinate for the turtle with start number n
   */
  def getStartY(n: Int): Int = { n*40 + 10}
  
  /**
   * Returns the X-coordinate of the starting position
   */
  def getStartX: Int = { startX}
  
  /**
   * Returns the X-coordinate of the finish line
   */
  def getEndX: Int = { endX}
}