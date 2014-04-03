package blackjack;

import blackjack.BlackJackUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Action Listener for Stand Button
 */
public class StandButtonHandler implements ActionListener {
	
	BlackJackUI ui;
	public StandButtonHandler(BlackJackUI ui) {
		this.ui = ui;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Calls the DoStand of main UI
		ui.DoStand();
	}
}