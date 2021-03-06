package turtlerace

/** Represents a single Point in the x,y plane. */
case class Point(x: Double, y: Double) {
  /** Returns a new Point which has been moved some number of pixels */
  def translate(dx: Double, dy: Double) = Point(x+dx, y+dy)
}
