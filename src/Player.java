import java.util.ArrayList;

public class Player {

    private ArrayList<Card> myCards = new ArrayList<>();
    private String name;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void giveCard(Card c){
        myCards.add(c);
    }

    public void displayCardsInHand() {
        for(int i=0; i<myCards.size(); i++) {
            int num = i+1;
            System.out.println(num + ") "+ myCards.toString());
        }
    }

    //Returns number of cards given
    public int giveCards(int cardNum, Player p) {
        int cardsGiven = 0;
        ArrayList<Card> cardsToRemove = new ArrayList<>();
        for(Card c : myCards) {
            if (c.getNumber() == cardNum) {
                cardsToRemove.add(c);
                p.giveCard(c);
            }
        }
        for(Card c : cardsToRemove) {
            myCards.remove(c);
        }
        return cardsGiven;
    }

}