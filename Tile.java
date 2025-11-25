/**
 * Lab 5 Tile
 * @author Edisson Ajciginac
 * @since 11/13/2025
 */

public class Tile {
    private char letter;
    private int value;

    /**
     * Constructor for Tile class
     * @param letter the letter on the tile
     * @param value  the point value of the tile
     */
    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

 
    public Tile(Tile other) {
        this.letter = other.letter;
        this.value = other.value;
    }

    /**
     * Getter for letter
     * @return the letter on this tile
     */
    public char getLetter() {
        return letter;
    }

    /**
     * Setter for letter
     * @param letter the new letter
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * Getter for value
     * @return the point value of this tile
     */
    public int getValue() {
        return value;
    }

    /**
     * Setter for value
     * @param value the new point value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Compares this tile to another tile based on the letter
     * @param other another Tile
     * @return true if the letters are the same
     */
    public boolean equals(Tile other) {
        return this.letter == other.letter;
    }
    
    /**
     * Returns a string representation of this tile
     * @return String with letter and value
     */
    public String toString() {
        return String.format("%c (value = %d)", letter, value);
    }
}
