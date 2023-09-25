package chapter11;

public class Card {
	private int suit;
	private int value;
	public Card() {
		suit = (int) (Math.random() * 3 + 1);
		value = (int) (Math.random() * 12 + 1);
	}
	public Card(int suitEntered, int valueEntered) {
		suit = suitEntered;
		value = valueEntered;
	}
	
	public int getSuit() {
		return suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int num) {
		value = num;
	}
	
	
	public void printCard() {
		System.out.print(strValue() + " of " + strSuit());
	}
	
	public String strSuit() {
		switch (suit) {
		case 1: return "Hearts  ";
		case 2: return "Diamonds";
		case 3: return "Clubs   ";
		case 4: return "Spades  ";
		}
		return "";
	}
	public int suitLength() {
		return strSuit().length();
	}
	public int valueLength() {
		return strValue().length();
	}
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
		case 15: return "Ace";

		}
		return "";
	}
}
