package turtlerace

import cslib.window.SimpleWindow

/** A Kojo-like Turtle class that can be used to draw shapes in a SimpleWindow.
  *
  * @param window    The window the turtle should be placed in.
  * @param position  A Point representing the turtle's starting coordinates.
  * @param angle     The angle between the turtle direction and the X-axis
  *                  measured in degrees. Positive degrees indicate a counter
  *                  clockwise rotation.
  * @param isPenDown A boolean representing the turtle's pen position. True if
  *                  the pen is down. */
class Turtle(window: SimpleWindow,
             private var position: Point = Point(0, 0),
             private var angle: Double = 0,
             private var isPenDown: Boolean = false) {

  /** Gets the Turtle's current pixel position on the x axis */
  def x: Int = position.x.toInt

  /** Gets the Turtle's current pixel position on the y axis
    * (measured from the top left) */
  def y: Int = position.y.toInt

  /** Moves the turtle to a new position without drawing a line. */
  def jumpTo(newPosition: Point) = {
    position = newPosition
//    window.moveTo(newPosition.x.toInt, newPosition.y.toInt)
  }

  /** Moves the turtle forward in its current direction, drawing a line if
    * the pen is down.
    * @param length The number of pixels to move forward. */
  def forward(length: Double): Unit = {
    val forwardDx = length * math.cos(angle.toRadians)
    val forwardDy = length * math.sin(angle.toRadians)
    val newX = position.x + forwardDx
    val newY = position.y - forwardDy

    // LÄGG IN KOD FÖR FLER TURTLES HÄR (sätt pennan vid nuvarande pos for aktuell turtle)
    window.moveTo(x, y)
    if (isPenDown) {
      window.lineTo(newX.toInt, newY.toInt)
    }
    else {
//      window.moveTo(newX.toInt, newY.toInt)               //Denna behövs väl inte?? Vad är meningen med att köra moveTo när
                                                          // det inte ritas något on window-position ändå kanske ändras av annan turtle
                                                          // innan denna turtle:n rör sig igen?
    }
    position = Point(newX, newY)
  }

  /** Turns the turtle to the left.
    *
    * @param turnAngle The number of degrees to turn. */
  def turnLeft(turnAngle: Double): Unit = angle += turnAngle

  /** Turns the turtle to the right.
    *
    * @param turnAngle The number of degrees to turn. */
  def turnRight(turnAngle: Double): Unit = angle -= turnAngle

  /** Turns the turtle straight up. */
  def turnNorth(): Unit = angle = 90

  /** Sets the turtle's pen down, causing it to draw lines when it moves */
  def penDown(): Unit = isPenDown = true

  /** Lifts the turtle's pen, preventing it from drawing lines. */
  def penUp(): Unit = isPenDown = false
}

