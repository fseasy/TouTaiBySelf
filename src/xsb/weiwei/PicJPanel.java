package xsb.weiwei;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PicJPanel extends JPanel{
	private String path ; 
	private InputStream in ; 
	
	PicJPanel(String path){
		this.path = path ;
		setOpaque(false) ; 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g) ; 
		try {
			in = getClass().getResourceAsStream(path) ;
			Image image = ImageIO.read(in) ;
			g.drawImage(image, 0, 0, getWidth(), getHeight(),this) ;
			in.close() ; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void setPath(String path){
		this.path = path ; 
		repaint() ; 
	}
	
}
