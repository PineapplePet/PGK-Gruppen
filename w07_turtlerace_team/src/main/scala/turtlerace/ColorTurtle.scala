package turtlerace

import cslib.window.SimpleWindow

class ColorTurtle(window: SimpleWindow,
                  position: Point = Point(0, 0),
                  angle: Double = 0,
                  isPenDown: Boolean = true, //ändra till false om man vill ha groda
                  private var color: java.awt.Color) extends Turtle(window, position, angle, isPenDown) {

  override def forward(length: Double): Unit = {
    val windowOriginalColor = window.getLineColor
    window.setLineColor(color)
    super.forward(length)
    window.setLineColor(windowOriginalColor)
  }
}