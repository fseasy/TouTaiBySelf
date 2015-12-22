package xsb.weiwei;
import javax.swing.* ; 

import java.awt.BorderLayout;
import java.awt.Color;  
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IsCharged extends JPanel{
	private boolean isCharged ; 
	private PicJPanel opaque ; 
	private PicJPanel contentPanel ;
	private JLabel statue;
	private XJButton confirm ; 
		IsCharged(boolean isCharged){
			setOpaque(false) ; 
			setLayout(new BorderLayout()) ; 
			this.isCharged = isCharged ; 
			opaque = new PicJPanel("images/opaque.png") ; 
			contentPanel = new PicJPanel("images/chargesBac.png") ; 
			add(opaque,BorderLayout.CENTER) ; 
			opaque.setLayout(null) ;
			opaque.add(contentPanel) ;
			contentPanel.setBounds(135,100,336,217) ; 
			statue = new JLabel("") ;
			statue.setFont(new Font("微软雅黑",Font.PLAIN,30)) ;
			statue.setForeground(Color.RED) ; 
			confirm = new XJButton("确定",30) ; 
			contentPanel.setLayout(new GridLayout(2,1,0,9)) ; 
			contentPanel.add(statue) ; 
			contentPanel.add(confirm) ; 
			confirm() ; 
			confirm.xb.addActionListener(new ActionListener(){
				public void actionPerformed (ActionEvent e){
					removeAll() ; 
					setVisible(false) ; 
				}
			}) ; 
			
		}
		protected void confirm(){
			if(isCharged){
				statue.setText("支付成功！") ; 
			}
			else
				statue.setText("余额不足 ！") ; 
			repaint() ; 
			
		}

}
