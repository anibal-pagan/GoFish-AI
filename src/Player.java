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

}