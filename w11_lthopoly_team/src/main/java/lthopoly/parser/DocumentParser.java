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
        Scanner scan = null;
        ArrayList<MoneyCard> array = new ArrayList<MoneyCard>();
        int i = 0;

        try {
            scan = new Scanner(new File("moneycards.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("EXCEPTION: " + e);
        }

        //kollar om det finns en till rad
        //lägger till nytt MoneyCard i arrayList som görs om till Array
        while (scan.hasNext()) {
            array.add(i, new MoneyCard(scan.nextLine().split(";")[0], Integer.parseInt(scan.nextLine().split(";")[1])));
            i++;
        }
        return array.toArray(new MoneyCard[]{});
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

        while (scan.hasNext()) {
            array.add(i, new MoveCard(scan.nextLine().split(";")[0], Integer.parseInt(scan.nextLine().split(";")[1])));
            i++;
        }
        return array.toArray(new MoveCard[]{});

    }
}
