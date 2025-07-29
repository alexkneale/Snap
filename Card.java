package org.example.SnapProject;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
    //fields
    private final Suit suit;
    private final Rank rank;

    public Card() {
        this(Suit.CLUBS, Rank.TWO);
    }
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return this.suit.getSymbol();
    }

    public String getSymbol() {
        return this.rank.getSymbol();
    }

    public int getValue() {
        return this.rank.getValue();
    }

    @Override
    public String toString() {
        return rank.getSymbol() + suit.getSymbol();
    }}
