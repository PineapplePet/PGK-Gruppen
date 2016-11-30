package lthopoly;

/**
 * Created by Tank on 4/17/2016.
 */
public class Player {
    private String name;
    private int money;
    private int pos;

    /**
     * Creates a new player
     */
    public Player(String name, int money, int pos) {
        this.name = name;
        this.money = money;
        this.pos = pos;
    }

    /**
     * Returns the players money
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Adjusts the players money
     */
    public void adjustMoney(int money) {
        this.money = money;
    }

    /**
     * Returns the players position
     */
    public int getPosition() {
        return this.pos;
    }

    /**
     * Returns a string representation of the player
     */
    @Override
    public String toString() {
        return "Name: " + this.name + " Money: " + this.money + " Position: " + this.pos;
    }

    /**
     * Sets the players position
     */
    public void setPosition(int pos) {
        this.pos = pos;
    }
}
