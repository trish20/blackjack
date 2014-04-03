package blackjack;

import java.awt.Color;


/*
 * Class to Hold Global Objects as Static Members
 */
public class Constants {
	// Array of Suits of Cards
	public static char[] Suits = new char[] {'C', 'S', 'H', 'D'};
	
	// Array of Ranks of Cards
	public static char[] Ranks = new char[] {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
	
	// Array of Values of Cards Correspond to Ranks Array
	public static int[] Values = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	

	// Message to Show When User Wins
	public static String winMessage = "You Win...!";
	// Message to Show When User Lost
	public static String lostMessage = "You Lost...!";
	// Message to Show When User Busts and Lost
	public static String bustLostMessage = "You're Busted...You Lost";
	// Message to Show when User Busts
	public static String bustMessage = "You're Busted";
	// Message to Show when Opponent Busts
	public static String dealerBustMessage = "Dealer's Busted...You Win";
	
	// Background Color
	public static Color Background = new Color(16, 149, 60);
}