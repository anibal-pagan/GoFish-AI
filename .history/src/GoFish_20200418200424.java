import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GoFish {
    private ArrayList<Player> players; // Integer stores points
    private ArrayList<Integer> points;
    private Deck deck;
    private int turn;
    private boolean gameIsOver = false;

    public GoFish(int numPlayers) {
        if(numPlayers < 3 || numPlayers > 6) {
            System.out.println("Error: Only 3-6 players allowed.");
        }

        players = new ArrayList<>();
        points = new ArrayList<>();
        deck = new Deck();

        Random rand = new Random(); 
        turn = rand.nextInt(numPlayers);
        
        //All players get their cards
        for(int i=0; i<numPlayers; i++) {
            Player newPlayer = new Player("Player " + (i+1));
            deck.giveInitialCards(newPlayer);
            players.add(newPlayer);
            points.add(0);
        }
    }

    public void play() {
        System.out.print("\n");
        Scanner scan = new Scanner(System.in);
        while(!gameIsOver) {
            System.out.println(players.get(turn).getName() + "`s turn!");
            players.get(turn).displayCardsInHand();
            System.out.println("\nWhich player do you want to ask a card from?");
            for(int i=0; i<players.size(); i++) {
                int pNum = i+1;
                if(players.get(i) == players.get(turn)) continue; //Same object reference
                System.out.print("(" + pNum +") " + players.get(i).getName() + "\t");
            }
            System.out.print("\n");
            //Choose Player to take from, handle errors later
            int indexToTakeFrom = scan.nextInt() - 1;

            boolean asking = true;
            while(asking){

            //Choose number to ask
            System.out.println("Which card do you want to ask for? (J = 11, Q = 12, K = 13, A = 1)");
            int numToTake = scan.nextInt();

            //check if player can ask for that card
            if(!players.get(indexToTakeFrom).hasCard(numToTake)){
                System.out.println("You can only ask for cards you have. Try again.");
            }else{
            asking=false;
            }

        }
        }

            //Check if player has card(s) with that number or not
            int cardsGiven = players.get(indexToTakeFrom).giveCards(numToTake, players.get(turn));
            System.out.println("\n");

            if(cardsGiven == 0) {//go fish!
                System.out.println("Go Fish!");
                Card newCard = deck.goFish();
                System.out.println("Card given: " + newCard.toString());
                players.get(turn).giveCard(deck.goFish());
                if(deck.getDeckSize() == 0) gameIsOver = true;
                if(newCard.getNumber() != numToTake) turn = (turn+1) % players.size();
                System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
            }
            if(players.get(turn).cardCount() == 0 || players.get(indexToTakeFrom).cardCount() == 0) {
                gameIsOver = true;
            }
        }
        scan.close();
        int winner = 0;
        for(int i=1; i<points.size(); i++) {
            if(points.get(i) > points.get(winner)) winner = i;
        }
        System.out.println(players.get(winner).getName() + " wins!");
    } 
}