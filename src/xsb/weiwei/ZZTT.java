/************************************
 *                                  *
 * xΰ������������                                  *
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
		// �� JRE 1.6.0_22 version
		// ��ʼ������applet�е�JLabelʹ����HTML���룬applet��һ������ʱ����ȷ��ʾHTML���ı�����,
		// ������ˢ��ҳ���JLable�е�HTML�ı���������ȷ��ʾ�� ������ֻ�������JLable�д���HTML����Ż����
		javax.swing.text.html.parser.ParserDelegator parserDelegator = new javax.swing.text.html.parser.ParserDelegator();
		jfm = new XJFrame("����Ͷ̥��");
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
				"<html><a style = 'font-size:20px'>��ӭʹ��</a><a style = 'font-size:32px ;color :red ;font-family:��Բ '>����Ͷ̥��</a></html>");
		Title.setAlignmentX(SwingConstants.LEFT);
		RemainMoney = new JLabel(
				"<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
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

		// *******��һ��***************
		playFirstStep();

	}

	void selectModal() {
		final XJButton mop = new XJButton("è��ģʽ", 40);
		final XJButton random = new XJButton("���ģʽ", 40);
		final XJButton god = new XJButton("�ϵ�ģʽ", 40);
		JLabel title = new JLabel("��ѡ��ģʽ��");
		title.setFont(new Font("΢���ź�", Font.BOLD, 40));
		JLabel explain = new JLabel("ģʽ�����˳�ʼ��Ǯ");
		explain.setFont(new Font("΢���ź�", Font.ITALIC, 20));
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
		m.setFont(new Font("΢���ź�", Font.BOLD, 40));
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
		// ���µ��߳�����ʼ��һ��*****
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
				"<html><a style = 'font-size:18px;color:red'>ԭ����<a href = 'http://so.tt.mop.com/read_11546482_1_0.html' style = 'font-family:��Բ ;font-size :20px ;'>����Ͷ̥��</a><a style = 'font-size :18px;color:red'>����Դ��è��</a></html>");
		String coder = new String(
				"<html><a style = 'font-size:18px;color:red'>�����ˣ�<a href='' style= 'font-family:����;font-size:21px'>ֻ���ļ�</a></a></html>");
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
		// ѡ��ģʽ
		selectModal();
		// *******************************
	}

	void playSecondStep() {
		// ����Moneyֵ
		RemainMoney
				.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
						+ Money + "</a></html>");
		// /
		JPanel advertisement = new JPanel(null) {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				int width = 150;
				int height = 350;
				try {
					// ��ͼ------------------ --------
					BufferedImage bi = ImageIO.read(getClass().getResourceAsStream("images/mopLogo.png"));
					BufferedImage temp = new BufferedImage(width, height, bi
							.getColorModel().getTransparency());
					// д�뻺�棬��������
					// !!---------------
					// ---------------------˳ʱ����ת90��------------
					Graphics2D g2Paint = temp.createGraphics();
					g2Paint.rotate(Math.toRadians(90.0), width / 2, width / 2);
					g2Paint.drawImage(bi, 0, 0, height, width, this);

					g2.drawImage(temp, 0, 0, width, height, this);
					g2.setColor(Color.GRAY);
					g2.setStroke(new BasicStroke(3.0f));
					g2.fillRect(2, height + 2, width - 15, 45);
					// ��Ӱ
					g2.setColor(Color.BLACK);
					g2.setFont(new Font("��Բ", Font.BOLD, 25));
					g2.drawString("ֻ���ļ�", 20 + 1, height + 30 + 1);
					g2.setColor(Color.WHITE);
					g2.setFont(new Font("��Բ", Font.PLAIN, 25));
					g2.drawString("ֻ���ļ�", 20, height + 30);

				} catch (Exception e) {

				}

			}

		};

		mainPanel.add(advertisement);
		advertisement.setOpaque(false);
		advertisement.setBounds(0, 0, 150, 400);
		// -----------------------
		Question q1 = new Question("��ӭ����");
		Question q2 = new Question("����Ͷ̥");
		mainPanel.add(q1);
		mainPanel.add(q2);
		q1.setLocation(160, 71);
		q2.setLocation(300, 154);
		// ------------------------
		XJButton x1 = new XJButton("��ҪͶ̥");
		x1.xb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				mainPanel.removeAll();
				mainPanel.repaint();
				mainPanel.setVisible(true);
				// *******************************
				// ������ *
				playThirdStep();
				// *******************************
			}
		});
		mainPanel.add(x1);
		x1.setLocation(273, 269);

		mainPanel.validate();

	}

	void playThirdStep() {
		// �����л��߳�
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
					// ���Ĳ� //
					// ____________________________________________________//
					playFourthStep();
				} else
					// *************************
					playThirdStep();
				this.stop();
			}
		};

		//

		Question q31 = new Question("��ѡ���Ա�");
		mainPanel.add(q31);
		q31.setLocation(109, 40);
		final XJButton x31 = new XJButton("Ů��50�ң�");
		final XJButton x32 = new XJButton("�У���ѣ�");
		ActionListener al3 = new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				newThread.start();
				Charges c1;
				if ((XB) e2.getSource() == x31.xb) {
					if (handleMoney(-50)) {

						c1 = new Charges(true);
						person.setSex("����");

					} else
						c1 = new Charges(false);

				} else {
					if (handleMoney(0)) {
						c1 = new Charges(true);
						person.setSex("�е�");
					} else
						c1 = new Charges(false);
				}
				jfm.setGlassPane(c1);
				c1.setVisible(true);
				x31.xb.setEnabled(false);
				x32.xb.setEnabled(false);
				mainPanel.removeAll();
				RemainMoney
						.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
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
		// �����л��߳�
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
					// ���岽
					RemainMoney
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
									+ Money + "</a></html>");

					playFifthStep();
					//

				} else
					playFourthStep();

			}
		};

		//
		Question q4 = new Question("��ѡ�������Ѷȣ�");

		mainPanel.add(q4);
		q4.setLocation(64, 15);
		PicJPanel p4 = new PicJPanel("images/opaque.png");
		p4.setLayout(new GridLayout(4, 1));
		//
		final XJButton x41 = new XJButton("�򵥣�10,000�ң�", 30);
		final XJButton x42 = new XJButton("�еȣ�5,000��)  ", 30);
		final XJButton x43 = new XJButton("���ѣ�200�ң�     ", 30);
		final XJButton x44 = new XJButton("��Ԩ����ѣ�       ", 30);
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
						person.setDifficulty("��");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x42.xb) {
					if (handleMoney(-5000)) {
						i = new IsCharged(isCharged);
						person.setDifficulty("�е�");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x43.xb) {
					if (handleMoney(-200)) {
						i = new IsCharged(isCharged);
						person.setDifficulty("����");
					} else
						i = new IsCharged(isCharged);
				} else {
					if (handleMoney(0)) {
						i = new IsCharged(isCharged);
						person.setDifficulty("��Ԩ");
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
		// �����л��߳�
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
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
									+ Money + "</a></html>");

					// ***********************
					// ������ *
					playSixthStep();
					// ***********************
				} else {
					playFifthStep();
				}

			}
		};
		Question q5 = new Question("��ѡ����ҵ�����");
		mainPanel.add(q5);
		q5.setLocation(69, 20);
		PicJPanel worldMap = new PicJPanel("images/worldMap.png");
		mainPanel.add(worldMap);
		worldMap.setBounds(0, 100, 600, 300);
		worldMap.setLayout(null);
		final XJButton c1 = new XJButton("50,000��", 27);
		final XJButton c2 = new XJButton("20,000��", 27);
		final XJButton c3 = new XJButton("100��", 25);
		final XJButton c4 = new XJButton("20��", 25);
		final XJButton c5 = new XJButton("10��", 25);
		final XJButton c6 = new XJButton("δ��ͨ", 25);
		final XJButton c7 = new XJButton("δ��ͨ", 25);
		final XJButton cChina = new XJButton("��ѣ��ִ�����5�ң�", 25);
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
						person.setCountry("��һ���Ĺ���");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == c2.xb) {
					if (handleMoney(-20000)) {
						i = new IsCharged(isCharged);
						person.setCountry("nbһ���Ĺ���");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == c3.xb) {
					if (handleMoney(-100)) {
						i = new IsCharged(isCharged);
						person.setCountry("��һ���Ĺ���");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == c4.xb) {
					if (handleMoney(-20)) {
						i = new IsCharged(isCharged);
						person.setCountry("20�ҵĹ���");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == c5.xb) {
					if (handleMoney(-10)) {
						i = new IsCharged(isCharged);
						person.setCountry("10�ҵĹ���");
					} else
						i = new IsCharged(isCharged);
				} else {
					if (handleMoney(5)) {
						i = new IsCharged(isCharged);
						person.setCountry("�������ڵĹ���");
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
		// �����л��߳�
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
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
									+ Money + "</a></html>");

					// ***********************
					// ���߲� *
					playSeventhStep();
					// ***********************
				} else {
					playSixthStep();
				}

			}
		};
		Question q6 = new Question("��ѡ�����");
		mainPanel.add(q6);
		q6.setLocation(69, 20);
		PicJPanel contentPanel = new PicJPanel("images/opaque.png");

		contentPanel.setLayout(new GridLayout(4, 1));
		final XJButton x1;
		if (person.getSex() == "�е�")
			x1 = new XJButton("�߸�˧��90,000�ң�", 30);
		else
			x1 = new XJButton("�׸�����90,000�ң�", 30);
		final XJButton x2 = new XJButton("�ٶ�����50,000�ң�", 30);
		final XJButton x3 = new XJButton("��������50,000�ң�", 30);
		final XJButton x4 = new XJButton("��������50,000�ң�", 30);
		final XJButton x5 = new XJButton("�Ұ�������ײͣ�100,000�ң�", 30);
		final XJButton x6 = new XJButton("��˿����ѣ�", 30);
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
						if (person.getSex() == "����")
							person.setFamilyBacground("�׸���");
						else
							person.setFamilyBacground("�߸�˧");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x2.xb
						|| (XB) e.getSource() == x3.xb
						|| (XB) e.getSource() == x4.xb) {
					if (handleMoney(-50000)) {
						i = new IsCharged(isCharged);
						person.setFamilyBacground("��������");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x5.xb) {
					if (handleMoney(-100000)) {
						i = new IsCharged(isCharged);
						person.setFamilyBacground("��ն���");
					} else
						i = new IsCharged(isCharged);
				} else {
					if (handleMoney(0)) {
						i = new IsCharged(isCharged);
						person.setFamilyBacground("��˿����");
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
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
									+ Money + "</a></html>");
					// *************************
					// �ڰ˲�
					playEighthStep();
				} else
					playSeventhStep();

			}
		};
		Question q7 = new Question("��ѡ����Ҫ���ܣ�");
		mainPanel.add(q7);
		q7.setLocation(69, 20);
		PicJPanel opaque = new PicJPanel("images/opaque.png");
		opaque.setBounds(29, 104, 510, 300);
		final XJButton x1 = new XJButton("׬Ǯ��10,000�ң�", 30);
		final XJButton x2;
		if (person.getSex() == "�е�")
			x2 = new XJButton("���ã�10,000�ң�", 30);
		else
			x2 = new XJButton("�Ȼ�10��000�ң�", 30);
		final XJButton x3 = new XJButton("���գ�5,000�ң�", 30);
		final XJButton x4 = new XJButton("���׶�����δ��ͨ��", 30);
		final XJButton x5 = new XJButton("����Ա��δ��ͨ��", 28);
		final XJButton x6 = new XJButton("������1000�ң�", 30);
		final XJButton x7 = new XJButton("���棨5�ң�", 30);
		final XJButton x8 = new XJButton("ɶҲ���ᣨ��ѣ�", 30);
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
						person.setSkill("׬Ǯ ");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x2.xb) {
					if (handleMoney(-10000)) {
						i = new IsCharged(isCharged);
						if (person.getSex() == "�е�")
							person.setSkill("����");
						else
							person.setSkill("�Ȼ�");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x3.xb) {
					if (handleMoney(-5000)) {
						i = new IsCharged(isCharged);
						person.setSkill("�������� ");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x6.xb) {
					if (handleMoney(-1000)) {
						i = new IsCharged(isCharged);
						person.setSkill("���� ");
					} else
						i = new IsCharged(isCharged);
				} else if ((XB) e.getSource() == x7.xb) {
					if (handleMoney(-5)) {
						i = new IsCharged(isCharged);
						person.setSkill("���� ");
					} else
						i = new IsCharged(isCharged);
				} else {
					if (handleMoney(0)) {
						i = new IsCharged(isCharged);
						person.setSkill("ɶҲ���� ");
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
		Question q8 = new Question("��ѡ���㳤�ࣺ");
		mainPanel.add(q8);
		q8.setLocation(69, 5);
		final PicJPanel m1;
		final PicJPanel m2;
		final XJButton x1;
		final XJButton x2;
		final XJButton x3;
		if (person.getSex() == "�е�") {
			m1 = new PicJPanel("images/lc.png");
			m2 = new PicJPanel("images/bl.jpg");
			x1 = new XJButton("�����ײͣ�90,000�ң�", 20);
			x2 = new XJButton("�����ײͣ�100,000�ң�", 20);
			x3 = new XJButton("�������ѣ�", 20);

		} else {
			m1 = new PicJPanel("images/qz.jpg");
			m2 = new PicJPanel("images/mds.png");
			x1 = new XJButton("Ů���ײͣ�90,000�ң�", 20);
			x2 = new XJButton("һ���ײͣ�100,000�ң�", 20);
			x3 = new XJButton("�������ѣ�", 20);

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
								.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
										+ Money + "</a></html>");
						if (person.getSex() == "�е�")
							person.setApparence("images/lc.png");
						else
							person.setApparence("images/qz.jpg");
					}

				} else {
					if (handleMoney(-100000)) {
						RemainMoney
								.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
										+ Money + "</a></html>");
						if (person.getSex() == "�е�")
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
					// �ھŲ�
					playNinethStep();
					// ****************
				} else
					playEighthStep();

			}

		};
		// **************************
		// ΪPicJPanel���mouseListener
		// ***************************

		m1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e2) {

				IsCharged i;
				if (handleMoney(-90000)) {
					if (person.getSex() == "�е�")
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
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
									+ Money + "</a></html>");
					// ********************
					// �ھŲ�
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
					if (person.getSex() == "�е�")
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
							.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
									+ Money + "</a></html>");
					// ********************
					// �ھŲ�
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
		// ���������
		// *********************************
		x1.xb.addActionListener(al8);
		x2.xb.addActionListener(al8);
		x3.xb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				mainPanel.removeAll();
				// **************
				// ��֧
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
				.setText("<html><a style = 'font-size:26px ;color :blue ; '>��� ��</a><a style = 'font-size:24px;color:red;font-family:��������'>"
						+ Money + "</a></html>");
		Question q1 = new Question("����������Ϊ ��");
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
		final XJButton startAgain = new XJButton("�ٴ������100�ң�", 28);
		final XJButton over = new XJButton("�ǳ�����(���)", 28);
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
				// �ھŲ�
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
		Question q9 = new Question("��лʹ�ñ�ϵͳ");
		Question q10 = new Question("�����������Ľ���");
		mainPanel.add(q9);
		mainPanel.add(q10);
		q9.setLocation(0, 10);
		q10.setLocation(55, 70);
		final JTextArea suggestion = new JTextArea("���ڷ�ǰ�ޣ��������ֻص�·", 15, 5);
		suggestion.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		suggestion.setOpaque(false);
		JScrollPane jsp = new JScrollPane(suggestion);
		mainPanel.add(jsp);
		jsp.setBounds(50, 170, 500, 150);
		jsp.setOpaque(false);
		XJButton submit = new XJButton("ȷ��", 25);
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
		JLabel words1 = new JLabel("��Ȼ�����������������ò�ƺ�ǿ������ӡ�");
		JLabel words2 = new JLabel("Ϊ�ˣ�ϵͳ���������һ��");
		Question q10 = new Question("����èצӡ");
		mainPanel.add(words1);
		mainPanel.add(words2);
		words1.setFont(new Font("΢���ź�", Font.PLAIN, 26));
		words2.setFont(new Font("΢���ź�", Font.ITALIC, 28));
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
				JLabel x1 = new JLabel("NOW,ת����ʼ");
				x1.setFont(new Font("΢���ź�", Font.BOLD, 50));
				bac.add(x1);
				x1.setBounds(50, 200, 550, 100);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// **********************
				// ��ʮһ��
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
		String text = "����ǰ�����쳾���Ρ� ĺ���Ϧ,�����޹顣 ������һ����մ��� �ػ����ף�����ת˲ ������|���Ħ�  ǰ�����̣����º��ԡ� ������ת�� ���";
		CGplayString cgs = new CGplayString(text);
		jfm.setGlassPane(cgs);
		cgs.setVisible(true);
		// ******************
		// ���һ����ʮ����
		playTwelvethStep();

	}

	void playTwelvethStep() {
		PicJPanel bac = new PicJPanel("images/opaque.png");

		bac.setLayout(null);
		JLabel text = new JLabel("16����쵽�����֤");
		text.setFont(new Font("΢���ź�", Font.BOLD, 28));
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
		Font font = new Font("��Բ", Font.PLAIN, 15);
		UIManager.put("JLabel.font", font);

		new ZZTT();

	}


}
