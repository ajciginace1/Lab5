/**
 * Lab 5 Scrabble
 * @author Ben Kaw
 * @since 11/13/2025
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static ArrayList<Tile> tiles; //whole set of tiles
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Scrabble!");
        Scanner input = new Scanner(System.in);
        createAllTiles();
        ArrayList<Tile> hand = get7Tiles();
        for (int i=0; i < hand.size(); i++) { //printing hand of 7 tiles
            System.out.print(hand.get(i).getLetter());
        }
        System.out.println();
        System.out.println("What word can you spell with these tiles?");
        String word = input.nextLine();
        word = word.toUpperCase();
        for (int i=0; i < word.length(); i++) {
            for (int j=0; j < hand.size(); j++)
                if (word.charAt(i) == hand.get(j).getLetter()) {
                    System.out.printf("%c is in the string. \n", word.charAt(i));
                }
        }
        input.close();
    }

    /**
     * Alphabet of tiles
     */

    public static void createAllTiles() {
        tiles = new ArrayList<Tile>();
        tiles.add(new Tile('A', 1));
        tiles.add(new Tile('B',3));
        tiles.add(new Tile('C',3));
        tiles.add(new Tile('D',2));
        tiles.add(new Tile('E',1));
        tiles.add(new Tile('F',4));
        tiles.add(new Tile('G',2));
        tiles.add(new Tile('H',4));
        tiles.add(new Tile('I',1));
        tiles.add(new Tile('J',8));
        tiles.add(new Tile('K',5));
        tiles.add(new Tile('L',1));
        tiles.add(new Tile('M',3));
        tiles.add(new Tile('N',1));
        tiles.add(new Tile('O',1));
        tiles.add(new Tile('P',3));
        tiles.add(new Tile('Q',10));
        tiles.add(new Tile('R',1));
        tiles.add(new Tile('S',1));
        tiles.add(new Tile('T',1));
        tiles.add(new Tile('U',1));
        tiles.add(new Tile('V',4));
        tiles.add(new Tile('W',4));
        tiles.add(new Tile('X',8));
        tiles.add(new Tile('Y',4));
        tiles.add(new Tile('Z',10));

    }

    /**
     * Initialize hand
     * @return setOf7Tiles
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
}
