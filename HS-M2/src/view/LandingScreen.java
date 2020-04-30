package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.FlowView.FlowStrategy;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class LandingScreen extends JFrame {
	
	private JLabel main;
	private JButton start;
	public LandingScreen() {
		super();
		setVisible(true);
		setBounds(50,50,1200,675);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		BufferedImage bg = ImageIO.read(new File("images/splashScreen.jpg"));
		main= new JLabel();
		main.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
		main.setIcon(new ImageIcon("images/splashScreen.jpg"));
		
		setLayout(new FlowLayout());
		main.setLayout(null);
		
		add(main);
		start = new JButton();
		start.setActionCommand("Let's GO!");
		start.setBounds(298,490,643,125);
		setResizable(false);
		start.setFont(new Font("Sans Serif",Font.BOLD,13));
		start.setIcon(new ImageIcon("images/playnow.gif"));
		start.setBorderPainted(false);
		start.setFocusPainted(false);
		start.setContentAreaFilled(false);
		start.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		main.add(start);		
		repaint();
		revalidate();
		
		
		
	}
	public JLabel getMain() {
		return main;
	}
	public void setMain(JLabel main) {
		this.main = main;
	}
	public JButton getStart() {
		return start;
	}
	public void setStart(JButton start) {
		this.start = start;
	}
	public static void main(String[] args) {
		LandingScreen L = new LandingScreen();
		
	}
	
	

}
