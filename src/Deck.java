import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private final String[] suits = { "clubs", "spades", "hearts", "diamonds" };
    private final ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        createDeck();
    }

    private void createDeck() {

        for (int i = 1; i < 14; i++) {

            final Card c1 = new Card(suits[0], i);
            final Card c2 = new Card(suits[1], i);
            final Card c3 = new Card(suits[2], i);
            final Card c4 = new Card(suits[3], i);

            deck.add(c1);
            deck.add(c2);
            deck.add(c3);
            deck.add(c4);
        }
    }

    public int getDeckSize(){
        return deck.size();
    }

    private Card getRandomCard(){
        Random rand = new Random(); 
        int index = rand.nextInt(deck.size()-1);
        Card card = deck.get(index);
        deck.remove(index);
        return card;
    }

    public Card goFish() {
        return getRandomCard();
    }

    public void giveInitialCards(Player player){
        for(int i=0; i<5; i++){
            Card c= getRandomCard();
            player.giveCard(c);
        }
    }


}