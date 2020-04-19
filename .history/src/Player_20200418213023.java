import java.util.ArrayList;
import java.util.HashMap;

public class Player {

    private ArrayList<Card> myCards = new ArrayList<>();
    private String name;
    private HashMap<Integer, Integer> myCardCount = new HashMap<>();
    private int myPoints = 0;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void giveCard(Card c){
        myCards.add(c);
        if(myCardCount.containsKey(c.getNumber())){

            myCardCount.put(c.getNumber(), myCardCount.get(c.getNumber())+1);

            if(myCardCount.get(c.getNumber()) == 4){
                myPoints++;
                myCardCount.remove(c.getNumber());

                for(int i=myCards.size()-1; i>= 0; i--){
                    if(myCards.get(i).getNumber() == c.getNumber()) myCards.remove(i);
                }
                System.out.println("Point made! Player "+this.name +" now has a score of "+ myPoints);

            }
        }else{
            myCardCount.put(c.getNumber(),1);
        }
    }

    public void displayCardsInHand() {
        for(int i=0; i<myCards.size(); i++) {
            int num = i+1;
            System.out.println(num + ") "+ myCards.get(i).toString());
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
                cardsGiven++;
            }
        }
        for(Card c : cardsToRemove) {
            myCards.remove(c);
        }
        return cardsGiven;
    }

    public boolean hasCard(int cardNum){
        for(int i=0;i<this.myCards.size();i++){
            System.out.println(cardNum+" == "+ this.myCards.get(i).getNumber());
            if(cardNum==this.myCards.get(i).getNumber())
                return true;
        }
        return false;
    }

    public int cardCount() {
        return myCards.size();
    }

}