package turtlerace
import w06_turtlegraphics.turtlegraphics_
import cslib.window.SimpleWindow

object Main {
  def main(args : Array[String]): Unit = {
    FileUtils.save("text2", "apelsin.txt")
    println("tja")
    val w = new RaceWindow
    w.draw
  }
}
