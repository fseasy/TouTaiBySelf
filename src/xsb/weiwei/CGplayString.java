package xsb.weiwei;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CGplayString extends JPanel implements Runnable {
	private final int FONT_SIZE = 28;
	private String text;
	private String tempText;
	private Thread paintText;
	int x = 550;
	int y = 25;
	Random random;
	int sleepTimes;

	public CGplayString(String text) {
		this.text = text;
		tempText = "";
		setOpaque(false);
		paintText = new Thread(this);
		random = new Random();
		sleepTimes = 300 - random.nextInt(100);
		paintText.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < text.length(); i++) {
			tempText = text.substring(0, i + 1);
			repaint();
			setVisible(true);
			try {
				Thread.sleep(sleepTimes);

			} catch (Exception e) {

			}
		}
		try{
			Thread.sleep(2000) ; 
		}catch(Exception e){
			
		}
		setVisible(false) ; 
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		sleepTimes = 300 - random.nextInt(200);
		x = 550;
		y = 25;
		g2.setFont(new Font("¿¬Ìå", Font.PLAIN, FONT_SIZE));
		for (int i = 0; i < tempText.length(); i++) {
			g2.setColor(Color.BLACK);
			g2.drawString(tempText.substring(i, i + 1), x, y);
			g2.setColor(Color.WHITE);
			g2.drawString(tempText.substring(i, i + 1), x + 1, y + 1);
			g2.setColor(Color.RED);
			g2.drawString(tempText.substring(i, i + 1), x - 1, y - 1);
			y += (FONT_SIZE + 2);
			if (text.charAt(i) == ' ' || text.charAt(i) == '£¡' || y >= 530) {
				x -= (FONT_SIZE + 15);
				y = 25;
			}
		}
	}

}
