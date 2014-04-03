package blackjack;

/*
 * Object to Represent Hand of Player
 */
public class Hand {
	Card[] cards;
	int top;

	// Init
	public Hand() {
		cards = new Card[52];
		top = 0;
	}
	
	/*
	 * Push Cards into Hand
	 */
	public void addCard(Card c) {
		this.cards[top] = c;
		top += 1;
	}
	
	/*
	 * Returns the Total Values of All the Cards
	 */
	public int GetValue() {
		int value = 0;
		boolean ace = false;
		for (int c = 0; c < top; c++) {
			value += GetRankValue(cards[c].getRank());
			if (cards[c].getRank() == 'A')
				ace = true;
		}
		if (ace && value <= 11)
			value += 10;
		return value;
	}
	
	public int GetDealerValue() {
		int value = 0;
		boolean ace = false;
		for (int c = 1; c < top; c++) {
			value += GetRankValue(cards[c].getRank());
			if (cards[c].getRank() == 'A')
				ace = true;
		}
		if (ace && value <= 11)
			value += 10;
		return value;
	}
	
	/*
	 * Returns true if Player is Busted
	 */
	public boolean isBusted() {
		return GetValue() > 21;
	}

	/*
	 * Get the Value of Specific Rank
	 */
	public int GetRankValue(char rank) {
		for (int i = 0; i < 13; i++) {
			if (Constants.Ranks[i] == rank) {
				return Constants.Values[i];				
			}
		}
		return 0;
	}
}