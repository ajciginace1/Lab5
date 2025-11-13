/**
 * Lab 5 Tile
 * @author Ben Kaw
 * @since 11/13/2025
 */

public class Tile {
    private char letter;
    private int value;

    /**
     * Constructor for Tile class
     * @param letter
     * @param value
     */

    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public Tile(Tile obj) {
        this.letter = obj.letter;
        this.value = obj.value;
    }

    /**
     * Sets the value of the object's letter with the char passed in the argument
     * @param letter
     */

    public void setLetter(char letter) {
        this.letter = letter;
    }
    /**
     * Sets the value of the object's score with the int passed in the argument
     * @param value
     */

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the letter of the tile
     * @return letter
     */

    public char getLetter() {
        return this.letter;
    }

    /**
     * Gets the value of the tile
     * @return value
     */

    public int getValue() {
        return this.value;
    }

    /**
     * Sees if both tiles are the same
     * @param other
     * @return boolean
     */

    public boolean equals(Tile other) {
        return this.letter == other.letter;
    }
    
    /**
     * toString method
     * @return String
     */

    public String toString() {
        return String.format("%c - %d", letter, value);
    }
}
