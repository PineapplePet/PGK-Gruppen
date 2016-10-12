package turtlerace

import cslib.window.SimpleWindow

class ColorTurtle(window: SimpleWindow,
                  private var position: Point = Point(0, 0),
                  private var angle: Double = 0,
                  private var isPenDown: Boolean = false,
                  private var color: java.awt.Color) extends Turtle(window, position, angle, isPenDown) {

  override def forward(length: Double): Unit = {
    val windowOriginalColor = window.getLineColor
    window.setLineColor(color)
    forward(length)
    window.setLineColor(windowOriginalColor)
  }
}