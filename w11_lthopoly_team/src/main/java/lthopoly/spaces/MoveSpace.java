package lthopoly.spaces;

import lthopoly.GameBoard;
import lthopoly.TextUI;
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
        return new int[] {GameBoard.DRAW_CARD,GameBoard.END_TURN, GameBoard.DEFAULT_VIEW, GameBoard.SHOW_BOARD, GameBoard.EXIT_GAME};
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
            if (action == GameBoard.DRAW_CARD) {
                MoveCard chosenMoveCard = drawCard(cards);
                int cardSteps = chosenMoveCard.getPositionAdjustment();
                board.getCurrentPlayer().setPosition((board.getCurrentPlayer().getPosition() + cardSteps) % 16);
                TextUI.addToLog(chosenMoveCard.getDescription());
            }
            else if(action == GameBoard.END_TURN) {
                TextUI.addToLog(board.getCurrentPlayer() + " har avslutat sin runda.");
                board.nextTurn();
            }
            else if(action == GameBoard.DEFAULT_VIEW) TextUI.printStatus(board);
            else if(action == GameBoard.SHOW_BOARD) TextUI.printBoard(board);
            else if(action == GameBoard.EXIT_GAME) System.exit(0);
    }

    /**
     * Returns a string representation of the MoveSpace
     */
    @Override
    public String toString() {
        return "Riskruta";
    }
}
