package lthopoly.parser;

import com.sun.xml.internal.ws.api.model.ExceptionType;
import lthopoly.cards.MoneyCard;
import lthopoly.cards.MoveCard;
import lthopoly.spaces.BoardSpace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tank on 4/17/2016.
 */
public class DocumentParser {



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

        File f;

        try{
            f = new File(DocumentParser.class.getResource("/movecards.txt").getFile());

            try{
                Scanner scan = new Scanner(f);

                for (int i = 0; i < scan.; i++){

                }













            }
            catch (FileNotFoundException e) {System.out.println(e); }


        }catch(NullPointerException e){System.out.println(e);}














        return null;
    }
        // Använda detta? ->
    //


}
