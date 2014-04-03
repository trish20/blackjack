package blackjack;


/*
 * Card Object
 * 	- Holds Suit and Rank of card
 */
public class Card {
	private char rank, suit;
	
	/*
	 * Default Constructor to Init Object with Suit & Rank
	 */
	public Card(char suit, char rank)
	{
		this.suit = suit;
		this.rank = rank;
	}
	
	/*
	 * Get the Suit of the Card Instance 
	 */
	public char getSuit() {
		return suit;
	}
	
	/*
	 * Get the Rank of the Card Instance
	 */
	public char getRank() {
		return rank;
	}
}