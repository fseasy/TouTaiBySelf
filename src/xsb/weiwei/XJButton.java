package xsb.weiwei;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import sun.audio.* ; 

public class XJButton extends JPanel{
	private String text ; 
	private boolean isEntered ; 
	public static int FONT_SIZE  ; 
	protected XB xb ;
	protected static Image bacImage ; 
	
	public XJButton(String text){
		FONT_SIZE = 35 ; 
		init(text) ; 
		
	}
	public XJButton(String text,int fontSize){
		FONT_SIZE = fontSize ; 
		init(text) ; 
		
	}
	
	protected void init(String text){
		this.text = text ;
		xb = new XB(this.text) ; 
		setOpaque(false) ; 
		setLayout(null) ; 
		setSize((FONT_SIZE+10)*text.length(),FONT_SIZE+6) ;
		add(xb) ;
		xb.setBounds(1,1,(FONT_SIZE)*text.length()+12,FONT_SIZE+14) ; 
		try{
			bacImage = ImageIO.read(getClass().getResourceAsStream("images/button.png")) ; 
			
		}
		catch(Exception e){
			
		}
		
	}
}
 class XB extends JButton {
	private String text ; 
	private boolean isEntered ; 
	private AudioStream as ; 
	XB(String text){
		this.text = text ; 
		isEntered = false ;
		try{
			as = new AudioStream(getClass().getResourceAsStream("dot.wav")) ; 
		}catch(Exception e){
			
		}
		setBorderPainted(false);
		setFocusPainted(false) ; 
		setContentAreaFilled(false);
		this.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				isEntered = true ; 
				
				setCursor(new Cursor(Cursor.HAND_CURSOR)) ; 
				
				repaint() ; 
			}
			public void mouseExited(MouseEvent e2){
				isEntered = false ; 
				
				repaint() ; 
			}
			public void mousePressed(MouseEvent e){
				AudioPlayer.player.start(as) ; 
			}
		}) ; 
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D)g ; 
		
		if(isEntered){
			setBorder(BorderFactory.createRaisedBevelBorder()); 
			g2.setColor(Color.RED) ;
			g2.drawImage(XJButton.bacImage,1,1,(XJButton.FONT_SIZE)*text.length()+1,XJButton.FONT_SIZE+14,this) ; 
		}
		g2.setFont(new Font("свт╡",Font.PLAIN,XJButton.FONT_SIZE)) ; 
		g2.drawString(text, 2, XJButton.FONT_SIZE) ; 
	}
	

}