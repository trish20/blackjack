package blackjack;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/*
 * Visual Representation of Card
 * 
 * Remarks:
 * Render Card Image as ImageIcon and Only GIF
 * Image is Supported.
 */
public class CardUI extends JLabel {
	private static final long serialVersionUID = 2L;
	
	String path;
	public CardUI(String path) {
		this.path = path;
		ImageIcon ico = new ImageIcon(CardUI.class.getResource(path));
		setIcon(ico);		
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
	}
	
	/*
	 * Change the Display Image to Card Back image
	 * 
	 * Remarks:
	 * We Require it to Hide First Card of Opponent. Instead of Deleting
	 * and Inserting new CardUI It's better to update existing
	 */
	public void HideCard() {
		setIcon(new ImageIcon(CardUI.class.getResource("/images/back.gif")));
	}
	
	/*
	 * Revert the original Image of card 
	 */
	public void ShowCard() {
		setIcon(new ImageIcon(CardUI.class.getResource(path)));
	}
}