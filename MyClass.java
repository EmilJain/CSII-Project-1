public class MyClass {
    public static void main(String args[]) {
        Card[] cards = Search.makeDeck();

        // Create a deck of cards
        Card[] deck = Card.makeDeck();

        System.out.println("shuffled deck:");
        Deck shuffleDeck = new Deck();
        shuffleDeck.shuffle();
        shuffleDeck.print();

        System.out.println("\ninsertion sort: ");
        shuffleDeck.insertionSort();
        shuffleDeck.print();

        System.out.println("\nbubble sort: ");
        shuffleDeck.shuffle();
        shuffleDeck.insertionSort();
        shuffleDeck.print();
    }
}
