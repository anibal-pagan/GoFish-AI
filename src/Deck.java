import java.util.ArrayList;

public class Deck {

    private String[] suits = {"clubs", "spades", "hearts", "diamonds"};
    private ArrayList<Card> deck; 

    public Deck(){
        deck = new ArrayList<>();
        createDeck();
    }

    private void createDeck(){

        for(int i=1; i<14; i++){

            Card c1 = new Card(suits[0], i);
            Card c2 = new Card(suits[1], i);
            Card c3 = new Card(suits[2], i);      
            Card c4 = new Card(suits[3], i);  
            
            deck.add(c1);
            deck.add(c2);
            deck.add(c3);
            deck.add(c4);

            c1.printCard();
            c2.printCard();
            c3.printCard();
            c4.printCard();
        }
    }

}