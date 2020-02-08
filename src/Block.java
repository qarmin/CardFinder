import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Block extends JButton implements MouseListener {

	public static String imageResolution = "128";

	public static boolean buttonsDisabled = false;

	private static final long serialVersionUID = 210760075974214695L;

	public int currentContent;

	public boolean showed = false;

	public int fx, fy;

	public Block(int x, int y, int cur) {

		fx = x;
		fy = y;

		currentContent = cur;
		// setIcon(new ImageIcon("img/"+ imageResolution + "/" + cur + ".png"));
		setBackground(Color.decode("#cccccc"));// Color.DARK_GRAY);
		addMouseListener(this);
	}

	public static synchronized void setButtonDisabled(boolean value) {
		buttonsDisabled = value;
	}

	public static synchronized boolean getButtonDisabled() {
		return buttonsDisabled;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (!buttonsDisabled && !showed) {
			if (e.getButton() == MouseEvent.BUTTON1) { // left click

				if (Pair.x1 == fx && Pair.y1 == fy) { // Przycisk został przyciśnięty dwukrotnie
					return;
				}

				setIcon(new ImageIcon("img/" + imageResolution + "/" + currentContent + ".png"));

				if (Pair.x1 == -1) { // pierwszy
					Pair.x1 = fx;
					Pair.y1 = fy;
				} else {
					if (GameGUI.cardButtons[Pair.x1][Pair.y1].currentContent == currentContent) { // Wykryta para
						showed = true;
						GameGUI.cardButtons[Pair.x1][Pair.y1].showed = true;
						GameGUI.cardButtons[Pair.x1][Pair.y1].setBackground(Color.decode("#888888"));
						setBackground(Color.decode("#888888"));
						Pair.resetPair();
					} else { // Błędna para

						GameGUI.cardButtons[Pair.x1][Pair.y1].setBackground(Color.decode("#ff0000"));
						setBackground(Color.decode("#ff0000"));
						Pair.x2 = fx;
						Pair.y2 = fy;
						Threader tt = new Threader();
						tt.timeToCount = 0.5f;
						tt.currentTask = Threader.CLEAR_PAIR;
						tt.start();
						return;
					}

				}

			}
		}
	}

}
