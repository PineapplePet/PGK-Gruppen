package lthopoly.parser;

import lthopoly.cards.MoneyCard;
import lthopoly.cards.MoveCard;
import lthopoly.spaces.BoardSpace;
import lthopoly.spaces.HouseSpace;
import lthopoly.spaces.MoneySpace;
import lthopoly.spaces.MoveSpace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tank on 4/17/2016.
 */
public class DocumentParser {

    private Scanner scan;



    /**
     * Returns a ArrayList of Boardspaces loaded from a file
     */
    public static ArrayList<BoardSpace> getBoard() {

        ArrayList<BoardSpace> arrayList = new ArrayList<BoardSpace>();
        int i = 0;

        try {
            Scanner scan = new Scanner(new File("board.txt"));

            while (scan.hasNext()) {
                String line = scan.nextLine();
                if (line.split(";")[0].equals("Money")) {
                    arrayList.add(i, new MoneySpace(getMoneyCards()));
                }
                else if (line.split(";")[0].equals("Move")) {
                    arrayList.add(i, new MoveSpace(getMoveCards()));
                }
                else if (line.split(";")[0].equals("House")) {
                    arrayList.add(i, new HouseSpace(Integer.parseInt(line.split(";")[1]), line.split(";")[2]));
                }
                else { System.out.println("DEBUG: ELSE"); }
                i++;
            }
            return arrayList;

        } catch (FileNotFoundException e) {
            System.out.println("EXCEPTION: " + e);
            System.exit(1);

        }
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
        String line;
        while (scan.hasNext()) {
            line = scan.nextLine();
            array.add(i, new MoneyCard(line.split(";")[0], Integer.parseInt(line.split(";")[1])));
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
        String line;
        while (scan.hasNext()) {
            line = scan.nextLine();
            array.add(i, new MoveCard(line.split(";")[0], Integer.parseInt(line.split(";")[1])));
            i++;
        }
        return array.toArray(new MoveCard[]{});

    }
}
