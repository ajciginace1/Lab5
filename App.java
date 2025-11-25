/**
 * Lab 5 Scrabble
 * Implements a simple Scrabble-like game using Tiles and ArrayLists.
 * The program generates a random hand of 7 tiles, asks the user for a word,
 * checks if it can be spelled with the hand, and if so calculates the score.
 * Used tiles are then replaced with new random tiles. The game repeats
 * until the user decides to quit.
 *
 * @author Edisson Ajciginac
 * @since 11/13/2025
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    /** Holds the whole set of tiles A–Z with Scrabble values. */
    private static ArrayList<Tile> tiles;

    /**
     * Main method – runs the Scrabble game loop.
     * @param args command-line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to Scrabble!");
        Scanner input = new Scanner(System.in);

        // create full set of tiles A–Z
        createAllTiles();

        // initial hand of 7 tiles
        ArrayList<Tile> hand = get7Tiles();

        boolean keepPlaying = true;

        while (keepPlaying) {

            // show current hand
            System.out.print("Here is your tile set: ");
            System.out.println(getLettersAsString(hand));

            // ask user for a word
            System.out.print("Enter a word: ");
            String word = input.nextLine().trim().toUpperCase();

            if (word.length() == 0) {
                System.out.println("No word entered.");
            } else {
                boolean[] used = new boolean[hand.size()];
                boolean canSpell = canSpellWord(word, hand, used);

                if (canSpell) {
                    int score = getScore(hand, used);
                    System.out.println("yes, can spell " + word.toLowerCase());
                    System.out.println("Score for " + word.toLowerCase() + " = " + score);

                    // replace used tiles with new random tiles
                    replaceUsedTiles(hand, used);
                } else {
                    System.out.println("no, cannot spell " + word.toLowerCase());
                }
            }

            // ask if user wants to continue
            System.out.print("Do you want to continue? ");
            String answer = input.nextLine().trim().toLowerCase();
            if (!answer.equals("yes") && !answer.equals("y")) {
                keepPlaying = false;
                System.out.println("Goodbye!");
            }
        }

        input.close();
    }

    /**
     * Creates the full set of tiles A–Z with Scrabble letter values.
     * Values are taken from the Scrabble letter distribution.
     */
    public static void createAllTiles() {
        tiles = new ArrayList<Tile>();

        tiles.add(new Tile('A', 1));
        tiles.add(new Tile('B', 3));
        tiles.add(new Tile('C', 3));
        tiles.add(new Tile('D', 2));
        tiles.add(new Tile('E', 1));
        tiles.add(new Tile('F', 4));
        tiles.add(new Tile('G', 2));
        tiles.add(new Tile('H', 4));
        tiles.add(new Tile('I', 1));
        tiles.add(new Tile('J', 8));
        tiles.add(new Tile('K', 5));
        tiles.add(new Tile('L', 1));
        tiles.add(new Tile('M', 3));
        tiles.add(new Tile('N', 1));
        tiles.add(new Tile('O', 1));
        tiles.add(new Tile('P', 3));
        tiles.add(new Tile('Q', 10));
        tiles.add(new Tile('R', 1));
        tiles.add(new Tile('S', 1));
        tiles.add(new Tile('T', 1));
        tiles.add(new Tile('U', 1));
        tiles.add(new Tile('V', 4));
        tiles.add(new Tile('W', 4));
        tiles.add(new Tile('X', 8));
        tiles.add(new Tile('Y', 4));
        tiles.add(new Tile('Z', 10));
    }

    /**
     * Initializes a hand of 7 random tiles.
     * @return a new ArrayList containing 7 randomly chosen tiles
     */
    public static ArrayList<Tile> get7Tiles() {
        Random rand = new Random();
        ArrayList<Tile> setOf7Tiles = new ArrayList<Tile>();

        for (int i = 0; i < 7; i++) {
            int randomTileNumber = rand.nextInt(26);
            setOf7Tiles.add(new Tile(tiles.get(randomTileNumber)));
        }

        return setOf7Tiles;
    }

    /**
     * Returns the letters in the hand as a single String,
     * for example "quijibo".
     * @param hand list of tiles in the current hand
     * @return String with all the letters
     */
    public static String getLettersAsString(ArrayList<Tile> hand) {
        StringBuilder sb = new StringBuilder();
        for (Tile t : hand) {
            sb.append(t.getLetter());
        }
        return sb.toString().toLowerCase();
    }

    /**
     * Checks if the given word can be spelled with the tiles in hand.
     * Each tile can only be used once.
     * @param word the word the user entered
     * @param hand the current hand of tiles
     * @param used array to mark which tiles are used
     * @return true if the word can be spelled, false otherwise
     */
    public static boolean canSpellWord(String word, ArrayList<Tile> hand, boolean[] used) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean found = false;

            for (int j = 0; j < hand.size(); j++) {
                if (!used[j] && hand.get(j).getLetter() == c) {
                    used[j] = true;
                    found = true;
                    break;
                }
            }

            if (!found) {
                // could not find a matching tile for this character
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the score of the word based on the tiles that were used.
     * @param hand the current hand of tiles
     * @param used boolean array indicating which tiles were used
     * @return total score for the word
     */
    public static int getScore(ArrayList<Tile> hand, boolean[] used) {
        int score = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (used[i]) {
                score += hand.get(i).getValue();
            }
        }
        return score;
    }

    /**
     * Replaces all used tiles in the hand with new random tiles from the full set.
     * @param hand the current hand
     * @param used boolean array indicating which tiles were used
     */
    public static void replaceUsedTiles(ArrayList<Tile> hand, boolean[] used) {
        Random rand = new Random();
        for (int i = 0; i < hand.size(); i++) {
            if (used[i]) {
                int randomTileNumber = rand.nextInt(26);
                hand.set(i, new Tile(tiles.get(randomTileNumber)));
            }
        }
    }
}
/**
 * Represents a single Scrabble tile with a letter and a point value.
 */