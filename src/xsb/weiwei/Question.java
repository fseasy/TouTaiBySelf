package xsb.weiwei;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.* ; 
public class Question extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5762336168576871640L;
	private String question ;
	private int strLen ; 
	private int fontSize ; 
	public Question(String question) {
		this.question = question ; 
		strLen = question.length() ; 
		fontSize = 50 ; 
		setLayout(null) ;
		setOpaque(false) ;
		setSize(strLen*(fontSize+20),65) ; 
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g) ; 
		Graphics2D g2 = (Graphics2D)g ; 
		Random random = new Random() ; 
		String[] fonts = {"ËÎÌå","¿¬Ìå","Ó×Ô²","Î¢ÈíÑÅºÚ"} ; 
		int x = 3 ; 
		Color color ; 
		for(int i = 0 ; i <strLen ; i++){
			color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)) ; 
			g2.setColor(color) ; 
			g2.setFont(new Font(fonts[random.nextInt(fonts.length)],Font.BOLD,fontSize+random.nextInt(5)-random.nextInt(5))) ; 
			g2.drawString(question.substring(i,i+1), x+=fontSize+1,fontSize+random.nextInt(5)-random.nextInt(5)) ; 
		}
		
		
	}
}
