package lthopoly.parser;

import lthopoly.cards.MoneyCard;
import lthopoly.cards.MoveCard;
import lthopoly.spaces.BoardSpace;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tank on 4/17/2016.
 */
public class DocumentParser {

    private Scanner scan;
    File f = new File(DocumentParser.class.getResource("/movecards.txt").getFile());

    /**
     * Returns a ArrayList of Boardspaces loaded from a file
     */
    public static ArrayList<BoardSpace> getBoard() {
        return null;
    }


    /**
     * Returns a array of MoneyCards loaded from file
     */
    public static MoneyCard[] getMoneyCards() {
        return null;
    }

    /**
     * Returns a array of MoveCards loaded from file
     */
    public static MoveCard[] getMoveCards() {

        Scanner scan = new Scanner(f);


        for (int i = 0; i < f.getLines; i++){

        }



        return null;
    }
        // Använda detta? ->
    //


}
