package idata1002;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> myCards = new ArrayList<>();
    boolean flush;

    String[] face = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final char[] suit = {'C', 'S', 'D', 'H'};

    public Deck() {
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < face.length; j++) {
                this.deck.add(new Card(suit[i], face[j]));
            }
        }
    }

    public void fillDeck() {
        deck.clear();
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < face.length; j++) {
                this.deck.add(new Card(suit[i], face[j]));
            }
        }
    }

/*
Pulls n ammount of cards from the deck randomly and adds them to a list. WIll then check if those cards
is a flush using streams.
 */
    public void pullCards(int n) {
        Random rand = new Random();
        myCards.clear();
        for (int i = 0; i < n; i++) {
            Card card = deck.remove(rand.nextInt(deck.size() - 1));
            myCards.add(card);
            ObservableList<Card> cardsObs = FXCollections.observableArrayList();
            cardsObs.addAll(myCards);

        }

        long largestNumberOfSameSuit = myCards
                .stream()
                .map((Card card) -> card.getSuit())
                .collect(Collectors.groupingBy((Character c) -> c.charValue(),Collectors.counting()))
                .values()
                .stream()
                .reduce((Long largestNumber, Long nextNumber)
                        ->Math.max(largestNumber,nextNumber))
                .get();
        //System.out.println("Largest number of same suit: " + largestNumberOfSameSuit);
        if (largestNumberOfSameSuit >= 5) {
            boolean flush = true;

        }
        else {
            boolean flush = false;
        }
        System.out.println(myCards);

        deck.clear();
        fillDeck();

    }
}



