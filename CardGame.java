package org.example.SnapProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private ArrayList<Card> deckOfCards = new ArrayList<Card>();
    private String name;


    // constructors

    public CardGame(String name) {
        this.name = name;
        for (Suit suit: Suit.values()) {
            for (Rank rank : Rank.values()) {
                deckOfCards.add(new Card(suit,rank));
            }
        }
    }

    // function to create a brand new shuffled deck
    public void newDeck() {
        for (Suit suit: Suit.values()) {
            for (Rank rank : Rank.values()) {
                deckOfCards.add(new Card(suit,rank));
            }
        }
        shuffleDeck();
    }
    // get deck method, which lists out all cards in the deck
    public ArrayList<Card> getDeck() {

        return deckOfCards;
    }

    // name of card game
    public String getName() {
        return name;
    }

    // method to return and remove top card in deck
    public Card dealCard() {
        Card removedCard = deckOfCards.remove(0);
        return removedCard;
    }

    // method to sort deck in number order
    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(deckOfCards, Comparator.comparingInt(Card::getValue));
        return deckOfCards;
    }
    // method to sort deck in suit order, then value order
    public ArrayList<Card> sortDeckIntoSuits() {
        deckOfCards.sort(
                Comparator.comparing(Card::getSuit)
                        .thenComparing(Card::getValue)
        );
        return deckOfCards;
    }
    // method to randomly shuffle deck of cards
    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }













}
