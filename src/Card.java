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
        return this.number;
    }

    @Override
    public boolean equals(Object obj) {
        Card c = (Card) obj;
        return (this.getSuit().equals(c.getSuit()) && this.getNumber() == c.getNumber());
    }

    @Override
    public String toString(){
        char num;
        switch(number) {
            case 11:
                num = 'J';
                break;
            case 12:
                num = 'Q';
                break;
            case 13:
                num = 'K';
                break;
            case 1:
                num = 'A';
                break;
            default:
                num = (char) number; //this doesn't work
        }
        if(number > 10) return suit + " " + num;
        else   return suit + " " + number;
    }

}
