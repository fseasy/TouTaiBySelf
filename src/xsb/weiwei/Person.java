package xsb.weiwei;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Person extends JPanel  {
	private String sex;
	private String difficulty;
	private String country;
	private String familyBacground;
	private String skill;
	private String apparence;
	private String previousLifeLastWords;
	InputStream fis;
	InputStream avatar;

	Person() {
		sex = "";
		difficulty = "";
		country = "";
		familyBacground = "";
		skill = "";
		apparence = "";
		previousLifeLastWords = "";
		fis = null;
		avatar = null;
	};

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setFamilyBacground(String familyBacground) {
		this.familyBacground = familyBacground;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public void setApparence(String apparence) {
		this.apparence = apparence;
	}

	public void setPreviousLifeLastWords(String priviousLifeLastWords) {
		this.previousLifeLastWords = priviousLifeLastWords;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		try {
			fis = Person.class.getResourceAsStream("images/IDCard.png");
			avatar = Person.class.getResourceAsStream(apparence) ;
			BufferedImage bfi = ImageIO.read(fis);
			BufferedImage apparenceX = ImageIO.read(avatar);
			Graphics g2Paint = bfi.createGraphics();
			g2.drawImage(bfi, 0, 0, bfi.getWidth(), bfi.getHeight(), this);
			g2.setColor(Color.RED);
			g2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 24));
			g2.drawString(sex, 176, 143);
			g2.drawString(country, 176, 194);
			g2.drawString(familyBacground, 176, 241);
			g2.drawString(skill, 410, 245);
			g2.drawImage(apparenceX, 386, 86, 105, 110, this);

		} catch (Exception e) {
			System.out.println("…Ì∑›÷§Õº∆¨Œ¥’“µΩ") ; 
		}

	}

	
	
}
