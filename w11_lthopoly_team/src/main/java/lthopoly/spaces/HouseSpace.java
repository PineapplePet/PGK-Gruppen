package lthopoly.spaces;


import lthopoly.GameBoard;
import lthopoly.Player;



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
             return new int[] {GameBoard.BUY_PROPERTY};
         }
         else if (owner != null && owner != board.getCurrentPlayer()) {
             return new int[] {GameBoard.PAY_RENT};
         }
         else return new int[] {};
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
                System.out.println("Ca-ching! " + owner + " äger nu " + board.getCurrentBoardSpace().toString() + " och är " + rent + "kr fattigare!!!");
            } else {
                System.out.println("Du har för lite pengar");
            }
        }
        if (action == GameBoard.PAY_RENT) {
            board.getCurrentPlayer().adjustMoney(-rent);
            owner.adjustMoney(rent);
            System.out.println(board.getCurrentPlayer() + " betalade " + rent + "kr i hyra till " + owner);
        }
    }

    /**
     * Returns a string representation of the HouseSpace with the format "HouseName [Owner] (Rent)"
     */
    @Override
    public String toString() {
        return "HouseName: " + this.description + " Owner: " + this.owner.getName() + " Rent: " + this.rent;
    }

}
