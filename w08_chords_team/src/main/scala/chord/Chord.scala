package chord

object model {
  type Grip = Vector[Int]
  type Tuning = Vector[String]

  trait Chord {
    def name: String

    def tuning: Tuning

    def grip: Grip

    override def toString: String = {
      // git:B:-1 2 4 4 4 2
      if (grip.size == 6) {
        s"git:$name:${grip.mkString(" ")}"
      } else {
        s"uku:$name:${grip.mkString(" ")}"
      }
    }

    /**
      * Checks if chords toString match any part of the filter
      */
    def isIncludedBy(filter: String): Boolean = {
      val vektFilter = filter.split(";")
      var boolContains = false
      for (i <- 0 until vektFilter.size) {
        if (toString.contains(vektFilter(i))) {
          boolContains = true
        }
      }
      boolContains
    }
  }

  /**
    * Converts grip String to a Vector[Int], e.g. "-1 -1 0 2 3 2" to Vector(-1, -1, 0, 2, 3, 2)
    */
  def stringToGripVec(s: String): Vector[Int] = s.split(" ").map(_.toInt).toVector

  object Chord {
    /**
      * Converts a string to chord. Example string: git:D:-1 -1 0 2 3 2
      */
    def fromString(chordText: String): Option[Chord] = {
      def isGit(s: String) = if (s.split(":")(0) == "git") {
        true
      } else {
        false
      }
      def isUku(s: String) = if (s.split(":")(0) == "uku") {
        true
      } else {
        false
      }
      /**
        * Match the strings instr, name and grip against the different types of chords
        */
      def instToChord(instr: String, name: String, grip: String): Option[Chord] = {
        val s = s"$instr:$name:${grip.mkString(" ")}"
        isGit(s) match {
          case true => Some(Guitar(name, stringToGripVec(grip)))
          case false if isUku(s) => Some(Ukulele(name, stringToGripVec(grip)))
          case _ => None
        }
      }

      val xs: Vector[String] = chordText.split(':').toVector
      xs match {
        case Vector(instr, name, gripString) => instToChord(instr, name, gripString)
        case _ => None
      }
    }
  }

  case class Guitar(name: String, grip: Grip) extends Chord {
    //name = namnet på ackordet?
    override val tuning = "E2 A2 D3 G3 B3 E4".split(" ").toVector

    override def toString: String = s"git:$name:${grip.mkString(" ")}"
  }

  case class Ukulele(name: String, grip: Grip) extends Chord {
    //name = namnet på ackordet?
    override val tuning = "G4 C4 E4 A4".split(" ").toVector

    override def toString: String = s"uku:$name:${grip.mkString(" ")}"
  }

}