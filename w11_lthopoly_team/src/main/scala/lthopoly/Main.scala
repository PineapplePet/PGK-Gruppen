package lthopoly

import java.util

import lthopoly._
import lthopoly.cards.MoveCard

import scala.collection.JavaConverters._
import java.util.ArrayList;
object Main {
  def main(args: Array[String]): Unit = {


    //var lista2 = java.util.List<Player>



    //    lista2.apply(new Player("fsaaf",0,0))

    //lista2(new Player("fasf",0,0))

    var lista = new java.util.ArrayList[Player]

    lista.add(new Player("Player1",50,0))
    lista.add(new Player("Player2",50,0))
    lista.add(new Player("Player3",50,0))
    lista.add(new Player("Player4",50,0))
    lista.add(new Player("Player5",50,0))

    val board = new GameBoard(lista)

    /*val charlie = new MoveCard("Tjabba fungerar de beoooooor",2)
    println(charlie.getPositionAdjustment)*/
  }

  /**
    * Retrieves all possible actions from GameBoard and joins them with
    * a corresponding description String into tuples.
    * The tuples are then sent to the promptForInput method in TextUI.
    *
    * @return the user's choice as given by promptForInput.
    */
  def getAction(board: GameBoard): Int = ???
}
