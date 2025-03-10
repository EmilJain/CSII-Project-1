import java.util.Random;

public class Deck {

    private Card[] cards;
    private static final Random random = new Random();

    public Deck(int n) {
        this.cards = new Card[n];
    }

    public Card[] getCards() {
        return this.cards;
    }

    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    public String toString(){
        String result = "";
        for(Card card:this.cards){
            result += card.toString() + "";
        }
        return "TODO";
    }

    private static int randomInt(int low, int high){
        return random.nextInt(high - low) + low;
    }

    private void swapCards(int i, int j){
        Card temp = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = temp;
    }

    //shuffle cards
    public void shuffle(){
        for(int i = 0; i<this.cards.length; i++){
            //choose a random number between the letter i and length-1
            int rand = randomInt(i, cards.length);
            //swap the ith card and the randomly chosen card
            swapCards(i,rand);
        }
    }

    public void selectionSort() {
       for(int index = 0; index < cards.length; index++){
           //find the lowest card at or to the right of i
           int lowest = indexLowest(index, cards.length-1);
           //swap the ith card and the lowest card found
           if(index != lowest){
               swapCards(lowest,index);
           }
       }
    }

    //find the index of the lowest card between low and high inclusive
    private int indexLowest(int low, int high){
        int min = low;
        //where is cards? --> private class variable
        for(int i = low; i <= high; i++){
            if(this.cards[i].compareTo(this.cards[min]) < 0) {
                min = i;
            }
        }
        return min;
        //find the lowest card between low and high
    }
    private static Deck merge(Deck deck1, Deck deck2){
        Deck d3 = new Deck(d1.length+d2.length); //so d3 is big enough for all the cards

        //use the index i to keep track of where we're at in the first deck, and index j is for secodn deck
        int i = 0;
        int j = 0;

        for(int k = 0; k < d3.length; k++){
            //if d1 is empty, use top card from d2
            //if d1 is empty, use top card from d2
            //otherwise, compare the top two cards

            //add lowest card to the new deck at k
            //increment i or j (depending on card)
        }
    }

    public Deck almostMergeSort(){

    }

    public Deck mergeSort(){
        Deck d = new Deck();
        //if the deck has 0 or 1 cards, return it
        if(d.length == 0 || d.length==1) return d;
        //otherwise, divide the deck into two subdecks (subDeck())
        if(d.length > 1) subDeck();
        //sort the subdecks using mergesort (mergeSort())
        //merge the subdecks
        //return the result
    }

} //end class deck
