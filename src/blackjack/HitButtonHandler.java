package blackjack;

import blackjack.BlackJackUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Action Listener for Hit Button
 */
public class HitButtonHandler implements ActionListener {
	BlackJackUI ui;
	public HitButtonHandler(BlackJackUI ui) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Calls the DoHit event of Game
		ui.DoHit();
	}
}