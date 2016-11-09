package chord;


object Notes {
  val notes: Vector[String] = Vector("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
  
  /**
   * Converts a number to a note, e.g. 1 -> C#
   */
  def fromNbrToNote(i: Int): String = {
      var note = notes(i % 12)
      note
  }
  
  /**
   * Converts a note to a number, e.g. E2 -> 16. C#2 will not be possible
   */
  def fromNoteToNbr(note: String): Int = unapply(note).getOrElse(0)
  
  val toNumber: Map[String, Int] = {
    notes.zipWithIndex.toMap
  }
  
  /**
   * Tries to convert a string into a number, e.g. E2 -> 16.
   */
  def unapply(s: String): Option[Int] = s match {
    case whatever if s.isEmpty => None
    case whatever if s.split("#").size == 2 && !notes.contains(s.take(2)) => None
    case whatever if s.charAt(0) < 'A' || s.charAt(0) > 'G'  => None
    case whatever if s.reverse.charAt(0) < '1' || s.reverse.charAt(0) > '9'  => None
    case whatever if s.length > 3  || s.length < 2 => None
    case _ => {
      var note = s
      var oktav = 0
      if (s.contains("#")) {
        note = s.take(2)
        oktav = s.drop(2).toInt
      } else {
        note = s.take(1)
        oktav = s.drop(1).toInt
      }
      if (!notes.contains(note) || oktav < 1) None

      val noteIndex = notes.indexOf(note)
      val noteNbr = 12 * oktav - 12 + noteIndex
      Some(noteNbr)
    }

  }
}