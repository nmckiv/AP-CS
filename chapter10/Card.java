package chapter10;

public class Card {
	
	//Data fields representing the card suit and value
	private int suit;
	private int value;
	
	//Default constructor
	public Card() {
		//Randomly assigns a suit and value
		suit = (int) (Math.random() * 3 + 1);
		value = (int) (Math.random() * 12 + 1);
	}
	
	//Specified constructor to make a card of a given suit and value
	public Card(int suitEntered, int valueEntered) {
		suit = suitEntered;
		value = valueEntered;
	}
	
	//Getter methods for suit and value
	public int getSuit() {
		return suit;
	}
	public int getValue() {
		return value;
	}
	
	//Method to return a string corresponding the the value of suit
	public String strSuit() {
		switch (suit) {
		case 1: return "Hearts";
		case 2: return "Diamonds";
		case 3: return "Clubs";
		case 4: return "Spades";
		}
		return "";
	}
	
	//Method to return a string corresponding the the value of value
	public String strValue() {
		switch (value) {
		case 1: return "Ace";
		case 2: return "Two";
		case 3: return "Three";
		case 4: return "Four";
		case 5: return "Five";
		case 6: return "Six";
		case 7: return "Seven";
		case 8: return "Eight";
		case 9: return "Nine";
		case 10: return "Ten";
		case 11: return "Jack";
		case 12: return "Queen";
		case 13: return "King";

		}
		return "";
	}
}
