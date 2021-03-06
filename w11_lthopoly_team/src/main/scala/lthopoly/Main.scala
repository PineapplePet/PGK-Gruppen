package lthopoly
import scala.io.StdIn.readLine

import java.util

import lthopoly._
import lthopoly.cards.{MoneyCard, MoveCard}

import scala.collection.JavaConverters._
import java.util.ArrayList

import lthopoly.parser.DocumentParser
import lthopoly.spaces.MoneySpace

import scala.collection.mutable.ArrayBuffer;
object Main {
  def main(args: Array[String]): Unit = {

    val players = new java.util.ArrayList[Player]

    players.add(new Player(readLine("Välj namn för spelare 1: "),200,0))
    players.add(new Player(readLine("Välj namn för spelare 2: "),200,0))
    players.add(new Player(readLine("Välj namn för spelare 3: "),200,0))

    val board = new GameBoard(players, DocumentParser.getBoard)
    val rand = new scala.util.Random
    var diceNum = 0

    while(!board.isGameOver) {
      //Spara stats om det är första spelaren
      if (board.getCurrentPlayer == board.getPlayers.get(0)) {
        var totalMoney = 0
        board.getPlayers.toArray().foreach(totalMoney += _.asInstanceOf[Player].getMoney)
        println("### totalmoney: " + totalMoney)
        board.addStatistic(totalMoney)
        println("##### getstat: " + board.getStatistics)
      }


      //Tärning kastas
      diceNum = rand.nextInt(6) + 1
      TextUI.addToLog(board.getCurrentPlayer + " slog en " + diceNum + ":a")
      board.getCurrentPlayer.setPosition((board.getCurrentPlayer.getPosition + diceNum) % 16)

      val menuLoopPlayer = board.getCurrentPlayer
      TextUI.updateConsole(board)
      while (menuLoopPlayer == board.getCurrentPlayer && !board.isGameOver) {

        getAction(board) match {
          case i: Int =>
            board.doAction(i)
            board.isGameOver match {
              case true => {
                println(board.getCurrentPlayer + " har förlorat spelet!")
                board.nextTurn()
              }
              case false => print("")
            }
        }
      }
      board.getCurrentPlayer.hasMoneyCard = false;
    }
    TextUI.printStatus(board)
    println("Vinnaren är: " + board.getRichestPlayer)
    val buffer: scala.collection.mutable.Buffer[Int] = board.getStatistics.asScala.map(_.toInt)
    println(TextUI.plotStatistics(buffer))
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
