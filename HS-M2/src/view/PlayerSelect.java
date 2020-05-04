package view;

import javax.swing.*;
import java.awt.*;

public class PlayerSelect extends JFrame {
	private JPanel heroes;
	private JButton Hunter;
	private JButton Mage;
	private JButton Paladin;
	private JButton Priest;
	private JButton Warlock;
	private mediaplayer m;
	
	public PlayerSelect()
	{
		
		super();
		setBounds(0,0,1500,675);
		setResizable(false);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		heroes= new JPanel();
		heroes.setPreferredSize(new Dimension(this.getWidth(),400));
		Hunter =  new JButton();
		Hunter.setIcon(new ImageIcon("images/Rexxar.png"));
		Hunter.setBackground(Color.black);
		Hunter.setForeground(Color.black);
		Hunter.setFocusPainted(false);
		Hunter.setActionCommand("pHunter");
		m= new mediaplayer();
		Hunter.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        m.playsound("sounds/VoiceLines/hunterSelect.wav");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        m.stopsound();
		    }
		});
		
		 Mage =  new JButton();
		Mage.setIcon(new ImageIcon("images/Jaina Proudmoore.png"));
		Mage.setBackground(Color.black);
		Mage.setForeground(Color.black);
		Mage.setFocusPainted(false);
		Mage.setActionCommand("pMage");
		Mage.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		       m.playsound("sounds/VoiceLines/mageSelect.wav");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        m.stopsound();
		    }
		});
		
		
		Paladin =  new JButton();
		Paladin.setIcon(new ImageIcon("images/Uther Lightbringer.png"));
		Paladin.setBackground(Color.black);
		Paladin.setForeground(Color.black);
		Paladin.setFocusPainted(false);
		Paladin.setActionCommand("pPaladin");
		Paladin.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        m.playsound("sounds/VoiceLines/paladinSelect.wav");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        m.stopsound();
		    }
		});
		
		Priest =  new JButton();
		Priest.setIcon(new ImageIcon("images/Anduin Wrynn.png"));
		Priest.setBackground(Color.black);
		Priest.setForeground(Color.black);
		Priest.setFocusPainted(false);
		Priest.setActionCommand("pPriest");
		Priest.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        m.playsound("sounds/VoiceLines/priestSelect.wav");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        m.stopsound();
		    }
		});
		
		
		
		Warlock =  new JButton();
		Warlock.setIcon(new ImageIcon("images/Gul'dan.png"));
		Warlock.setBackground(Color.black);
		Warlock.setForeground(Color.black);
		Warlock.setFocusPainted(false);
		Warlock.setActionCommand("pWarlock");
		Warlock.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        m.playsound("sounds/VoiceLines/warlockSelect.wav");
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        m.stopsound();
		    }
		});
		
		heroes.setLayout(new GridLayout(0,5));
		heroes.add(Hunter);
		heroes.add(Mage);
		heroes.add(Paladin);
		heroes.add(Priest);
		heroes.add(Warlock);
		
		
		
		
		
		
		add(heroes);
		repaint();
		revalidate();
		
		
	}
	public JPanel getHeroes() {
		return heroes;
	}
	public void setHeroes(JPanel heroes) {
		this.heroes = heroes;
	}
	public JButton getHunter() {
		return Hunter;
	}
	public void setHunter(JButton hunter) {
		Hunter = hunter;
	}
	public JButton getMage() {
		return Mage;
	}
	public void setMage(JButton mage) {
		Mage = mage;
	}
	public JButton getPaladin() {
		return Paladin;
	}
	public void setPaladin(JButton paladin) {
		Paladin = paladin;
	}
	public JButton getPriest() {
		return Priest;
	}
	public void setPriest(JButton priest) {
		Priest = priest;
	}
	public JButton getWarlock() {
		return Warlock;
	}
	public void setWarlock(JButton warlock) {
		Warlock = warlock;
	}
	public static void main(String[] args) {
		
	}

}
