package chord

object database {
  import model._
  type Chords = Vector[Chord]
  private var db: Chords = Vector()  // populated when chords are loaded from file
  private var filter: String = ""  // empty string means no filter
  
  /**
   * Finds the chords among the filtered chords matching the string s
   */
  def find(s: String): Chords = {
    var lista: Vector[Chord] = Vector()
    for (i <- db.indices) {             //indices = går genom samtliga index (samma som 0 until size)
      if (db(i).isIncludedBy(s)) {
        lista = lista :+ db(i)
      }
    }
    lista
  }
  
  /**
   * Adds the chord c to the database
   */
  def add(c: Chord): Unit = {
    db = db :+ c
  }
  
  /**
   * Delete the chord with index i among the filtered chords
   */
  def delete(i: Int): Unit = {

    db = db.filter(_ != filteredChords(i))


  }

  /**
   * Update the filter to string s.
   * Empty string results in no filter
   */
  def updateFilter(f: String): Unit = {

    if (f.isEmpty) {
      filter = ""
    } else {
      filter = f
    }
  }
 
  /**
   * Returns all chords matching the filter
   */
  def filteredChords: Chords = {

    val filterLista = filter.split(";")


   // "git:C; uku: ; :D"

    var lista: Vector[Chord] = Vector()

    for (i <- filterLista.indices){
      for (j <- db.indices)
        {
          if (db(j).toString.contains(filterLista(i))) { lista = lista :+ db(j)}
        }
    }
    lista
  }

  /**
   * Return all chords in the database
   */
  def allChords: Chords = {
    db
  }

  /**
   * Sorts the chords first by instrument and then by name
   */
  def sort: Unit = {
    var dbstring = db.mkString("Ö").split("Ö").sorted
    var tempDb: Vector[Chord] = Vector()
    for (i <- dbstring.indices)
      {
       tempDb = tempDb :+ Chord.fromString(dbstring(i)).toVector(0)
      }
    db = tempDb
  }
}