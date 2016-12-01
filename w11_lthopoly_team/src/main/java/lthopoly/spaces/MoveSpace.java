package lthopoly.spaces;

import lthopoly.GameBoard;
import lthopoly.cards.MoveCard;
import java.util.Random;

/**
 * Created by Tank on 4/17/2016.
 */
public class MoveSpace extends BoardSpace {
    private MoveCard[] cards;

    /**
     * Creates a new MoveSpace. When landing on this space a card from the card array will be drawn
     */
    public MoveSpace(MoveCard[] cards) {
        this.cards = cards;
    }

    /**
     * Returns an array of possible game actions permitted by this space
     */
    @Override
    public int[] getPossibleActions(GameBoard board) {
        return new int[] {GameBoard.DRAW_CARD};
    }

    /**
     * Draws a random MoneyCard from the cards array
     */
    private MoveCard drawCard(MoveCard[] cards) {
        Random generator = new Random();
        return cards[generator.nextInt(cards.length)];
    }

    /**
     * Performs a MoveSpace-related action.
     */
    @Override
    public void action(GameBoard board, int action) {
        if (action == GameBoard.DRAW_CARD) drawCard(cards);
    }

    /**
     * Returns a string representation of the MoveSpace
     */
    @Override
    public String toString() {
        return "Riskruta";
    }
}
