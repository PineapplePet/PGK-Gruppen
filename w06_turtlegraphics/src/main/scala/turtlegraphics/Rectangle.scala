package turtlegraphics

/** Immutable class representing a rectangle.
  * @param position a Point representing the upper left corner of the rectangle
  *                 (before rotation)
  * @param width    the width of the rectangle
  * @param height   the height of the rectangle
  * @param angle    the angle of the rectangle (rotated around the upper
  *                 left corner) Positive degrees indicate a counter clockwise
  *                 rotation measured from the X-axis
  */
case class Rectangle(private val position: Point,
//                     private val width: Double,
                             val width: Double,
                     private val height: Double,
                     private val angle: Double) {
  /** Draws the rectangle using a turtle */
  def draw(turtle: Turtle): Unit = {
    turtle.jumpTo(position)
    turtle.penDown()

    { // Ställer rätt vinkel innan ritning
      turtle.turnNorth()
      turtle.turnRight(90)
      turtle.turnLeft(angle)
    }

    turtle.forward(width)

    turtle.turnRight(90)
    turtle.forward(height)

    turtle.turnRight(90)
    turtle.forward(width)

    turtle.turnRight(90)
    turtle.forward(height)
  }

  /*************** MIN GETTER.....HEHE */
  def getPos: Point = position

  /** Returns a new Rectangle that is rotated to the left */
  def rotateLeft(degrees: Double): Rectangle = new Rectangle(position, width, height, angle+degrees)

  /** Returns a new Rectangle that is rotated to the right */
  def rotateRight(degrees: Double): Rectangle = new Rectangle(position, width, height, angle-degrees)

  /** Returns a new Rectangle that has been scaled by a size factor */
  def scale(factor: Double): Rectangle = new Rectangle(position, width*factor, height*factor, angle)

  /** Returns a new Rectangle that has been moved some number of pixels */
  def translate(dx: Double, dy: Double): Rectangle = new Rectangle(Point(position.x+dx, position.y+dy), width, height, angle)
}

