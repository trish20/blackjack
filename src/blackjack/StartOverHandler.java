package blackjack;

import blackjack.BlackJackUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartOverHandler implements ActionListener {

	BlackJackUI ui;
	public StartOverHandler(BlackJackUI ui ) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Calls the Deal Method of Main UI Object
		ui.DoStartOver();
	}
}
