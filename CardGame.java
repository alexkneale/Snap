package org.example.SnapProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    private ArrayList<Card> deckOfCards = new ArrayList<Card>();
    private String name;

    private ArrayList<String> suitArr = new ArrayList<String>(Arrays.asList("U+2665","U+2660","U+2666","U+2663"));
    private ArrayList<String> symbolArr = new ArrayList<String>(Arrays.asList("2","3","4","5","6","7","8","9","10","J","Q","K","A"));
    private ArrayList<Integer> valueArr = new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,8,9,10,11,12,13,14));



    // constructors

    public CardGame(String name) {
        this.name = name;
        for (String suit:suitArr) {
            for (int i = 0; i < symbolArr.size(); i++) {
                deckOfCards.add(new Card(suit,symbolArr.get(i),i+2));
            }
        }
    }
    // get deck method, which lists out all cards in the deck
    public ArrayList<Card> getDeck() {

        return deckOfCards;
    }
    public String getName() {
        return name;
    }

    public Card dealCard() {
        Card removedCard = deckOfCards.remove(0);
        return removedCard;
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(deckOfCards, Comparator.comparingInt(Card::getValue));
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        deckOfCards.sort(
                Comparator.comparing(Card::getSuit)
                        .thenComparing(Card::getValue)
        );
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }













}
