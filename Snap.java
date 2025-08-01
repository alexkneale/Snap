package org.example.SnapProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;


public class Snap extends CardGame {
    public Snap(String name) {
        super(name);
    }

    //method for playing game, without players (only one "player", in terminal)
    public void playGame() {

        // shuffle cards
        shuffleDeck();
        // scanner for user interacting via terminal
        Scanner ourScanner = new Scanner(System.in);

        // boolean for while loop
        boolean gamePlaying = true;


        // output first card to user
        System.out.println("First Card");
        Card previousCard = dealCard();
        System.out.println(previousCard);

        // until there's a snap
        while (gamePlaying) {
            // get new card

            ourScanner.nextLine();
            Card currentCard = dealCard();
            System.out.println(currentCard);

            // check if value of last two cards was the same
            if (currentCard.getValue()== previousCard.getValue()) {
                System.out.println("Snap");
                ourScanner.close();
                gamePlaying = false;
            }
            // update previous card value
            previousCard = currentCard;


            // check that we haven't gotten through deck
            if (getDeck().size() == 0) {
                System.out.println("Out of cards! New Game!");
                newDeck();

            }

        }

    }
    public void playGame(Player player1, Player player2) {

        // shuffle cards
        shuffleDeck();
        // scanner for user interacting via terminal
        Scanner ourScanner = new Scanner(System.in);

        // boolean for while loop
        boolean gamePlaying = true;

        // list of players, to switch between names in while loop
        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(player1, player2));
        // round counter, for player switching
        int countRounds = 0;
        System.out.println("First card");

        Player currentPlayer = players.get(countRounds%2);

        // output first card to user
        Card previousCard = dealCard();
        System.out.println(previousCard);

        // until there's a winner
        while (gamePlaying) {
            // switch current player, displaying name
            currentPlayer = players.get(countRounds%2);
            System.out.println(currentPlayer.getNameUser() + " turn");


            // get new card
            ourScanner.nextLine();
            Card currentCard = dealCard();
            System.out.println(currentCard);

            // check if value of last two cards was the same
            if (currentCard.getValue()== previousCard.getValue()) {

                Scanner snapScanner = new Scanner(System.in);
                // create a single-thread executor to run the input task in a separate thread
                ExecutorService executor = Executors.newSingleThreadExecutor();

                System.out.println(currentPlayer.getNameUser() + " type snap quickly!");

                // define a task (a Callable) that waits for user input
                // this returns a Callable object whose call() method just returns whatever the user types
                Callable<String> inputTask = () -> snapScanner.nextLine();

                // submit the task to the executor for background execution
                // Future represents the pending result of the input task (like a placeholder)
                Future<String> future = executor.submit(inputTask);

                try {
                    // try to get the result of the task within 2 seconds
                    String input = future.get(2, TimeUnit.SECONDS);
                    // only win if user types snap
                    if (input.equals("snap")) {
                        System.out.println(currentPlayer.getNameUser()+" wins!");
                        gamePlaying = false;

                    } else {
                        System.out.println(currentPlayer.getNameUser()+" didn't say snap!");
                    }

                } catch (TimeoutException e) {
                    // if 2 seconds pass with no input, this block runs
                    System.out.println("Too late! " +currentPlayer.getNameUser()+" didn't type anything in time.");

                    // cancel the task since we don't need it anymore
                    future.cancel(true);
                } catch (Exception e) {
                    // catch any other exceptions (e.g., InterruptedException, ExecutionException)
                    System.out.println("Error: " + e.getMessage());


                }

                // shut down the executor and stop its thread
                executor.shutdownNow();
                // clear leftover newline from input buffer
                if (ourScanner.hasNextLine()) {
                    ourScanner.nextLine();
                }
            }
            // update previous card value
            previousCard = currentCard;
            countRounds += 1;


            // check that we haven't gotten through deck
            if (getDeck().size() == 0) {
                System.out.println("Out of cards! New Game!");
                newDeck();
            }

        }
    }

}
