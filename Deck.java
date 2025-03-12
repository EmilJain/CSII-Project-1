import java.util.Random;

public class Deck {
    // This is a class variable so we don't have to create
    // a new Random object every time we call randomInt.
    private static Random random = new Random();

    private Card[] cards;

    /**
     * Constructs a standard deck of 52 cards.
     */
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

    /**
     * Constructs a deck of n cards (all null).
     */
    public Deck(int n) {

        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.cards.length; i++) {
            str.append(this.cards[i]);
            str.append('\n');
        }
        return str.toString();
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
        for (int i = 0; i < this.cards.length; i++) {
            int rand = randomInt(i, this.cards.length - 1);
            swapCards(i, rand);
        }
    }

    /**
     * Chooses a random number between low and high, including both.
     */
    private static int randomInt(int low, int high) {
        int range = high - low + 1;
        return low + random.nextInt(range);
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    private void swapCards(int i, int j){
            Card temp = this.cards[i];
            this.cards[i] = this.cards[j];
            this.cards[j] = temp;
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
        for (int i=0;i<cards.length-1;i++){
            swapCards(i, indexLowest(i, cards.length - 1));
        }
    }

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    private int indexLowest(int low, int high) {
        int min = low;
        for (int i = low; i <= high; i++) {
            if (this.cards[i].compareTo(this.cards[min]) < 0) {
                min = i;
            }

        }
        return min;
    }



    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    private static Deck merge(Deck d1, Deck d2) {
        Card[] card1 = d1.getCards();
        Card[] card2 = d2.getCards();
        int l1 = card1.length;
        int l2 = card2.length;

        // Create a new array to store the merged cards
        Card[] sorted = new Card[l1 + l2];

        int i = 0; // Index for c1
        int j = 0; // Index for c2
        for (int k = 0; k < sorted.length; k++) {
            if (j >= card2.length || (i < card1.length && card1[i].compareTo(card2[j]) <= 0)) {
                sorted[k] = card1[i];
                i++;
            } else {
                sorted[k] = card2[j];
                j++;
            }
        }

        // Create a new deck with the sorted cards
        Deck deck = new Deck(l1 + l2);
        System.arraycopy(sorted, 0, deck.cards, 0, sorted.length);
        return deck;
    }

    /**
     * Returns a sorted copy of the deck using selection sort.
     */
    public Deck almostMergeSort() {
        int len = cards.length;

        // if the deck is empty or has only one card, it's already sorted
        if (len == 0 || len == 1) {
            return this;
        }

        // Step 1: Split the deck into two halves
        int mid = len / 2;
        Deck d1 = subdeck(0, mid - 1);
        Deck d2 = subdeck(mid, len - 1);

        // Step 2: Sort each half using selectionSort
        d1.selectionSort();
        d2.selectionSort();

        // Step 3: Merge the two sorted halves
        return merge(d1, d2);
    }
    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        int len = cards.length;
        if (len == 0 || len == 1){
            return this;
        }
        else {
            int mid = len / 2;
            Deck d1 = subdeck(0, mid - 1).mergeSort();
            Deck d2 = subdeck(mid, len -1).mergeSort();
            return merge(d1, d2);
        }
    }
   
}
