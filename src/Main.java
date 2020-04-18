
public class Main {

    public static void main(String[] args){
        Deck deck = new Deck();
        Player p1 = new Player("p1");

        deck.giveInitialCards(p1);
        System.out.println(deck.getDeckSize());
    }

}