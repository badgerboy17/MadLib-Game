package edu.uwp.csci242.assignment.a04.madlib;
import java.util.*;

/**
 * Created by brycesulin on 4/1/17.
 * MadLib program uses ArrayBags to implement a MadLib word game
 * <p>
 * A Vacation MadLib is implemented with different types of ArrayBags
 * <p>
 *
 * @author brycesulin
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 4
 * @bugs none
 */
public class MadLib {
    /**
     * Main class has 5 steps:
     * 1. Declares and instantiates the word ArrayBags.
     * 2. Prints a header so the user knows what game is being played.
     * 3. Prompts the user for space separated lists of words that are placed in the corresponding ArrayBag.
     * 4. Prints the title of the Mad Lib.
     * 5. Prints the story of the Mad Lib using the ArrayBags to choose the missing words.
     */
    public static void main(String[] args) {
        ArrayBag bag = new ArrayBag<>();
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("--------");
        System.out.println("MAD LIBS");
        System.out.println("--------");
        System.out.println();

        System.out.println("Please type in 3 adjectives, separated by spaces.");
        System.out.println("Press the <return> key after the final entry.");
        ArrayBag<String> adjectivesBag = new ArrayBag<>();
        String adjectives = input.nextLine();
        String[] adjecParts = adjectives.split(" ");
        adjectivesBag.addMany(adjecParts);
        System.out.println();

        System.out.println("Please type in 3 nouns, separated by spaces.");
        System.out.println("Press the <return> key after the final entry.");
        ArrayBag<String> nounBag = new ArrayBag<>();
        String nouns = input.nextLine();
        String[] nounParts = nouns.split(" ");
        nounBag.addMany(nounParts);
        System.out.println();

        System.out.println("Please type in 4 plural nouns, separated by spaces.");
        System.out.println("Press the <return> key after the final entry.");
        ArrayBag<String> pluralNounBag = new ArrayBag<>();
        String pluralNouns = input.nextLine();
        String[] pluralNounParts = pluralNouns.split(" ");
        pluralNounBag.addMany(pluralNounParts);
        System.out.println();

        System.out.println("Please type in 1 game, separated by spaces.");
        System.out.println("Press the <return> key after the final entry.");
        ArrayBag<String> gameBag = new ArrayBag<>();
        String game = input.nextLine();
        gameBag.add(game);
        System.out.println();

        System.out.println("Please type in 4 verbs ending in 'ing', separated by spaces.");
        System.out.println("Press the <return> key after the final entry.");
        ArrayBag<String> verbBag = new ArrayBag<>();
        String verbs = input.nextLine();
        String[] verbParts = verbs.split(" ");
        verbBag.addMany(verbParts);
        System.out.println();

        System.out.println("Please type in 1 plant, separated by spaces.");
        System.out.println("Press the <return> key after the final entry.");
        ArrayBag<String> plantBag = new ArrayBag<>();
        String plant = input.nextLine();
        plantBag.add(plant);
        System.out.println();

        System.out.println("Please type in 1 body part, separated by spaces.");
        System.out.println("Press the <return> key after the final entry.");
        ArrayBag<String> bodyBag = new ArrayBag<>();
        String body = input.nextLine();
        bodyBag.add(body);
        System.out.println();

        System.out.println("Please type in 1 place, separated by spaces.");
        System.out.println("Press the <return> key after the final entry.");
        ArrayBag<String> placeBag = new ArrayBag<>();
        String place = input.nextLine();
        placeBag.add(place);
        System.out.println();

        System.out.println("Please type in 1 number, separated by spaces.");
        System.out.println("Press the <return> key after the final entry.");
        ArrayBag<Integer> numberBag = new ArrayBag<>();
        numberBag.add(input.nextInt());
        System.out.println();

        System.out.println("-- VACATION --");
        System.out.println();

        System.out.println("A vacation is when you take a trip to some " + adjectivesBag.grab() + " place");
        System.out.println("with your " + adjectivesBag.grab() + " family. Usually you go to some place");
        System.out.println("that is near a/an " + nounBag.grab() + " or up on a/an " + nounBag.grab() + ".");
        System.out.println("A good vacation place is one where you can ride " + pluralNounBag.grab());
        System.out.println("or play " + gameBag.grab() + " or go hunting for " + pluralNounBag.grab() + ". I like");
        System.out.println("to spend my time " + verbBag.grab() + " or " + verbBag.grab() + ".");
        System.out.println("When parents go on a vacation, they spend their time eating");
        System.out.println("three " + pluralNounBag.grab() + " a day, and fathers play golf, and mothers");
        System.out.println("sit around " + verbBag.grab() + ". Last summer, my little brother");
        System.out.println("fell in a/an " + nounBag.grab() + " and got poison " + plantBag.grab() + " all");
        System.out.println("over his " + bodyBag.grab() + ". My family is going to (the)");
        System.out.println(placeBag.grab() + ", and I will practice " + verbBag.grab() + ". Parents");
        System.out.println("need vacations more than kids because parents are always very");
        System.out.println(adjectivesBag.grab() + " and because they have to work " + numberBag.grab());
        System.out.println("hours every day all year making enough " + pluralNounBag.grab() + " to pay");
        System.out.println("for the vacation.");
        System.out.println();
    }
}