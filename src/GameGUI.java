import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameGUI {

	public static int width = 4;

	public static int height = 4;

	private static JFrame gameFrame = new JFrame("Card Finder");

	private static Panel cardPanel = new Panel();

	public static Block[][] cardButtons;

	public static void main(String[] args) {
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(800, 800);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setVisible(true);

		cardButtons = new Block[width][height];

		cardPanel.setLayout(new GridLayout(width, height));

		int[] array = new int[width * height];
		Random rand = new Random();

		for (int i = 0; i < width * height; i++) {
			array[i] = -1;
		}

		for (int i = 0; i < width * height; i++) {
			boolean found = false;
			int index = -1;
			while (found == false) {
				index = rand.nextInt(width * height);
				if (array[index] == -1) {
					array[index] = i / 2 + 1;
					found = true;
				}
			}
		}


		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				cardButtons[i][j] = new Block(i, j, array[height * i + j]);

				cardPanel.add(cardButtons[i][j]);
			}
		}
		gameFrame.add(cardPanel);

		gameFrame.setVisible(true);
	}

}
