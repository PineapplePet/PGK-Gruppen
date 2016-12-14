package lthopoly.spaces;


import lthopoly.GameBoard;
import lthopoly.Player;
import lthopoly.TextUI;


/**
 * Created by Tank on 4/17/2016.
 */
public class HouseSpace extends BoardSpace {
    private int rent;
    private String description;
    private Player owner = null;

    /**
     * Creates a new housespace with rent and a description
     */
    public HouseSpace(int rent, String description) {
        this.rent = rent;
        this.description = description;
    }

    /**
     * Returns an array of possible game actions permitted by this space
     */
    @Override
    public int[] getPossibleActions(GameBoard board) {
         if (owner == null) {
             return new int[] {GameBoard.BUY_PROPERTY, GameBoard.END_TURN, GameBoard.DEFAULT_VIEW, GameBoard.SHOW_BOARD, GameBoard.EXIT_GAME};
         }
         else if (owner != board.getCurrentPlayer()) {
             action(board, GameBoard.PAY_RENT);
             return new int[] {GameBoard.END_TURN, GameBoard.DEFAULT_VIEW, GameBoard.SHOW_BOARD, GameBoard.EXIT_GAME};
         }
         else return new int[] {GameBoard.END_TURN, GameBoard.DEFAULT_VIEW, GameBoard.SHOW_BOARD, GameBoard.EXIT_GAME};
    }

    /**
     * Performs a HouseSpace-related action.
     */
    @Override
    public void action(GameBoard board, int action) {
        if (action == GameBoard.BUY_PROPERTY) {
            owner = board.getCurrentPlayer();
            if (owner.getMoney() >= rent) {
                owner.adjustMoney(-rent);
                TextUI.addToLog(" Ca-ching! " + owner + " äger nu " + board.getCurrentBoardSpace().toString() + " och är " + rent + "kr fattigare!!!");
                System.out.println(" " + board.getCurrentPlayer() + " har nu " + board.getCurrentPlayer().getMoney() + " kr.");
            } else {
                TextUI.addToLog(" Du har för lite pengar.");
            }
        }
        else if(action == GameBoard.END_TURN) {
            TextUI.addToLog(board.getCurrentPlayer() + " har avslutat sin runda.");
            board.nextTurn();
        }
        else if(action == GameBoard.DEFAULT_VIEW) TextUI.printStatus(board);
        else if(action == GameBoard.SHOW_BOARD) TextUI.printBoard(board);
        else if(action == GameBoard.EXIT_GAME) System.exit(1337);

        if (action == GameBoard.PAY_RENT) {
            board.getCurrentPlayer().adjustMoney(-rent);
            owner.adjustMoney(rent);
            TextUI.addToLog(" " + board.getCurrentPlayer() + " betalade " + rent + "kr i hyra till " + owner);
        }
    }

    /**
     * Returns a string representation of the HouseSpace with the format "HouseName [Owner] (Rent)"
     */
    @Override
    public String toString() {
        String oWner;
        if (this.owner != null) oWner = "[" + this.owner.getName() + "]";
        else oWner = "";
        return this.description + oWner + "(" + this.rent + ")";
    }
}
