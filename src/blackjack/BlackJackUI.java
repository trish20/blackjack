/*
 *@athor: Tracia Liang
 */

package blackjack;

import blackjack.Card;
import blackjack.CardUI;
import blackjack.Constants;
import blackjack.DealButtonHandler;
import blackjack.Deck;
import blackjack.Hand;
import blackjack.HitButtonHandler;
import blackjack.StandButtonHandler;
import blackjack.StartOverHandler;
import java.awt.*;
import javax.swing.*;

public class BlackJackUI extends JApplet {
	private static final long serialVersionUID = 1L;
	
        // Button With Label "New Session"
        JButton b;
	// Button With Label "Deal"
	JButton dealButton;
	// Button with label "Hit"
	JButton hitButton;
	// Button with label "Stand"	
	JButton standButton;
	
	// Label showing # of User Wins
	JLabel userWinsLabel;
	// Label Showing # of Dealer Wins
	JLabel dealerWinsLabel;
	// Label showing outcome i.e "You Win" or "You Lose"
	JLabel outcomeLabel;
	
	JLabel userValueLabel;
	JLabel dealerValueLabel;
	
	// GUI Panel to show Player Cards
	JPanel playerCardTbl;
	// GUI Panel to show Opponent (Dealer) Cards
	JPanel dealerCardTbl;
	
	JPanel p1, p2;
	
	Deck deck; // Game Deck
	Hand player; // Player Object
	Hand dealer; // Opponent Object

	boolean isPlaying; //   game is running or ended
	int userScore; // User Score
	int dealerScore; // User Score
	
	// Default Constructor
		public void init() {
		setLayout(new BorderLayout(5, 0));

		// Add New Session Button & Bind Event
	        b = new JButton("New Session");
                b.setVisible(false);
		b.addActionListener(new StartOverHandler(this));
		
		// Add Deal Button & Bind Event
		dealButton = new JButton("Deal");
		dealButton.addActionListener(new DealButtonHandler(this));
		
		// Add Hit Button & Bind Event
		hitButton = new JButton("Hit");
		hitButton.setVisible(false);
		hitButton.addActionListener(new HitButtonHandler(this));
		
		// Add Stand Button & Bind Event
		standButton = new JButton("Stand");
		standButton.setVisible(false);
		standButton.addActionListener(new StandButtonHandler(this));
		
		JPanel controlArea = new JPanel();		// Init Control Area
		controlArea.setBackground(Constants.Background);
		// Add Items Button in Control Area
                controlArea.add(dealButton);
		controlArea.add(hitButton);
		controlArea.add(standButton);
		controlArea.add(b);
		
		add(controlArea, BorderLayout.SOUTH);		// Add Control Area in UI Frame
		
		// Font Use to Display Name i.e "Computer" & "You"
		Font nameFont = new Font("Segoe UI", Font.BOLD, 20);
		//Font used to display other Labels
		Font font = new Font("Segoe UI", Font.PLAIN, 20);
		// Font used to display Info
		Font infoFont = new Font("Calibri", Font.PLAIN, 30);
		
		// Main Panel of Game with Green Background
		JPanel playPanel = new JPanel();
		playPanel.setLayout(new BorderLayout());
		playPanel.setBackground(Constants.Background);
		
		// Top most shown panel
		p1 = new JPanel();
		p1.setBackground(Constants.Background);
		p1.setLayout(new GridLayout(0, 2));
		
		JLabel optName = new JLabel("   Dealer");
		optName.setFont(nameFont);
		optName.setForeground(Color.WHITE);
		p1.add(optName, BorderLayout.NORTH);
		
		// Dealers # of Wins Score Label
		dealerWinsLabel = new JLabel("Wins : 0   ");
		dealerWinsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dealerWinsLabel.setFont(font);
		dealerWinsLabel.setForeground(Color.WHITE);
		p1.add(dealerWinsLabel);
		
		playPanel.add(p1, BorderLayout.NORTH);
		
		// Bottom Visible Panel
		p2 = new JPanel();
		p2.setBackground(Constants.Background);
		p2.setLayout(new GridLayout(0, 2));
		
		JLabel plyrName = new JLabel("    " + "You");
		plyrName.setFont(nameFont);
		plyrName.setForeground(Color.WHITE);
		p2.add(plyrName);
		
		// User Wins Label
		userWinsLabel = new JLabel("Wins : 0    ");
		userWinsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		userWinsLabel.setFont(font);
		userWinsLabel.setForeground(Color.WHITE);
		p2.add(userWinsLabel);
		
		playPanel.add(p2, BorderLayout.SOUTH);
		
		// Play Area
		JPanel cardPanel = new JPanel();
		LayoutManager mgr = new GridLayout(3, 0);
		cardPanel.setLayout(mgr);
		cardPanel.setBackground(Constants.Background);
		
		dealerCardTbl = new JPanel();
		dealerCardTbl.setBackground(Constants.Background);
		cardPanel.add(dealerCardTbl);
		
		// Outcome Label
		JPanel p3 = new JPanel();
		p3.setBackground(Constants.Background);
		p3.setLayout(new BorderLayout());
		
		Font valueFont = new Font("Segoe UI", Font.PLAIN, 16);
		
		userValueLabel = new JLabel("Cards Total Value: 0");
		userValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userValueLabel.setForeground(Color.WHITE);
		userValueLabel.setFont(valueFont);
		p3.add(userValueLabel, BorderLayout.SOUTH);
		
		dealerValueLabel = new JLabel("Cards Total Value: 0");
		dealerValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dealerValueLabel.setForeground(Color.WHITE);
		dealerValueLabel.setFont(valueFont);
		p3.add(dealerValueLabel, BorderLayout.NORTH);
		
		outcomeLabel = new JLabel("Hit Deal Button to Continue");
		outcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outcomeLabel.setFont(infoFont);
		outcomeLabel.setForeground(Color.WHITE);
		
		p3.add(outcomeLabel, BorderLayout.CENTER);
		
		cardPanel.add(p3);
		
		playerCardTbl = new JPanel();
		playerCardTbl.setBackground(Constants.Background);
		cardPanel.add(playerCardTbl);
		
		playPanel.add(cardPanel, BorderLayout.CENTER);

		add(playPanel, BorderLayout.CENTER);

		DoStartOver();
	}
	
	/*
	 * Update the Outcome Text in 'outcomeLabel'
	 */
	void UpdateOutcome(String o) {
              if (o == Constants.winMessage || o == Constants.dealerBustMessage){
                  outcomeLabel.setForeground(Color.BLUE);
              }    
	      if (o == Constants.lostMessage || o == Constants.bustLostMessage || o == Constants.bustMessage){
                  outcomeLabel.setForeground(Color.RED);
              } 
		outcomeLabel.setText(o);
                outcomeLabel.setForeground(Color.WHITE);
	}
	
	/*
	 * Update Score Text in 'scorLabel'
	 */
	void UpdateScore(String status) {
		if (status == "Reset"){
                        userScore = 0;
                        dealerScore = 0;
			userWinsLabel.setText(String.format("Wins : " + String.valueOf(userScore)) + "    ");
			dealerWinsLabel.setText(String.format("Wins : " + String.valueOf(dealerScore) + "    "));
                }
                if (status == "Won") {
			userScore = userScore + 1;
			userWinsLabel.setText(String.format("Wins : " + String.valueOf(userScore)) + "    ");
		}
                if (status == "Lost") {
			dealerScore = dealerScore + 1;
			dealerWinsLabel.setText(String.format("Wins : " + String.valueOf(dealerScore) + "    "));
		}
	}
	
	/*
	 * Helper function to get Path of ImageIcon for specific Card
	 */
	String getCardPath(Card c) {
		return "/images/" + String.valueOf(c.getSuit())  + "/" + String.valueOf(c.getRank()) + ".gif";
	}
	
	/*
	 * Helper function to update the play state and perform action
	 * according to the state;
	 */
	void UpdatePlayState(boolean v) {

		isPlaying = v;
		
		// If firstCard is null then this leads to Crash.
		// Most Important Handle It
		if (firstCard == null) return;
		if (isPlaying) {
			// If Is Playing then Hide the First Card of Opponent
			firstCard.HideCard();
			dealButton.setVisible(false);
			
			hitButton.setVisible(true);
			standButton.setVisible(true);
                        b.setVisible(true);
		} else {
			// Else Show the Opponent First Card
			firstCard.ShowCard();
			dealerValueLabel.setText("Carda Total Value: " +  String.valueOf(dealer.GetValue()));
			dealButton.setVisible(true);
			b.setVisible(true);
			hitButton.setVisible(false);
			standButton.setVisible(false);
		}
	}
	
	// To Hold Reference to first Card of Opponent
	// As JPanel.countComponent() is depreciated
	CardUI firstCard = null;
	
	/*
	 * Helper function to Push one card from Deck to Opponent Hand
	 */
	void UpdateDealerCard() {
		Card c = deck.Deal();
		dealerCardTbl.add(new CardUI(getCardPath(c)));
		
		// Most Important
		// If not repainted then some times new cards can't appears
		dealerCardTbl.updateUI();
		dealerCardTbl.repaint();
		dealer.addCard(c);
		
		dealerValueLabel.setText("Cards Total Value: " + String.valueOf(dealer.GetDealerValue()) + "+");
	}
	
	/*
	 * Helper function to Push one card from Deck to Player Hand
	 */
	void UpdatePlayerCard() {
		Card c = deck.Deal();
		CardUI cardUI = new CardUI(getCardPath(c));
		cardUI.setHorizontalAlignment(SwingConstants.LEFT);
		playerCardTbl.add(cardUI);
		playerCardTbl.updateUI();
		playerCardTbl.repaint();
		player.addCard(c);
		
		userValueLabel.setText("Cards Total Value: " + String.valueOf(player.GetValue()));
	}
	
	/*
	 * Helper function to Empty Components of JPanel
	 */
	void EmptyPanel(JPanel p) {
		p.removeAll();
		p.repaint(); // Most Important
	}
	
	/*
	 * Deal:
	 *  -   Clears the current hand, if any.
	 *  -	Shuffles the Deck
	 *  -	Deals Two Cards to hand of Dealer & Player
	 * 
	 * 
	 * DoDeal will be called by the Deal Button Click Event Listener
	 */
	public void DoDeal() {
		SetNewGame(true);
		
		if (isPlaying) {
			// If Player is previously playing game then Update Outcome 
			UpdateOutcome(Constants.lostMessage);
			if (player != null)
				UpdateScore("Lost");
		} else {
			// Important: Empty the Outcome
			UpdateOutcome("");
		}
		
		// Empty the UI Tables
		EmptyPanel(dealerCardTbl);
		EmptyPanel(playerCardTbl);
		
		// Creates the new Deck if it is null
		if (deck == null)
			deck = new Deck();
		// Shuffles the Cards
		deck.Shuffle();
		
		// Create New Player Object
		player = new Hand();
		UpdatePlayerCard();
		UpdatePlayerCard();

		// Create New Opponent Object
		dealer = new Hand();
		UpdateDealerCard(); 
		UpdateDealerCard();
		// Important: Init the firstCard too
		firstCard = (CardUI)dealerCardTbl.getComponent(0);
		
		// Set Playing State to true
		UpdatePlayState(true);
	}
	
	/*
	 * Push one more card from Deck to Player Hand
	 * DoHit will be called by the Event Listener
	 * of Button with label "Hit"
	 */
	public void DoHit() {
		if (isPlaying) {
			UpdatePlayerCard();

			// if Player is busted the Show Outcome
			if (player.isBusted()) {
				UpdateOutcome(Constants.bustLostMessage);				
				UpdateScore("Lost");
				UpdatePlayState(false);
			}
		}
	}
	
	/*
	 * Dealer Repeatedly hits until hand has value 17 or more
	 * 
	 * DoStand will be called by the event listener of Button
	 * with label "Stand"
	 */
	public void DoStand() {
		if (isPlaying) {
			// if hand is in play, repeatedly hit dealer until his hand has value 17 or more
			while (dealer.GetValue() < 17) {
				UpdateDealerCard();
			}
			
			//assign a message to outcome, update in_play and score
			if (player.isBusted()) {
				// Player busted
				UpdateOutcome(Constants.bustMessage);
			} else {
				if (dealer.isBusted()) {
					// Opponent Busted
					UpdateOutcome(Constants.dealerBustMessage);
					UpdateScore("Won");
				} else if (dealer.GetValue() < player.GetValue()) {
					// Player Wins..!
					UpdateOutcome(Constants.winMessage);
					UpdateScore("Won");
				} else {
					// Player Lost
					UpdateOutcome(Constants.lostMessage);
					UpdateScore("Lost");
				}
			}

			UpdatePlayState(false);
		}
	}

	// Starts new game
	void DoStartOver() {
		UpdatePlayState(false);
		UpdateOutcome("Hit Deal Button to Continue");
                b.setVisible(false);
                dealerScore = 0;
		userScore = 0;
		
		UpdateScore("Reset");
		UpdateScore("Reset");
                
		EmptyPanel(dealerCardTbl);
		EmptyPanel(playerCardTbl);
		
		SetNewGame(false);
	}
	
	// Sets Game Controls On/Off
	void SetNewGame(boolean v) {
		p1.setVisible(v);
		p2.setVisible(v);
		
		userValueLabel.setVisible(v);
		dealerValueLabel.setVisible(v);
	}
}