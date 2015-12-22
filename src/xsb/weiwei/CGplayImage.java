package xsb.weiwei;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class CGplayImage extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5911335645570620756L;
	private Image[] images;
	private Image currentImage;
	private int length ;
	final int SLEEP_TIME = 3000 ; 
	
	
	public CGplayImage(String[] path) {
		length = path.length ; 
		images = new Image[length];
		for (int i = 0; i <length; i++) {
			try {
				InputStream x = getClass().getResourceAsStream(path[i]) ; 
				images[i] = ImageIO.read(x);
				x.close(); 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		currentImage = images[0];
		Thread x = new Thread(this) ; 
		x.start(); 
	}

	public void paint(Graphics g) {
		final Graphics2D g2 = (Graphics2D) g;
		
		
		g2.drawImage(currentImage, 0, 0, getWidth(), getHeight(),this);
		
	}

	/*public static void main(String[] args) {
		JFrame j = new JFrame("");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CGplayImage i = new CGplayImage() ; 
		CGplayString s = new CGplayString() ; 
		j.setLayout(null) ; 
		

j.setGlassPane(s) ; 
s.setVisible(true) ; 
		j.add(i);
		s.setBounds(0, 0, 600, 500) ;
		i.setBounds(0, 0, 600, 500) ;
		
		j.setSize(600, 500);
		j.setVisible(true);
		
	}*/

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i <30 ; i++){
			currentImage =images[i%length] ; 
			try{
				Thread.sleep(SLEEP_TIME/(i+1)) ; 
			}catch(Exception e){
				
			}
		}
		try{
			Thread.sleep(SLEEP_TIME+1000) ; 
		}catch(Exception e){
			
		}
		setVisible(false) ;
		repaint() ; 
	}

}
