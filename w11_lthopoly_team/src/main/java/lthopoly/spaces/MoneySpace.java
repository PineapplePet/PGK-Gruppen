package lthopoly.spaces;

import lthopoly.GameBoard;
import lthopoly.TextUI;
import lthopoly.cards.MoneyCard;
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



        if (action == GameBoard.DRAW_CARD) drawCard(cards);
        else if(action == GameBoard.END_TURN) board.nextTurn();
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
