package org.example.SnapProject;

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
//        System.out.println(myCardGame.sortDeckIntoSuits());
//        System.out.println(myCardGame.sortDeckInNumberOrder());
        Snap mySnap = new Snap("Fum game");
        Player player1 = new Player("Jeff");
        Player player2 = new Player("John");

        mySnap.playGame(player1,player2);




    }
}
