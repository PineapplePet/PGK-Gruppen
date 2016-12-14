package lthopoly;

import chord.textui;
import lthopoly.spaces.BoardSpace;
import lthopoly.spaces.HouseSpace;
import lthopoly.spaces.MoneySpace;
import lthopoly.spaces.MoveSpace;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tank on 4/17/2016.
 */
public class GameBoard {

    /**
     * Menu constants
     */
    public static final int THROW_DICE = 0;
    public static final int DRAW_CARD = 1;
    public static final int BUY_PROPERTY = 2;
    public static final int PAY_RENT = 3;
    public static final int END_TURN = 4;
    public static final int DEFAULT_VIEW = 5;
    public static final int SHOW_BOARD = 6;
    public static final int EXIT_GAME = 7;




    private int[] intArray = new int[] {THROW_DICE, DRAW_CARD, BUY_PROPERTY, PAY_RENT, END_TURN, DEFAULT_VIEW, SHOW_BOARD, EXIT_GAME};

    /**
     * Attributes
     */
    private ArrayList<BoardSpace> spaces;
    private List<Player> players;
    private int turn = 0;
    private boolean gameOver = false;
    private ArrayList<Integer> stats = new ArrayList();

    /**
     * Creates a new board ready to play
     */


    public void nextTurn() {
        if (turn < players.size() - 1)
        {
            turn = turn + 1;
        }
        else {
            turn = 0;
        }
    }



    public GameBoard(List<Player> players, ArrayList<BoardSpace> spaces) {
        this.players = players;
        this.spaces = spaces;
    }

    /**
     * Returns an int array containing possible game actions.
     * A game action can be any of the static constants in
     * GameBoard
     */
    public int[] getPossibleActions() {
        return getCurrentBoardSpace().getPossibleActions(this);
    }

    /**
     * Checks whether the game is over or not
     */
    public boolean isGameOver() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getMoney() < 0) {
                gameOver = true;
            }
        }
        return gameOver;
    }

    /**
     * Returns the player with the most money
     */
    public Player getRichestPlayer() {

        int bigCash = 0;
        int currentVonAnka = 0;

        for(int i = 0; i<players.size();i++) {
            if (players.get(i).getMoney()>bigCash) {
                bigCash = players.get(i).getMoney();
                currentVonAnka = i;
            }
        }
        return players.get(currentVonAnka);
    }

    /**
     * Returns a list of all players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Returns a list of all BoardSpaces
     */
    public List<BoardSpace> getBoardSpaces() { return spaces; }

    /**
     * Performs an action for the current player
     */
    public void doAction(int action) {
        getCurrentBoardSpace().action(this, action);
    }

    /**
     * Returns the currently active player
     */
    public Player getCurrentPlayer() {
        return players.get(turn);
    }

    /**
     * Returns the boardspace corresponding to the position of the current player.
     */
    public BoardSpace getCurrentBoardSpace() {
        return spaces.get(getCurrentPlayer().getPosition());
    }

    /**
     * Returns an ArrayList<Integer> where each element contains the total sum of all players' money
     * at the end of a round.
     * E.g. list.get(0) is the total amount of money in the game after the first round.
     */
    public ArrayList<Integer> getStatistics() {
        return stats;
    }
    public void addStatistic(int money) {
        stats.add(stats.size(), money);
    }

    /**
     * String Representation of the GameBoard
     */
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Rutans Namn [Ägare] (Pris/Hyra) (Spelare, Pengar)*\n");
        out.append("--------------------------------------------------\n");
        for (int i = 0; i < spaces.size(); i++) {

            out.append(spaces.get(i).toString() + " ");

            for (int j = 0; j < players.size(); j++)
                if (players.get(j).getPosition() == i)
                    out.append("(" + players.get(j).toString() + "," + players.get(j).getMoney() + ")");//add name to row

            out.append("\n");
        }
        return out.toString();
    }
}
