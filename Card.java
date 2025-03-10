public class Card {
    public static final String[] RANKS = {
            null, "Ace", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King"};

    public static final String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"};

    private final int rank;

    private final int suit;


    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card[] makeDeck() {
        Card[] cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }

    public static int[] suitHist(Card[] cards) {
        int[] result = new int[4]; // create new array
        for (int i = 0; i < cards.length; i++) {
            result[cards[i].getSuit()] += 1; // populate it suit by suit
        }
        return result;
    }

    public static boolean hasFlush(Card[] cards) {
        int[] suitCounts = suitHist(cards);
        for (int i = 0; i < suitCounts.length; i++) {
            if (suitCounts[i] >= 5) { //checking if there are 5 or more cards of a suit
                return true;
            }
        }
        return false;
    }

    public static boolean hasRoyalFlush(Card[] cards){
        if(!hasFlush(cards)){
            return false;
        }
        int[] suitCounts = suitHist(cards);
        int flushSuit = -1; // -1 b/c has not found the flush suit yet

        for(int i = 0; i < 4; i++){
            if(suitCounts[i] >=5){ //finding a suit with 5 or more cards
                flushSuit = i;
                break; //I looked up online how to use this on. the java website
            }
        }

        boolean[] hasRank = new boolean[14]; //array to keep track of card ranks

        for(int i = 0; i< cards.length; i++){
            if(cards[i].getSuit() == flushSuit){
                hasRank[cards[i].getRank()] = true; //checking which cards are in the suit
            }
        }
        return hasRank[1] && hasRank[10] && hasRank[11] && hasRank[12] && hasRank[13];
    }



    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank == 1 && that.rank != 1) { // if it is an ace than over ride
            return 1;
        }
        if (that.rank == 1 && this.rank != 1) {
            return -1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }


    public boolean equals(Card that) {
        return this.rank == that.rank
                && this.suit == that.suit;
    }


    public int getRank() {
        return this.rank;
    }


    public int getSuit() {
        return this.suit;
    }


    public int position() {
        return this.suit * 13 + this.rank - 1;
    }


    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }
}
