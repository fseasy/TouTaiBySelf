package xsb.weiwei;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Charges extends JPanel {
	private final boolean isAffordable;
	private PicJPanel bacPanel;
	private PicJPanel contentPanel;
	private JProgressBar progress;
	private XJButton rec ; 
	private int value;
	private JLabel statue;
	private Random random;
	public Thread refresh;
	private Font xf;
	private String[] words = {"看你印堂发黑，不如买个保险吧","嗯哼，还不丑，验证成功","额，我眼睛要瞎了，过","哈哈哈哈哈，mua","早说自己是城管何必来此呢"} ;

	public Charges(final boolean isAffordable) {
		this.isAffordable = isAffordable;
		setVisible(true) ; 
		setOpaque(false);
		setLayout(new BorderLayout());
		bacPanel = new PicJPanel("images/opaque.png");
		bacPanel.setLayout(null);
		bacPanel.setSize(400, 300);
		add(bacPanel, BorderLayout.CENTER);
		contentPanel = new PicJPanel("images/chargesBac.png");
		contentPanel.setLayout(new GridLayout(4, 1));
		bacPanel.add(contentPanel);
		contentPanel.setBounds(135, 125, 336, 217);
		progress = new JProgressBar(0, 100);
		value = 0;

		progress.setStringPainted(true);

		contentPanel.add(new PicJPanel("images/chargesBac.png"));

		contentPanel.add(progress);

		contentPanel.add(new PicJPanel("images/chargesBac.png"));
		statue = new JLabel("连接网银中");
		xf = new Font("微软雅黑", Font.PLAIN, 20);
		statue.setFont(xf);
		contentPanel.add(statue);
		
		rec = new XJButton("返回") ; 
		//
		random = new Random();
		refresh = new Thread() {
			public void run() {
				int i1 = random.nextInt(words.length) ; 
				int i2 = (new Random()).nextInt(words.length) ; 
				while (value <= 110) {
					if (value <= 100)
						value += random.nextInt(5);
					progress.setValue(value);
					if (value >= 5 && value <= 10)
						statue.setText("连接网银中。");
					if (value >= 11 && value <= 20)
						statue.setText("连接网银中。。");
					if (value >= 21 && value <= 35)
						statue.setText("连接网银中。。。");
					if (value > 35 && value <= 50)
						statue.setText("连接网银中。。。。");
					if (value > 50 && value <= 61)
						statue.setText("面部识别中");
					if (value > 61 && value <= 77) {
						statue.setForeground(Color.RED);
						statue.setText(words[i1]);
					}
					if (value > 77 && value <= 87) {
						statue.setForeground(Color.BLUE);
						statue.setText(words[i2]);
					}
					if (value > 87)
						statue.setText("正在扣费!");
					if (value >= 100) {
						if (isAffordable) {
							statue.setText("扣费成功!");
						} else
							statue.setText("余额不足!无法选择。。。");
						
						bacPanel.add(rec) ; 
						rec.setLocation(270,350) ; 
						rec.xb.addActionListener(new ActionListener(){
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent e2){
								removeAll() ; 
								setVisible(false) ; 
								refresh.stop(); 
							}
						}) ; 
					}
					try {
						//速度
						Thread.sleep(60+random.nextInt(130));
					} catch (Exception e) {

					}
				}
			}
		};
		refresh.start();

	}

	public static void main(String[] args) {
		final Charges c = new Charges(true);

		JFrame j = new JFrame("");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.add(c, BorderLayout.CENTER);

		j.setSize(400, 500);
		j.setVisible(true);
		j.repaint();
		j.setVisible(true);
	}
}
