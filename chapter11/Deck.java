package chapter11;

import java.util.Vector;


public class Deck {
	Vector<Card> cards;//Uses a vector of cards to represent a deck
	public static void main(String[] args) {
		
	}
	
	//Default constructor for one 52 card deck
	public Deck() {
		cards = new Vector<Card>();
		for (int suit = 1; suit < 5; suit++) {
			for (int value = 1; value < 14; value++) {
				Card oneCard = new Card(suit, value);
				cards.add(oneCard);
			}
		}
	}
	
	//Specific constructor for a big deck consisting of a specified number of 52 card decks
	public Deck(int num) {
		cards = new Vector<Card>();
		for (int x = 0; x < num; x++) {
			for (int suit = 1; suit < 5; suit++) {
				for (int value = 1; value < 14; value++) {
					Card oneCard = new Card(suit, value);
					cards.add(oneCard);
				}
			}
		}
	}
	
	//Method to add a card to the deck
	public void addCard(Card card) {
		cards.add(card);
	}
	
	//Method to draw a card from the top of the deck
	public Card drawTop() {
		return cards.remove(0);
	}
	
	//Method to shuffle the deck
	public void shuffle() {
		int index1;
		int index2;
		int deckNum;
		Card temp;
			for (int x = 0; x < cards.size(); x++) {
				index1 = (int) (Math.random() * cards.size());
				index2 = (int) (Math.random() * cards.size());
				temp = cards.get(index1);
				cards.set(index1, cards.get(index2));
				cards.set(index2, temp);
			}		
	}
	
	//Method to print out the entire deck
	public void printDeck() {
		for (int x = 0; x < cards.size(); x++) {
			System.out.print(x + 1 + ". ");
			cards.get(x).printCard();
		}
	}
}
