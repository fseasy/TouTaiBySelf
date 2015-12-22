package xsb.weiwei;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.IOException;

public class XJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1430476049384568042L;
	/**
	 * 
	 */

	private Image bacImage;

	public XJFrame(String title) {
		super(title);
		
		try {
			bacImage =ImageIO.read(getClass().getResource("images/bac.jpg")) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		JPanel contentPane = new JPanel(new BorderLayout()) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 7078875740390957921L;


			protected void paintComponent(Graphics g) {

				paintBackImage(g);
				super.paintComponent(g);

			}
			

			void paintBackImage(Graphics g) {
				Image Icon = bacImage ;
				int px = getWidth();
				int py = getHeight();
				int ix = Icon.getWidth(this);
				int iy = Icon.getHeight(this);
				int x = 0;
				int y = 0;
				while (y <= py) {
					g.drawImage(Icon, x, y,ix,iy,null);
					x += ix;
					if (x >= px) {
						x = 0;
						y += iy;
					}
				}

			}
		};
		getRootPane().setContentPane(contentPane) ; 
		contentPane.setOpaque(false) ; 
	}

	

	public static void main(String[] args) {
		XJFrame xx = new XJFrame("");
		xx.setSize(233, 120);
		xx.setVisible(true);
		xx.setDefaultCloseOperation(EXIT_ON_CLOSE) ; 
	}
}
