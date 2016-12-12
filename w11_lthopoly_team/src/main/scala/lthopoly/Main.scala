package lthopoly

import java.util

import lthopoly._
import lthopoly.cards.MoveCard

import scala.collection.JavaConverters._
import java.util.ArrayList

import lthopoly.parser.DocumentParser

import scala.collection.mutable.ArrayBuffer;
object Main {
  def main(args: Array[String]): Unit = {

    val players = new java.util.ArrayList[Player]

    players.add(new Player("Player1",50,0))
    players.add(new Player("Player2",50,0))
    players.add(new Player("Player3",50,0))
    players.add(new Player("Player4",50,0))
    players.add(new Player("Player5",50,0))

    val board = new GameBoard(players, DocumentParser.getBoard)
    val rand = new scala.util.Random
    var diceNum = 0

    while(!board.isGameOver){
      diceNum = rand.nextInt(6) + 1
      TextUI.addToLog(board.getCurrentPlayer + " slog en " + diceNum)
      board.getCurrentPlayer.setPosition((board.getCurrentPlayer.getPosition + diceNum) % 16)

      val menuLoopPlayer = board.getCurrentPlayer
      while (menuLoopPlayer == board.getCurrentPlayer) {
        TextUI.updateConsole(board)

        getAction(board) match {
          case i: Int => {
            board.doAction(i)
          }
            board.isGameOver match {
              case true => println(board.getCurrentPlayer + " har förlorat spelet!")
              case false => print("")
            }
        }
      }
    }
  }

  /**
    * Retrieves all possible actions from GameBoard and joins them with
    * a corresponding description String into tuples.
    * The tuples are then sent to the promptForInput method in TextUI.
    *
    * @return the user's choice as given by promptForInput.
    */
  def getAction(board: GameBoard): Int = {
    val allActions = Array((0, "THROW_DICE"), (1, "DRAW_CARD"), (2, "BUY_PROPERTY"), (3, "PAY_RENT"), (4, "END_TURN"), (5, "DEFAULT_VIEW"), (6, "SHOW_BOARD"), (7, "EXIT_GAME"))
    val allowedTupelChoices: ArrayBuffer[(Int, String)] = ArrayBuffer.empty
    board.getPossibleActions.foreach(x => allowedTupelChoices.append(allActions(x)))
    TextUI.promptForInput(allowedTupelChoices.toArray)
  }
}
