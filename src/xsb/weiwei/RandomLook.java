package xsb.weiwei;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.*;
import java.io.IOException;
import java.util.Random;

public class RandomLook extends PicJPanel {
	private PicJPanel bacground;
	private PicJPanel[] avatar;
	private int apparence;
	private PicJPanel randomCursor;
	private Thread runRandomCursor;
	private static int[] picture = { 1, 2, 3, 5, 8, 7, 6, 4 };
	JLabel des;
	private String sex ; 
	private String apparenceResult ; 

	public RandomLook(final String sex) {
		super("images/opaque.png");
		this.sex = sex ; 
		bacground = new PicJPanel("images/chargesBac.png");
		avatar = new PicJPanel[8];
		if (sex == "男的") {
			for (int i = 0; i < 8; i++)
				avatar[i] = new PicJPanel("images/avatar/m" + (i + 1) + ".png");
		} else {
			for (int i = 0; i < 8; i++) {
				avatar[i] = new PicJPanel("images/avatar/g" + (i + 1) + ".jpg");
			}
		}
		setLayout(null);
		randomCursor = new PicJPanel("images/randomCursor.png");
		JPanel upPanel = new JPanel();
		add(upPanel);
		upPanel.setBounds(50, 0, 500, 500);
		upPanel.setOpaque(false);
		upPanel.add(randomCursor);
		add(bacground);
		bacground.setBounds(50, 0, 500, 500);
		bacground.setLayout(new GridLayout(3, 3, 20, 20));
		// PicJPanel whiteJP = new PicJPanel("images/wait.gif");

		try {
			des = new JLabel("随机中", new ImageIcon(ImageIO.read(getClass().getResourceAsStream("images/wait.gif"))),
					SwingConstants.CENTER);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		des.setFont(new Font("幼圆", Font.PLAIN, 25));
		JPanel centerJP = new JPanel();
		centerJP.setLayout(new BorderLayout(2, 1));
		// centerJP.add(whiteJP,BorderLayout.NORTH) ;
		centerJP.add(des, BorderLayout.CENTER);
		centerJP.setOpaque(false);
		for (int i = 0; i < 8; i++) {
			if (i == 4)
				bacground.add(centerJP);
			bacground.add(avatar[i]);
		}
		apparence = 0;
		apparenceResult = "" ; 
		

		runRandomCursor = new Thread() {
			public void run() {
				char statue = '右';
				int x = 0;
				int y = 0;
				Random random = new Random();
				int times = 56 + random.nextInt(8)+random.nextInt(8);
				apparence = (times+1) % 8;
				int phases = times - 6;
				int sleepTime = 420;
				while (times >= 0) {
					switch (statue) {
					case '右':
						x += 166;
						if (x == 332 && y == 0)
							statue = '下';
						break;
					case '下':
						y += 166;
						if (y == 332 && x == 332)
							statue = '左';
						break;
					case '左':
						x -= 166;
						if (x == 0 && y == 332)
							statue = '上';
						break;
					case '上':
						y -= 166;
						if (y == 0 && x == 0)
							statue = '右';
						break;

					}
					times--;
					randomCursor.setBounds(x, y, 166, 166);
					setVisible(true);
					if (times > phases)
						sleepTime -= 80;
					else if (times < 5)
						sleepTime += 200;
					try {
						Thread.sleep(sleepTime);
					} catch (Exception e) {

					}
				}
				try {
					Thread.sleep(500);
				} catch (Exception e) {

				}
				removeAll() ; 
				setVisible(false) ; 
			}

		};
		runRandomCursor.start();
	}
	public String getApparence(){
		if(sex == "男的")
			apparenceResult = "images/avatar/m"+picture[apparence]+".png" ;
			else
			apparenceResult = "images/avatar/g"+picture[apparence]+".jpg" ;
		return apparenceResult ; 
	}

	public static void main(String[] args) {
		JFrame j = new JFrame("");
		j.getContentPane().add(new RandomLook("的"), BorderLayout.CENTER);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(600, 500);
		j.setVisible(true);
	}
}
