package turtlerace

object FileUtils {

  import java.nio.file.{Paths, Files}

  def save(s: String, fileName: String): Unit =
    Files.write(Paths.get(fileName), s.getBytes("UTF-8"))
}