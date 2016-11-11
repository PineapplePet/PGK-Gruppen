package chord

import chord.model.Chord
import scala.util.{Try, Success, Failure}

object textui {
  trait Cmd {
    def variants: Set[String]
    def helpText: String
    def doWith(args: Vector[String]): String
    def ===(s: String): Boolean = variants.contains(s.toLowerCase)
  }

  object Add extends Cmd {
    val variants = Set("add", "a", "+")
    val helpText = "Adds a chord, e.g.> add git:D:-1 -1 0 2 3 2;uku:C:0 0 0 3"
    def doWith(args: Vector[String]): String = {
      // args ser ut såhär: Vector(git:D:-1, -1, 0, 2, 3, 2;uku:C:0, 0, 0, 3)
      var chordsToBeAdded = args.mkString(" ").split(";")
      //chrordsToBeAdded ser ut såhär: Array(git:D:-1 -1 0 2 3 2, uku:C:0 0 0 3)

      var resultat = "blablabal"

      //Dags att loopa i chrordsToBeAdded och köra add på varje element
      for (i <- 0 until chordsToBeAdded.size)
        {

          if(chordsToBeAdded(i).split(':').size != 3)
            {
                  resultat = "fel format"
            }
          else if(!chordsToBeAdded(i).split(':')(0).contains("git") && !chordsToBeAdded(i).split(':')(0).contains("uku") )
          {
                  resultat = "fel instrument"
          }
            else if(!Notes.notes.contains(chordsToBeAdded(i).split(':')(1))) {

              resultat = "tonen finns inte"

            }
         else {


            val instr = chordsToBeAdded(i).split(':')(0)
            val not = chordsToBeAdded(i).split(':')(1)
            val grip = chordsToBeAdded(i).split(':')(2)

            if(instr == "git") {
              database.add(model.Guitar(not, model.stringToGripVec(grip)))
            }
            else if(instr == "uku") {
              database.add(model.Ukulele(not, model.stringToGripVec(grip)))
            }

            resultat = "Chords added"
          }


        }

      resultat
    }
  }

  object Lst extends Cmd {
    val variants = Set("list", "li", "ls", "lst")
    val helpText = "Prints a numbered list of filtered chords (all chords if no filter is applied)"
    def doWith(args: Vector[String]): String = {
        database.filteredChords.mkString(", ")
    }
  }

  object Del extends Cmd {
    val variants = Set("delete", "del", "-")
    val helpText = "Deletes a chord at the given position in the filtered list of chords. Example: del 42"
    def doWith(args: Vector[String]): String = {
      if(args.nonEmpty) {
        if (args(0).toInt > database.filteredChords.size - 1 || args(0).toInt < 0) {
          "No chord to remove at the given position"
        }
        else {
          database.delete(args(0).toInt)
          database.filteredChords.mkString(", ")
        }
      }
      else {
        "Missing parameter for removal"
      }
    }
  }

  object Filter extends Cmd {
    val variants = Set("filter", "fil", "flt")
    val helpText = "Turn filter on/off. Example: filter git:Em;uku:C;:G"
    def doWith(args: Vector[String]): String = {


    if (args.nonEmpty)      {
      database.updateFilter(args(0))
    }
      else {
      database.updateFilter("")
    }

      database.filteredChords.mkString(", ")

    }
  }

  object Find extends Cmd {
    val variants = Set("find", "fnd", "f")
    val helpText = "Finds a chords among filtered (all chords if no filter is applied)"
    def doWith(args: Vector[String]): String = ???
  }

  object Load extends Cmd {
    import scala.io.Source
    val variants = Set("load", "lo", "ld")
    val helpText = "Loads chords from file"
    def doWith(args: Vector[String]): String = ???
  }

  object Save extends Cmd {
    val variants = Set("save", "s")
    val helpText = "Saves all chords to file"
    def doWith(args: Vector[String]): String = ???
  }

  object Sort extends Cmd {
    val variants = Set("sort", "srt")
    val helpText = "Sorts all chords in instrument and chord name order"
    def doWith(args: Vector[String]): String = {

      database.sort
      database.filteredChords.mkString(", ")


    }
  }

  object Help extends Cmd {
    val variants = Set("?", "help", "h")
    val helpText = "Prints help text for all or one commmand"
    def doWith(args: Vector[String]): String = {
      args match {
        case Vector(cmd) => doCommand.cmds.find(_ === cmd) match {
          case Some(command) => command.helpText
          case None => s"Unknown command: $cmd"          
        }
        case Vector() => (for(cmd <- doCommand.cmds) yield {
          cmd.variants.mkString(" ") + ": \n" + cmd.helpText
        }).mkString("\n\n")
        case Vector(_*) => (for(c <- args) yield{
          doCommand.cmds.find(_ === c) match {
            case Some(command) => command.helpText
            case None => s"Unknown command: $c"
          }
        }).mkString("\n")
      }
    }
  }

  object Quit extends Cmd {
    val variants = Set("quit", "q")
    val helpText = "Quits this app after a Y/N promtp"
    def doWith(args: Vector[String]): String = ???
    
    def quitPrompt: Boolean = ???
  }

  object doCommand {
    var quit = false
    def unknownCmdHelp(cmd: String) = s"Unkown command: $cmd\nType ? for help."
    val cmds = Vector[Cmd](Add, Lst, Del, Filter, Find, Load, Save, Sort, Help, Quit)
    def apply(cmd: String, args: Vector[String]): String = cmds.find(_ === cmd) match {
      case Some(command) => command doWith args
      case None => unknownCmdHelp(cmd)
    }
  }
}