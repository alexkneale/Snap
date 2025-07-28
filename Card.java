package org.example.SnapProject;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
    //fields
    private String suit;
    private String symbol;
    private int value;

    // list of potential suits, symbols and values
    private ArrayList<String> suitArr = new ArrayList<String>(Arrays.asList("U+2665","U+2660","U+2666","U+2663"));
    private ArrayList<String> symbolArr = new ArrayList<String>(Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","K","A"));
    private ArrayList<Integer> valueArr = new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14));

    public Card() {
        this("U+2665", "2",2);
    }
    public Card(String suit, String symbol, int value) {
        if (suitArr.contains(suit)) this.suit = unicodeStringToSymbol(suit);
        else throw new IllegalArgumentException("Invalid Suit");

        if (symbolArr.contains(symbol)) this.symbol = symbol;
        else throw new IllegalArgumentException("Invalid Symbol");

        if (valueArr.contains(value)) this.value = value;
        else throw new IllegalArgumentException("Invalid Value");

    }

    // for converting string of unicode, to actual symbol

    private String unicodeStringToSymbol(String unicode) {
        // Remove "U+" and parse as hex
        int codePoint = Integer.parseInt(unicode.substring(2), 16);
        return new String(Character.toChars(codePoint));
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {

        if (suitArr.contains(suit))
            this.suit = suit;
        else throw new IllegalArgumentException("Invalid Suit");
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        if (symbolArr.contains(symbol)) this.suit = suit;
        else throw new IllegalArgumentException("Invalid Symbol");
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (valueArr.contains(value)) this.value = value;
        else throw new IllegalArgumentException("Invalid Value");
    }

    public String toString() {
        return "Suit = "+suit+" Symbol = "+symbol+" value= "+value;
    }
}
