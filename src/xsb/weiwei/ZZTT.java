/************************************
 *                                  *
 * x伟大作。。。。                                  *
 *                                  *
 ************************************/

package xsb.weiwei;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import sun.audio.*;

public class ZZTT {
	private JFrame jfm;
	private JPanel TopJP;
	private JLabel Title;
	private JLabel RemainMoney;
	private int Money;
	private Container contentPane;
	private JPanel mainPanel;
	private boolean isCharged;
	private Person person;
	private boolean isEnded = false;
	private Thread newThread;
	public ZZTT() {
		init();
	}

	void init() {
		// 从 JRE 1.6.0_22 version
		// 开始如果你的applet中的JLabel使用了HTML代码，applet第一次载入时会正确显示HTML的文本内容,
		// 但当你刷新页面后JLable中的HTML文本将不会正确显示。 该问题只有在你的JLable中存在HTML代码才会出现
		javax.swing.text.html.parser.ParserDelegator parserDelegator = new javax.swing.text.html.parser.ParserDelegator();
		jfm = new XJFrame("自助投胎机");
		contentPane = jfm.getContentPane();
		Money = 0;
		isCharged = false;
		person = new Person();
		newThread = null;
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setOpaque(false);
		mainPanel.setSize(600, 400);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		// /
		TopJP = new JPanel();
		Title = new JLabel(
				"<html><a style = 'font-size:20px'>欢迎使用</a><a style = 'font-size:32px ;color :red ;font-family:幼圆 '>自助投胎机</a></html>");
		Title.setAlignmentX(SwingConstants.LEFT);
		RemainMoney = new JLabel(
				"<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
						+ Money + "</a></html>");
		TopJP.setOpaque(false);
		TopJP.add(Title);
		TopJP.add(RemainMoney);

		// ---------------------------------------------
		// ((JComponent) contentPane).setOpaque(false);
		// ---------------------------------------------
		contentPane.add(TopJP, BorderLayout.NORTH);
		jfm.setLocation(new Point(380, 134));
		jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfm.setSize(600, 500);
		jfm.setVisible(true);

		// *******第一步***************
		playFirstStep();

	}

	void selectModal() {
		final XJButton mop = new XJButton("猫扑模式", 40);
		final XJButton random = new XJButton("随机模式", 40);
		final XJButton god = new XJButton("上帝模式", 40);
		JLabel title = new JLabel("请选择模式：");
		title.setFont(new Font("微软雅黑", Font.BOLD, 40));
		JLabel explain = new JLabel("模式决定了初始金钱");
		explain.setFont(new Font("微软雅黑", Font.ITALIC, 20));
		mainPanel.add(title);
		mainPanel.add(explain);
		mainPanel.add(mop);
		mainPanel.add(random);
		mainPanel.add(god);
		mainPanel.add(explain);
		//
		title.setBounds(100, 20, 400, 60);
		mop.setLocation(200, 100);
		random.setLocation(200, 180);
		god.setLocation(200, 260);
		explain.setBounds(100, 320, 400, 40);
		//
		final PicJPanel result = new PicJPanel("images/opaque.png");
		final Question getMoney = new Question("Money+");
		result.setLayout(null);
		result.add(getMoney);
		final JLabel m = new JLabel(" " + Money);
		m.setForeground(Color.DARK_GRAY);
		m.setFont(new Font("微软雅黑", Font.BOLD, 40));
		result.add(m);
		m.setBounds(360, 260, 200, 100);
		getMoney.setBounds(20, 130, 400, 200);
		jfm.setGlassPane(result);
		ActionListener al0 = new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				Thread swingNew = new Thread() {
					public void run() {
						mainPanel.removeAll();
						result.setVisible(true);
						if ((XB) e.getSource() == mop.xb) {
							Money = 0;
						} else if ((XB) e.getSource() == random.xb) {

							Random randomNum = new Random();

							for (int k = 0; k < 12; k++) {
								try {
									Thread.sleep(300);
								} catch (Exception e) {

								}
								Money = randomNum.nextInt(10) * 10
										+ (new Random()).nextInt(5) * 100
										+ 1000 * ((new Random()).nextInt(2))
										* (new Random()).nextInt(10)
										* (new Random()).nextInt(2)
										+ (new Random()).nextInt(2) * 10000
										* (new Random()).nextInt(10)
										* (new Random()).nextInt(2)
										* (new Random()).nextInt(2)
										+ (new Random()).nextInt(10)
										* (new Random()).nextInt(2) * 100000
										* (new Random()).nextInt(2)
										* (new Random()).nextInt(2)
										+ (new Random()).nextInt(10)
										* (new Random()).nextInt(2) * 1000000
										* (new Random()).nextInt(2)
										* (new Random()).nextInt(2)
										* (new Random()).nextInt(2)
										* (new Random()).nextInt(2);
								m.setText("" + Money);

							}
						} else
							Money = 999999;

						m.setText("" + Money);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						result.setVisible(false);
						isEnded = true;

					}
				};
				swingNew.start();
			}
		};

		mop.xb.addActionListener(al0);
		god.xb.addActionListener(al0);
		random.xb.addActionListener(al0);
		// /*************************
		// 用新的线程来开始下一步*****
		// **************************
		Thread anothSwing = new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {
				while (!isEnded) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				playSecondStep();
				isEnded = false;
				this.stop();
			}

		};
		anothSwing.start();
	}

	boolean handleMoney(int num) {
		if (Money + num >= 0) {
			Money += num;
			isCharged = true;
			return true;
		} else {
			isCharged = false;
			return false;
		}

	}

	void playFirstStep() {
		JPanel OuterJP = new JPanel();
		OuterJP.setLayout(new BorderLayout());
		OuterJP.setOpaque(false);
		PicJPanel description = new PicJPanel("images/01.png");

		String web = new String(
				"<html><a style = 'font-size:18px;color:red'>原作《<a href = 'http://so.tt.mop.com/read_11546482_1_0.html' style = 'font-family:幼圆 ;font-size :20px ;'>自助投胎机</a><a style = 'font-size :18px;color:red'>》来源于猫扑</a></html>");
		String coder = new String(
				"<html><a style = 'font-size:18px;color:red'>制作人：<a href='' style= 'font-family:楷体;font-size:21px'>只读文件</a></a></html>");
		JLabel originalAuthor = new JLabel(web);
		JLabel Author = new JLabel(coder);
		OuterJP.add(originalAuthor, BorderLayout.WEST);
		OuterJP.add(Author, BorderLayout.EAST);
		mainPanel.add(OuterJP);
		OuterJP.setBounds(new Rectangle(0, 0, jfm.getWidth() - 30, 40));
		mainPanel.add(description);
		description.setBounds(new Rectangle(0, 0, 600, 400));
		jfm.validate();
		try {
			Thread.sleep(2300);
		} catch (Exception e) {

		}
		mainPanel.removeAll();
		mainPanel.repaint();
		mainPanel.setVisible(true);

		// *******************************
		// 选择模式
		selectModal();
		// *******************************
	}

	void playSecondStep() {
		// 更新Money值
		RemainMoney
				.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
						+ Money + "</a></html>");
		// /
		JPanel advertisement = new JPanel(null) {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				int width = 150;
				int height = 350;
				try {
					// 画图------------------ --------
					BufferedImage bi = ImageIO.read(getClass().getResourceAsStream("images/mopLogo.png"));
					BufferedImage temp = new BufferedImage(width, height, bi
							.getColorModel().getTransparency());
					// 写入缓存，关联画法
					// !!---------------
					// ---------------------顺时针旋转90度------------
					Graphics2D g2Paint = temp.createGraphics();
					g2Paint.rotate(Math.toRadians(90.0), width / 2, width / 2);
					g2Paint.drawImage(bi, 0, 0, height, width, this);

					g2.drawImage(temp, 0, 0, width, height, this);
					g2.setColor(Color.GRAY);
					g2.setStroke(new BasicStroke(3.0f));
					g2.fillRect(2, height + 2, width - 15, 45);
					// 阴影
					g2.setColor(Color.BLACK);
					g2.setFont(new Font("幼圆", Font.BOLD, 25));
					g2.drawString("只读文件", 20 + 1, height + 30 + 1);
					g2.setColor(Color.WHITE);
					g2.setFont(new Font("幼圆", Font.PLAIN, 25));
					g2.drawString("只读文件", 20, height + 30);

				} catch (Exception e) {

				}

			}

		};

		mainPanel.add(advertisement);
		advertisement.setOpaque(false);
		advertisement.setBounds(0, 0, 150, 400);
		// -----------------------
		Question q1 = new Question("欢迎进入");
		Question q2 = new Question("自助投胎");
		mainPanel.add(q1);
		mainPanel.add(q2);
		q1.setLocation(160, 71);
		q2.setLocation(300, 154);
		// ------------------------
		XJButton x1 = new XJButton("我要投胎");
		x1.xb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.setVisible(true);
				// *******************************
				// 第三步 *
				playThirdStep();
				// *******************************
			}
		});
		mainPanel.add(x1);
		x1.setLocation(273, 269);

		mainPanel.validate();

	}

	void playThirdStep() {
		// 设置切换线程
		newThread = new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (isCharged) {
					// ____________________________________________________//
					// 第四步 //
					// ____________________________________________________//
					playFourthStep();
				} else
					// *************************
					playThirdStep();
				this.stop();
			}
		};

		//

		Question q31 = new Question("请选择性别：");
		mainPanel.add(q31);
		q31.setLocation(109, 40);
		final XJButton x31 = new XJButton("女（50币）");
		final XJButton x32 = new XJButton("男（免费）");
		ActionListener al3 = new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				newThread.start();
				Charges c1;
				if ((XB) e2.getSource() == x31.xb) {
					if (handleMoney(-50)) {

						c1 = new Charges(true);
						person.setSex("妹子");

					} else
						c1 = new Charges(false);

				} else {
					if (handleMoney(0)) {
						c1 = new Charges(true);
						person.setSex("男的");
					} else
						c1 = new Charges(false);
				}
				jfm.setGlassPane(c1);
				c1.setVisible(true);
				x31.xb.setEnabled(false);
				x32.xb.setEnabled(false);
				mainPanel.removeAll();
				RemainMoney
						.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
								+ Money + "</a></html>");
				jfm.repaint();
				jfm.setVisible(true);

			}
		};
		x31.xb.addActionListener(al3);
		x32.xb.addActionListener(al3);
		mainPanel.add(x31);
		mainPanel.add(x32);
		x31.setLocation(32, 200);
		x32.setLocation(321, 200);
		mainPanel.repaint();
		mainPanel.setVisible(true);

	}

	void playFourthStep() {
		// 设置切换线程
		newThread = new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (isCharged) {
					// ****************************
					// 第五步
					RemainMoney
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
									+ Money + "</a></html>");

					playFifthStep();
					//

				} else
					playFourthStep();

			}
		};

		//
		Question q4 = new Question("请选择生存难度：");

		mainPanel.add(q4);
		q4.setLocation(64, 15);
		PicJPanel p4 = new PicJPanel("images/opaque.png");
		p4.setLayout(new GridLayout(4, 1));
		//
		final XJButton x41 = new XJButton("简单（10,000币）", 30);
		final XJButton x42 = new XJButton("中等（5,000币)  ", 30);
		final XJButton x43 = new XJButton("困难（200币）     ", 30);
		final XJButton x44 = new XJButton("深渊（免费）       ", 30);
		//
		p4.add(x41);
		p4.add(x42);
		p4.add(x43);
		p4.add(x44);
		//
		mainPanel.add(p4);
		p4.setBounds(162, 104, 270, 210);
		//
		mainPanel.validate();
		ActionListener al4 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IsCharged i;
				if ((XB) e.getSource() == x41.xb) {
					if (handleMoney(-10000)) {
						i = new IsCharged(isCharged);
						person.setDifficulty("简单");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x42.xb) {
					if (handleMoney(-5000)) {
						i = new IsCharged(isCharged);
						person.setDifficulty("中等");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x43.xb) {
					if (handleMoney(-200)) {
						i = new IsCharged(isCharged);
						person.setDifficulty("困难");
					} else
						i = new IsCharged(isCharged);
				} else {
					if (handleMoney(0)) {
						i = new IsCharged(isCharged);
						person.setDifficulty("深渊");
					} else
						i = new IsCharged(isCharged);
				}
				jfm.setGlassPane(i);
				i.setVisible(true);
				mainPanel.removeAll();
				newThread.start();
			}

		};
		x41.xb.addActionListener(al4);
		x42.xb.addActionListener(al4);
		x43.xb.addActionListener(al4);
		x44.xb.addActionListener(al4);
	}

	void playFifthStep() {
		// 设置切换线程
		newThread = new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (isCharged) {
					RemainMoney
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
									+ Money + "</a></html>");

					// ***********************
					// 第六步 *
					playSixthStep();
					// ***********************
				} else {
					playFifthStep();
				}

			}
		};
		Question q5 = new Question("请选择国家地区：");
		mainPanel.add(q5);
		q5.setLocation(69, 20);
		PicJPanel worldMap = new PicJPanel("images/worldMap.png");
		mainPanel.add(worldMap);
		worldMap.setBounds(0, 100, 600, 300);
		worldMap.setLayout(null);
		final XJButton c1 = new XJButton("50,000币", 27);
		final XJButton c2 = new XJButton("20,000币", 27);
		final XJButton c3 = new XJButton("100币", 25);
		final XJButton c4 = new XJButton("20币", 25);
		final XJButton c5 = new XJButton("10币", 25);
		final XJButton c6 = new XJButton("未开通", 25);
		final XJButton c7 = new XJButton("未开通", 25);
		final XJButton cChina = new XJButton("免费（现打折送5币）", 25);
		// /
		worldMap.add(c1);
		worldMap.add(c2);
		worldMap.add(c3);
		worldMap.add(c4);
		worldMap.add(c5);
		worldMap.add(c6);
		worldMap.add(c7);
		worldMap.add(cChina);

		// /
		c1.setLocation(437, 88);
		c2.setLocation(48, 34);
		c3.setLocation(217, 19);
		c4.setLocation(67, 137);
		c5.setLocation(446, 20);
		c6.setLocation(254, 180);
		c7.setLocation(492, 184);
		cChina.setLocation(193, 83);
		// /
		ActionListener al5 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IsCharged i;
				if ((XB) e.getSource() == c1.xb) {
					if (handleMoney(-50000)) {
						i = new IsCharged(isCharged);
						person.setCountry("神一样的国度");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == c2.xb) {
					if (handleMoney(-20000)) {
						i = new IsCharged(isCharged);
						person.setCountry("nb一样的国度");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == c3.xb) {
					if (handleMoney(-100)) {
						i = new IsCharged(isCharged);
						person.setCountry("人一样的国度");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == c4.xb) {
					if (handleMoney(-20)) {
						i = new IsCharged(isCharged);
						person.setCountry("20币的国度");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == c5.xb) {
					if (handleMoney(-10)) {
						i = new IsCharged(isCharged);
						person.setCountry("10币的国度");
					} else
						i = new IsCharged(isCharged);
				} else {
					if (handleMoney(5)) {
						i = new IsCharged(isCharged);
						person.setCountry("超神般存在的国度");
					} else
						i = new IsCharged(isCharged);
				}
				jfm.setGlassPane(i);
				i.setVisible(true);
				mainPanel.removeAll();
				newThread.start();
			}
		};
		c1.xb.addActionListener(al5);
		c2.xb.addActionListener(al5);
		c3.xb.addActionListener(al5);
		c4.xb.addActionListener(al5);
		c5.xb.addActionListener(al5);
		cChina.xb.addActionListener(al5);
	}

	void playSixthStep() {
		// 设置切换线程
		newThread = new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (isCharged) {
					RemainMoney
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
									+ Money + "</a></html>");

					// ***********************
					// 第七步 *
					playSeventhStep();
					// ***********************
				} else {
					playSixthStep();
				}

			}
		};
		Question q6 = new Question("请选择出身：");
		mainPanel.add(q6);
		q6.setLocation(69, 20);
		PicJPanel contentPanel = new PicJPanel("images/opaque.png");

		contentPanel.setLayout(new GridLayout(4, 1));
		final XJButton x1;
		if (person.getSex() == "男的")
			x1 = new XJButton("高富帅（90,000币）", 30);
		else
			x1 = new XJButton("白富美（90,000币）", 30);
		final XJButton x2 = new XJButton("官二代（50,000币）", 30);
		final XJButton x3 = new XJButton("富二代（50,000币）", 30);
		final XJButton x4 = new XJButton("军二代（50,000币）", 30);
		final XJButton x5 = new XJButton("我爸是李刚套餐（100,000币）", 30);
		final XJButton x6 = new XJButton("屌丝（免费）", 30);
		contentPanel.add(x1);
		contentPanel.add(x2);
		contentPanel.add(x3);
		contentPanel.add(x4);
		mainPanel.add(contentPanel);
		contentPanel.setBounds(43, 125, 320, 210);
		mainPanel.add(x5);
		mainPanel.add(x6);
		x6.setLocation(370, 125);
		x5.setLocation(63, 340);
		mainPanel.validate();
		ActionListener al6 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IsCharged i;
				if ((XB) e.getSource() == x1.xb) {
					if (handleMoney(-90000)) {
						i = new IsCharged(isCharged);
						if (person.getSex() == "妹子")
							person.setFamilyBacground("白富美");
						else
							person.setFamilyBacground("高富帅");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x2.xb
						|| (XB) e.getSource() == x3.xb
						|| (XB) e.getSource() == x4.xb) {
					if (handleMoney(-50000)) {
						i = new IsCharged(isCharged);
						person.setFamilyBacground("二代世家");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x5.xb) {
					if (handleMoney(-100000)) {
						i = new IsCharged(isCharged);
						person.setFamilyBacground("李刚二代");
					} else
						i = new IsCharged(isCharged);
				} else {
					if (handleMoney(0)) {
						i = new IsCharged(isCharged);
						person.setFamilyBacground("屌丝存在");
					} else
						i = new IsCharged(isCharged);
				}
				jfm.setGlassPane(i);
				i.setVisible(true);
				mainPanel.removeAll();
				newThread.start();
			}
		};
		x1.xb.addActionListener(al6);
		x2.xb.addActionListener(al6);
		x3.xb.addActionListener(al6);
		x4.xb.addActionListener(al6);
		x5.xb.addActionListener(al6);
		x6.xb.addActionListener(al6);
	}

	void playSeventhStep() {
		newThread = new Thread() {
			@SuppressWarnings("deprecation")
			public void run() {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (isCharged) {
					RemainMoney
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
									+ Money + "</a></html>");
					// *************************
					// 第八步
					playEighthStep();
				} else
					playSeventhStep();

			}
		};
		Question q7 = new Question("请选择主要技能：");
		mainPanel.add(q7);
		q7.setLocation(69, 20);
		PicJPanel opaque = new PicJPanel("images/opaque.png");
		opaque.setBounds(29, 104, 510, 300);
		final XJButton x1 = new XJButton("赚钱（10,000币）", 30);
		final XJButton x2;
		if (person.getSex() == "男的")
			x2 = new XJButton("把妹（10,000币）", 30);
		else
			x2 = new XJButton("魅惑（10，000币）", 30);
		final XJButton x3 = new XJButton("文艺（5,000币）", 30);
		final XJButton x4 = new XJButton("杰伦二代（未开通）", 30);
		final XJButton x5 = new XJButton("程序员（未开通）", 28);
		final XJButton x6 = new XJButton("技工（1000币）", 30);
		final XJButton x7 = new XJButton("泡面（5币）", 30);
		final XJButton x8 = new XJButton("啥也不会（免费）", 30);
		//
		opaque.setLayout(new GridLayout(4, 2));
		opaque.add(x1);
		opaque.add(x2);
		opaque.add(x3);
		opaque.add(x6);
		opaque.add(x4);
		opaque.add(x5);
		opaque.add(x7);
		opaque.add(x8);
		//
		mainPanel.add(opaque);
		mainPanel.validate();
		ActionListener al7 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IsCharged i;
				if ((XB) e.getSource() == x1.xb) {
					if (handleMoney(-10000)) {
						i = new IsCharged(isCharged);
						person.setSkill("赚钱 ");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x2.xb) {
					if (handleMoney(-10000)) {
						i = new IsCharged(isCharged);
						if (person.getSex() == "男的")
							person.setSkill("把妹");
						else
							person.setSkill("魅惑");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x3.xb) {
					if (handleMoney(-5000)) {
						i = new IsCharged(isCharged);
						person.setSkill("文艺青年 ");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x6.xb) {
					if (handleMoney(-1000)) {
						i = new IsCharged(isCharged);
						person.setSkill("技工 ");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x7.xb) {
					if (handleMoney(-5)) {
						i = new IsCharged(isCharged);
						person.setSkill("泡面 ");
					} else
						i = new IsCharged(isCharged);
				} else {
					if (handleMoney(0)) {
						i = new IsCharged(isCharged);
						person.setSkill("啥也不会 ");
					} else
						i = new IsCharged(isCharged);
				}
				jfm.setGlassPane(i);
				i.setVisible(true);
				mainPanel.removeAll();
				newThread.start();
			}

		};
		x1.xb.addActionListener(al7);
		x2.xb.addActionListener(al7);
		x3.xb.addActionListener(al7);
		x6.xb.addActionListener(al7);
		x7.xb.addActionListener(al7);
		x8.xb.addActionListener(al7);
	}

	void playEighthStep() {
		Question q8 = new Question("请选择你长相：");
		mainPanel.add(q8);
		q8.setLocation(69, 5);
		final PicJPanel m1;
		final PicJPanel m2;
		final XJButton x1;
		final XJButton x2;
		final XJButton x3;
		if (person.getSex() == "男的") {
			m1 = new PicJPanel("images/lc.png");
			m2 = new PicJPanel("images/bl.jpg");
			x1 = new XJButton("美男套餐（90,000币）", 20);
			x2 = new XJButton("比利套餐（100,000币）", 20);
			x3 = new XJButton("随机（免费）", 20);

		} else {
			m1 = new PicJPanel("images/qz.jpg");
			m2 = new PicJPanel("images/mds.png");
			x1 = new XJButton("女神套餐（90,000币）", 20);
			x2 = new XJButton("一姐套餐（100,000币）", 20);
			x3 = new XJButton("随机（免费）", 20);

		}
		mainPanel.add(m1);
		mainPanel.add(m2);
		m1.setBounds(58, 62, 150, 150);
		m2.setBounds(58, 230, 150, 150);
		x1.setLocation(240, 190);
		x2.setLocation(240, 360);
		x3.setLocation(415, 87);
		mainPanel.add(x1);
		mainPanel.add(x2);
		mainPanel.add(x3);
		mainPanel.validate() ; 
		mainPanel.repaint() ; 
		mainPanel.setVisible(true) ; 
		ActionListener al8 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IsCharged i;
				if ((XB) e.getSource() == x1.xb) {
					if (handleMoney(-90000)) {
						RemainMoney
								.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
										+ Money + "</a></html>");
						if (person.getSex() == "男的")
							person.setApparence("images/lc.png");
						else
							person.setApparence("images/qz.jpg");
					}

				} else {
					if (handleMoney(-100000)) {
						RemainMoney
								.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
										+ Money + "</a></html>");
						if (person.getSex() == "男的")
							person.setApparence("images/bl.png");
						else
							person.setApparence("images/mds.png");
					}
				}
				i = new IsCharged(isCharged);
				jfm.setGlassPane(i);
				i.setVisible(true);
				mainPanel.removeAll();
				if (isCharged) {
					// ********************
					// 第九步
					playNinethStep();
					// ****************
				} else
					playEighthStep();

			}

		};
		// **************************
		// 为PicJPanel添加mouseListener
		// ***************************

		m1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e2) {

				IsCharged i;
				if (handleMoney(-90000)) {
					if (person.getSex() == "男的")
						person.setApparence("images/lc.png");
					else
						person.setApparence("images/qz.jpg");
				}
				i = new IsCharged(isCharged);
				jfm.setGlassPane(i);
				i.setVisible(true);
				mainPanel.removeAll();
				if (isCharged) {
					RemainMoney
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
									+ Money + "</a></html>");
					// ********************
					// 第九步
					playNinethStep();
					// ****************
				} else
					playEighthStep();
			}

			public void mouseEntered(MouseEvent e) {
				m1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

		});
		m2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e2) {
				m2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				IsCharged i;
				if (handleMoney(-100000)) {
					if (person.getSex() == "男的")
						person.setApparence("images/bl.png");
					else
						person.setApparence("images/mds.png");
				}
				i = new IsCharged(isCharged);
				jfm.setGlassPane(i);
				i.setVisible(true);
				mainPanel.removeAll();
				if (isCharged) {
					RemainMoney
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
									+ Money + "</a></html>");
					// ********************
					// 第九步
					playNinethStep();
					// ****************
				} else
					playEighthStep();
			}

			public void mouseEntered(MouseEvent e) {
				m2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		// *********************************
		// 鼠标监听完毕
		// *********************************
		x1.xb.addActionListener(al8);
		x2.xb.addActionListener(al8);
		x3.xb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				mainPanel.removeAll();
				// **************
				// 分支
				playRandomLook();
				// ******************
			}
		});
	}

	void playRandomLook() {
		RandomLook rl = new RandomLook(person.getSex());
		jfm.setGlassPane(rl);
		rl.setVisible(true);
		// ///
		RemainMoney
				.setText("<html><a style = 'font-size:26px ;color :blue ; '>余额 ：</a><a style = 'font-size:24px;color:red;font-family:方正舒体'>"
						+ Money + "</a></html>");
		Question q1 = new Question("您的随机结果为 ：");
		mainPanel.add(q1);
		q1.setLocation(5, 26);
		final PicJPanel appa;
		try {
			Thread.sleep(90);
		} catch (Exception d) {

		}
		String apparenceResult = rl.getApparence();
		person.setApparence(apparenceResult);
		appa = new PicJPanel(apparenceResult);
		PicJPanel border = new PicJPanel("images/border.png");
		final XJButton startAgain = new XJButton("再次随机（100币）", 28);
		final XJButton over = new XJButton("非常满意(免费)", 28);
		mainPanel.add(border);
		mainPanel.add(appa);
		border.setBounds(75, 129, 220, 220);
		appa.setBounds(85, 139, 200, 200);
		mainPanel.add(startAgain);
		mainPanel.add(over);
		startAgain.setLocation(341, 155);
		over.setLocation(341, 236);
		startAgain.xb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (handleMoney(-100)) {
					RandomLook rl = new RandomLook(person.getSex());
					jfm.setGlassPane(rl);
					rl.setVisible(true);
					try {
						Thread.sleep(20);
					} catch (Exception d) {

					}
					String apparence = rl.getApparence();
					person.setApparence(apparence);
					appa.setPath(apparence);

				} else {
					IsCharged i = new IsCharged(isCharged);
					jfm.setGlassPane(i);
					i.setVisible(true);
				}

			}

		});
		over.xb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ***********************
				// 第九步
				playNinethStep();

				// ********************

			}
		});

		// /

	}

	void playNinethStep() {
		mainPanel.removeAll();
		try {
			Thread.sleep(400);
		} catch (Exception e) {

		}
		Question q9 = new Question("感谢使用本系统");
		Question q10 = new Question("请您留下您的建议");
		mainPanel.add(q9);
		mainPanel.add(q10);
		q9.setLocation(0, 10);
		q10.setLocation(55, 70);
		final JTextArea suggestion = new JTextArea("别在坟前哭，脏了我轮回的路", 15, 5);
		suggestion.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		suggestion.setOpaque(false);
		JScrollPane jsp = new JScrollPane(suggestion);
		mainPanel.add(jsp);
		jsp.setBounds(50, 170, 500, 150);
		jsp.setOpaque(false);
		XJButton submit = new XJButton("确定", 25);
		mainPanel.add(submit);
		submit.setLocation(500, 350);
		jfm.validate();
		mainPanel.repaint();
		mainPanel.setVisible(true);
		mainPanel.repaint();
		mainPanel.setVisible(true);
		submit.xb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				person.setPreviousLifeLastWords(suggestion.getText());
				mainPanel.removeAll();
				mainPanel.repaint();
				playTenthStep();
			}
		});
	}

	void playTenthStep() {
		JLabel words1 = new JLabel("虽然听不懂您的意见，但貌似很强大的样子。");
		JLabel words2 = new JLabel("为此，系统将免费赠送一套");
		Question q10 = new Question("豪华猫爪印");
		mainPanel.add(words1);
		mainPanel.add(words2);
		words1.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		words2.setFont(new Font("微软雅黑", Font.ITALIC, 28));
		mainPanel.add(q10);
		words1.setBounds(3, 10, 550, 100);
		words2.setBounds(53, 60, 500, 100);
		q10.setLocation(200, 150);
		Thread cg = new Thread() {
			public void run() {
				try {
					Thread.sleep(3200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				contentPane.removeAll();

				PicJPanel bac = new PicJPanel("images/opaque.png");
				contentPane.add(bac, BorderLayout.CENTER);
				jfm.repaint();
				jfm.setVisible(true);
				bac.setBounds(1, 1, 599, 499);
				bac.setVisible(true);
				JLabel x1 = new JLabel("NOW,转生开始");
				x1.setFont(new Font("微软雅黑", Font.BOLD, 50));
				bac.add(x1);
				x1.setBounds(50, 200, 550, 100);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// **********************
				// 第十一步
				playEleventhStep();
				// **********************
			}

		};
		cg.start();

	}

	void playEleventhStep() {
		String[] path = new String[3];
		for (int i = 0; i < 3; i++) {
			path[i] = ("images/cg/cg" + i + ".png");
		}
		CGplayImage cgi = new CGplayImage(path);
		contentPane.removeAll();
		contentPane.add(cgi, BorderLayout.CENTER);
		jfm.repaint();
		jfm.setVisible(true);
		String text = "今世前生，红尘若梦。 暮雨今夕,攘攘无归。 ︻人生一场虚空大梦 韶华白首，不过转瞬 。。。|仙四︼  前尘如烟，往事何言。 。。。转生 愉快";
		CGplayString cgs = new CGplayString(text);
		jfm.setGlassPane(cgs);
		cgs.setVisible(true);
		// ******************
		// 最后一步，十二步
		playTwelvethStep();

	}

	void playTwelvethStep() {
		PicJPanel bac = new PicJPanel("images/opaque.png");

		bac.setLayout(null);
		JLabel text = new JLabel("16年后领到了身份证");
		text.setFont(new Font("微软雅黑", Font.BOLD, 28));
		bac.add(text);
		bac.add(person);
		text.setBounds(5, 10, 500, 40);
		person.setBounds(0, 70, 600, 377);
		contentPane.add(bac, BorderLayout.CENTER);
		contentPane.validate();
		bac.repaint();
		bac.setVisible(true);
	}

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		Font font = new Font("幼圆", Font.PLAIN, 15);
		UIManager.put("JLabel.font", font);

		new ZZTT();

	}


}
