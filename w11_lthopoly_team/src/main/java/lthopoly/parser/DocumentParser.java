package lthopoly.parser;

import lthopoly.cards.MoneyCard;
import lthopoly.cards.MoveCard;
import lthopoly.spaces.BoardSpace;

import java.io.File;
import java.io.FileNotFoundException;
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

         Scanner scan = null;
        ArrayList<MoveCard> array = new ArrayList<MoveCard>();
        int i = 0;

        try {
            scan = new Scanner(new File("movecards.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("EXCEPTION: " + e);
        }

        while (scan.hasNext()) {                                                                   //kollar om det finns en till rad
            array.add(i, new MoveCard(scan.nextLine().split(";")[0], Integer.parseInt(scan.nextLine().split(";")[1]))); //lägger till nytt MoveCard i array
            i++;
        }
        return array.toArray(new MoveCard[]{});

    }


}
