package chord

import java.nio.file.Files

import chord.model.Chord

import scala.util.{Failure, Success, Try}

object textui {
  trait Cmd {
    def variants: Set[String]
    def helpText: String
    def doWith(args: Vector[String]): String
    def ===(s: String): Boolean = variants.contains(s.toLowerCase)
  }

  object Play extends Cmd {
    val variants = Set("play", "P", "p")
    val helpText = "Plays a chord, e.g. play 10 5, where 10 represents the duration in milliseconds and 5 the listing of the wanted chord"

    def doWith(args: Vector[String]): String = {
      ChordPlayer(model.Guitar("D", model.stringToGripVec("-1 -1 0 2 3 2")), 1000)
      args match {

        case args if args.length > 2 => "Too many inputs"
        case args if args.length < 2 => "Too few inputs"
        case args if !args.forall(x => x.replaceAll("-", "").forall(_.isDigit)) => "Only numbers allowed" //kontrollerar att alla parametrar är nummer
        case `args` if `args`(0).toInt < 0 => "Index out of bounds at first parameter"
        case `args` if `args`(1).toInt < 0 || `args`(1).length > 1 => "Index out of bounds at second parameter"
        case _ => ChordPlayer(database.filteredChords(args(1).toInt), args(0).toInt)
          "playing"
      }
    }
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
    SimpleNotePlayer.play(2, 5000)
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
    def doWith(args: Vector[String]): String = {
      val test = args match {
        case whatever if(args.isEmpty) => false
        case _ => true
        }
      if (test)
        {
          try {
              val lista = scala.io.Source.fromFile(args(0))("UTF-8").getLines.toVector
              for (i <- lista.indices) {
                database.add(Chord.fromString(lista(i)).toVector(0))
              }
              database.filteredChords.mkString(", ")

          } catch { case e: Exception => "Unable to load: " +  e.getMessage}
        }
      else { "whaaaat"}
    }

  }

  object Save extends Cmd {
    val variants = Set("save", "s")
    val helpText = "Saves all chords to file"
    def doWith(args: Vector[String]): String = {


      val test = args match {
        case whatever if args.isEmpty => false
        case _ => true
      }

      if (test)
      {

        try {

          var lista : Vector[String] = Vector()

            for (i<- 0 until database.allChords.size ){
            lista = lista :+ database.allChords(i).toString
          }


           io.save(args(0),lista)

          database.filteredChords.mkString(", ")

        } catch { case e: Exception => "Unable to load: " +  e.getMessage}


      }
      else { "No file in input"}

    }
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
    def doWith(args: Vector[String]): String = {


      if(quitPrompt){System.exit(0);"Chords shutting down"}
      else { "Chords continues"}


    }
    
    def quitPrompt: Boolean = {

      scala.io.StdIn.readLine("Quit, Y or N?").toLowerCase match {
        case "y" => true
        case  "n" => false
        case _ => println("whatcha doing mate"); false
      }


    }
  }

  object doCommand {
    var quit = false
    def unknownCmdHelp(cmd: String) = s"Unkown command: $cmd\nType ? for help."
    val cmds = Vector[Cmd](Add, Lst, Del, Filter, Find, Load, Save, Sort, Help, Quit, Play)
    def apply(cmd: String, args: Vector[String]): String = cmds.find(_ === cmd) match {
      case Some(command) => command doWith args
      case None => unknownCmdHelp(cmd)
    }
  }
}