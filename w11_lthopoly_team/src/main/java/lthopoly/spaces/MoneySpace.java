package lthopoly.spaces;

import lthopoly.GameBoard;
import lthopoly.TextUI;
import lthopoly.cards.MoneyCard;
import lthopoly.cards.MoveCard;

import java.util.Random;

/**
 * Created by Tank on 4/17/2016.
 */
public class MoneySpace extends BoardSpace {
    private MoneyCard[] cards;
    private MoneyCard myCard;

    /**
     * Creates a new MoneySpace. When landing on this space a card from the card array will be drawn
     */
    public MoneySpace(MoneyCard[] cards) {
        this.cards = cards;
        myCard = drawCard(cards);
    }

    /**
     * Returns an array of possible game actions permitted by this space
     */
    @Override
    public int[] getPossibleActions(GameBoard board) {
            return new int[] {GameBoard.DRAW_CARD,GameBoard.END_TURN, GameBoard.DEFAULT_VIEW, GameBoard.SHOW_BOARD, GameBoard.EXIT_GAME};
    }

    /**
     * Draws a random MoneyCard from the cards array
     */
    private MoneyCard drawCard(MoneyCard[] cards) {
        Random generator = new Random();
        return cards[generator.nextInt(cards.length)];
    }

    /**
     * Performs a MoneySpace-related action.
     */
    public void action(GameBoard board, int action) {

        if (action == GameBoard.DRAW_CARD) {
            if (!board.getCurrentPlayer().hasMoneyCard) {
                MoneyCard chosenMoneyCard = drawCard(cards);
                TextUI.addToLog(chosenMoneyCard.getDescription());
                int cardAdjustment = chosenMoneyCard.getMoney();
                board.getCurrentPlayer().adjustMoney(cardAdjustment);
                board.getCurrentPlayer().hasMoneyCard = true;
                System.out.println(board.getCurrentPlayer() + " har nu " + board.getCurrentPlayer().getMoney() + " kr.");
            }
            else { TextUI.addToLog(board.getCurrentPlayer() + " har redan dragit ett pengakort."); }
        }
        else if(action == GameBoard.END_TURN) {
            TextUI.addToLog(board.getCurrentPlayer() + " har avslutat sin runda.");
            board.nextTurn();
        }
        else if(action == GameBoard.DEFAULT_VIEW) TextUI.printStatus(board);
        else if(action == GameBoard.SHOW_BOARD) TextUI.printBoard(board);
        else if(action == GameBoard.EXIT_GAME) System.exit(1337);
    }

    /**
     * Returns a string representation of the MoneySpace
     */
    @Override
    public String toString() {
        return "Chansruta";
    }
}
