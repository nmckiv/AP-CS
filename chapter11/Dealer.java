package chapter11;

import java.util.Vector;

public class Dealer extends Player {//Dealer is a subclass of player
	//Class data fields
	public int total;
	public Deck deck;//Dealer gets a deck to deal from
	public int handSize;
	public Vector<Card> hand = new Vector<Card>();
	public static void main(String[] args) {
	}
	//Default constructor for one deck and handsize of 52
	public Dealer() {
		name = "House";
		deck = new Deck();
		deck.shuffle();
		total = 0;
		handSize = 52;
	}
	//Specific constructor for a given hand size and number of decks
	public Dealer(int handSizeEntered, int numOfDecks) {
		name = "House";
		deck = new Deck(numOfDecks);
		deck.shuffle();
		total = 0;
		handSize = handSizeEntered;
	}
	
	//method to deal top card of deck
	public Card dealCard() {
		return deck.drawTop();
	}
	
	//Method to return card to a random place in the deck
	public void returnCard(Card card) {
		deck.cards.add((int) (Math.random() * deck.cards.size()), card);
	}
}
