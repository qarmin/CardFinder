import java.awt.Color;

public class Threader extends Thread {
	
	public static final int DISABLE_BUTTONS = 0;
	public static final int ENABLE_BUTTONS = 1;
	public static final int CLEAR_PAIR = 2;
	
	public int currentTask = -1;
	
	public float timeToCount = 0f;
		
	public void run() {
		if(currentTask == DISABLE_BUTTONS) {
			Block.setButtonDisabled(true);
			while(true) {
				timeToCount -= 0.1;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(timeToCount <= 0f) {
					Block.setButtonDisabled(false);
					break;
				}
			}
		}
		else if(currentTask == ENABLE_BUTTONS){
			Block.setButtonDisabled(false);
		}
		else if(currentTask == CLEAR_PAIR){
			Block.setButtonDisabled(true);
			
			while(true) {
				timeToCount -= 0.1;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(timeToCount <= 0f) {
					Block.setButtonDisabled(false);
					GameGUI.cardButtons[Pair.x1][Pair.y1].setBackground(Color.decode("#cccccc"));
					GameGUI.cardButtons[Pair.x1][Pair.y1].setIcon(null);
					GameGUI.cardButtons[Pair.x2][Pair.y2].setBackground(Color.decode("#cccccc"));
					GameGUI.cardButtons[Pair.x2][Pair.y2].setIcon(null);
					
					Pair.resetPair();
					
					break;
				}
			}
		}
	}
}
