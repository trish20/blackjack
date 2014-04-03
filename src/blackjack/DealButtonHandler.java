package blackjack;

import blackjack.BlackJackUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Deal Button Click Event Listener
 */
public class DealButtonHandler implements ActionListener {
	
	BlackJackUI ui;
	public DealButtonHandler(BlackJackUI ui ) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Calls the Deal Method of Main UI Object
		ui.DoDeal();
	}
}