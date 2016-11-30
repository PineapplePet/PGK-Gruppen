package lthopoly.spaces;


import lthopoly.GameBoard;
import lthopoly.Player;

/**
 * Created by Tank on 4/17/2016.
 */
public class HouseSpace extends BoardSpace {
    private int rent;
    private String description;
    private int[] array;
    private Player owner;

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
        return board.getPossibleActions();
    }

    /**
     * Performs a HouseSpace-related action.
     */
    @Override
    public void action(GameBoard board, int action) {
        board.doAction(action);
    }

    /**
     * Returns a string representation of the HouseSpace with the format "HouseName [Owner] (Rent)"
     */
    @Override
    public String toString() {
        return "HouseName: " + this.description + " Owner: " + this.name + " Rent: " + this.rent;
    }

}
