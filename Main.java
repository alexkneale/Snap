package org.example.SnapProject;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
//        Card myCard = new Card();
//        System.out.println(myCard.getSuit());
//        System.out.println(myCard.getSymbol());
//        System.out.println(myCard.getValue());
//        String cardName = "test1";
//        CardGame myCardGame = new CardGame(cardName);
//        System.out.println(myCardGame.getDeck());
//        System.out.println(myCardGame.shuffleDeck());
//        System.out.println(myCardGame.dealCard());
//        System.out.println(myCardGame.getDeck());
//        System.out.println(myCardGame.sortDeckIntoSuits());
//        System.out.println(myCardGame.sortDeckInNumberOrder());


        Snap mySnap = new Snap("Fun game");
        Scanner ourScanner = new Scanner(System.in);
        System.out.println("Player name 1");
        String name1 = ourScanner.nextLine();
        System.out.println("Player name 2");
        String name2 = ourScanner.nextLine();


        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        mySnap.playGame(player1,player2);




    }
}
