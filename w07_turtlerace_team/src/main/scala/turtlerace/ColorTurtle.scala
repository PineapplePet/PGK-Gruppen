package turtlerace

import cslib.window.SimpleWindow

/**
  *
  * @param window    The window the turtle should be placed in.
  * @param position  A Point representing the turtle's starting coordinates.
  * @param angle     The angle between the turtle direction and the X-axis
  *                  measured in degrees. Positive degrees indicate a counter
  *                  clockwise rotation.
  * @param isPenDown A boolean representing the turtle's pen position. True if
  *                  the pen is down.
  * @param color     Färgen på linjen som dras bakom en turtle om isPenDown=true
  */

class ColorTurtle(window: SimpleWindow,
                  position: Point = Point(0, 0),
                  angle: Double = 0,
                  isPenDown: Boolean = true,
                  var color: java.awt.Color) extends Turtle(window, position, angle, isPenDown) {

  override def forward(length: Double): Unit = {
    val windowOriginalColor = window.getLineColor
    window.setLineColor(color)
    super.forward(length)
    window.setLineColor(windowOriginalColor)
  }
}