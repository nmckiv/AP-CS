package chapter11;

import java.util.Vector;

public class Player {
	//Class variables
	public int points;
	public double winnings = 0;
	public double bet = 0;
	public String name;
	public int handSize;
	public Vector<Card> hand;
	public static void main(String[] args) {
		
	}
	
	//Default constructor for a player named Joe
	public Player() {
		points = 0;
		name = "Joe";
		handSize = 52;
		hand = new Vector<Card>();
	}
	
	//Specific constructor for a given players name and hand size
	public Player(String playerName, int size) {
		points = 0;
		name = playerName;
		handSize = size;
		hand = new Vector<Card>();
	}
	
	//Getter method for points
	public int getPoints() {
		return points;
	}
	
	//Setter method for points
	public void setPoints(int input) {
		points = input;
	}
	
	//Method to print hand in string format
	public void printHand() {
		for (int x = 0; x < hand.size(); x++) {
			hand.get(x).printCard();
		}
	}
	
	//Method to obtain a card from the hand
//	public Card getCard(int index) {
//		return hand.remove(index);
//	}
	
	public Card getCard(int index) {
		return hand.get(index);
	}
	
	
	
	//Method to add a card to the hand
	public void addCard(Card card) {
		hand.add(card);
	}
}
