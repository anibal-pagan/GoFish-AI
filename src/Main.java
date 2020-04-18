
public class Main {

    public static void main(String[] args){
        // Deck deck = new Deck();
        Player p1 = new Player("p1");

        // deck.giveInitialCards(p1);
        // System.out.println(deck.getDeckSize());
        p1.giveCard(new Card("clubs", 3));
        p1.giveCard(new Card("spades", 3));
        p1.giveCard(new Card("diamonds", 3));
        p1.giveCard(new Card("hearts", 3));
        
    }

}