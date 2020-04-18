public class Card {

    private String suit;
    private int number = -1;

    //11 para J, 12 para Q, 13 para K, 1 para A
    public Card(String suit, int number){
        this.suit = suit;
        this.number = number;
    }

    public String getSuit(){
        return this.suit;
    }

    public int getNumber(){
        return this.getNumber();
    }

    public void printCard(){
        System.out.println(suit + " "+ number);
    }

}
