package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import engine.Game;
import engine.GameListener;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.NotEnoughManaException;
import exceptions.NotYourTurnException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.heroes.*;
import view.*;

public class controller implements GameListener ,ActionListener{
	private Game model;
	private LandingScreen landing;
	private PlayerSelect pselect;
	private OpponentSelect oppselect;
	private ViewGame gameview;
	private JButton selectedplayer;
	private JButton selectedopp;
	private Hero player1;
	private Hero player2;
	private mediaplayer m;
	private ArrayList<JButton> playerHandCards;
	private ArrayList<JButton> opponentHandCards;
	private JButton selectedCard;
	private JButton targetCard;
	private ArrayList<JButton> playerFieldCards;
	private ArrayList<JButton> opponentFieldCards;
	
	public controller() {

		m = new mediaplayer();
		landing = new LandingScreen();
		landing.getStart().addActionListener(this);
		m.playsound("sounds/Main_Title.wav");
		
		pselect = new PlayerSelect();
		
		pselect.getHunter().addActionListener(this);
		pselect.getMage().addActionListener(this);
		pselect.getPaladin().addActionListener(this);
		pselect.getPriest().addActionListener(this);
		pselect.getWarlock().addActionListener(this);
		
		oppselect = new OpponentSelect();
		
		oppselect.getHunter().addActionListener(this);
		oppselect.getMage().addActionListener(this);
		oppselect.getPaladin().addActionListener(this);
		oppselect.getPriest().addActionListener(this);
		oppselect.getWarlock().addActionListener(this);
		
		
		gameview= new ViewGame();
		
		
		playerHandCards = new ArrayList<JButton>();
		opponentHandCards = new ArrayList<JButton>();
		
		playerFieldCards = new ArrayList<JButton>();
		opponentFieldCards = new ArrayList<JButton>();
		
		selectedCard = new JButton();
		targetCard = new JButton();
		
		gameview.getPlayCard().addActionListener(this);
		gameview.getEndTurn().addActionListener(this);
		gameview.getAttack().addActionListener(this);
		gameview.getUsePower().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if(b.getActionCommand().equals("Let's GO!"))
		{
		
		landing.setVisible(false);
		landing.dispose();
		pselect.setVisible(true);
		m.stopsound();
		m.playsound("sounds/selectyourhero.wav");
		m.playsound("sounds/Mulligan.wav");
		JOptionPane.showMessageDialog(pselect, "Player1, Select Your Hero\n click once to select and twice to confirm selection");
		
		
		
		}
		
		if(b==selectedplayer)
		{
			try
			{
			switch(b.getActionCommand()) {
			
			case "pHunter":
				player1= new Hunter();
				break;
			case "pMage":
				player1 = new Mage();
				break;
			case "pPaladin":
				player1= new Paladin();
				break;
			case "pPriest":
					player1= new Priest();
			
				break;
			case "pWarlock":
				player1= new Warlock();
				break;
			default:break;
			}
			}
			catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(pselect, e1.getMessage());
				
			}
			pselect.setVisible(false);
			pselect.dispose();
			oppselect.setVisible(true);
			JOptionPane.showMessageDialog(oppselect, "Player2, Select Your Hero\n click once to select and twice to confirm selection");
			
		}
		if(b==selectedopp)
		{
			try
			{
			switch(b.getActionCommand()) {
			
			case "oHunter":
				player2= new Hunter();
				break;
			case "oMage":
				player2 = new Mage();
				break;
			case "oPaladin":
				player2= new Paladin();
				break;
			case "oPriest":
					player2= new Priest();
			
				break;
			case "oWarlock":
				player2= new Warlock();
				break;
			default:break;
			}
			}
			catch (IOException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(oppselect, e1.getMessage());
				
			}
			oppselect.setVisible(false);
			oppselect.dispose();
			m.stopsound();
			try {
				model = new Game(player1,player2);
				model.setListener(this);
				onPlayerHandUpdated();
				onGameStart();
			} catch (FullHandException | CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(gameview, e1.getMessage());
				
			}
			gameview.setVisible(true);
			refreshtext();
			
			
		}
		if(selectedplayer!=null && b!=selectedplayer)
			selectedplayer.setBackground(Color.black);
		if(selectedopp!=null && b!=selectedopp)
			selectedopp.setBackground(Color.black);
		switch(b.getActionCommand()) {
		
		case "pHunter":
			selectedplayer=b;
			b.setBackground(new Color(0, 150, 15));
			break;
		case "pMage":
			selectedplayer=b;
			b.setBackground(new Color(0, 150, 15));
			break;
		case "pPaladin":
			selectedplayer=b;
			b.setBackground(new Color(0, 150, 15));
			break;
		case "pPriest":
			selectedplayer=b;
			b.setBackground(new Color(0, 150, 15));
			break;
		case "pWarlock":
			selectedplayer=b;
			b.setBackground(new Color(0, 150, 15));
			break;
		case "oHunter":
			selectedopp=b;
			b.setBackground(new Color(0, 150, 15));
			break;
		case "oMage":
			selectedopp=b;
			b.setBackground(new Color(0, 150, 15));
			break;
		case "oPaladin":
			selectedopp=b;
			b.setBackground(new Color(0, 150, 15));
			break;
		case "oPriest":
			selectedopp=b;
			b.setBackground(new Color(0, 150, 15));
			break;
		case "oWarlock":
			selectedopp=b;
			b.setBackground(new Color(0, 150, 15));
			break;
			
		default:break;
		}
		targetCard=b;
		if(b.getActionCommand().equalsIgnoreCase("Play Card")) {
			
			if(playerHandCards.contains(selectedCard)) {
				
				int r = playerHandCards.indexOf(selectedCard);
				Card chosen = model.getCurrentHero().getHand().get(r);
				if(chosen  instanceof Minion)
				{
					
					try {
						model.getCurrentHero().playMinion((Minion) chosen);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(oppselect, e1.getMessage());
						
					}
				}
				
				
				refreshtext();
				onPlayerFieldUpdated();
				onPlayerHandUpdated();
			}
			
			
			
			
		}
		
		selectedCard = b;
		
		
		
		
	}

	@Override
	public void onGameOver() {
		// TODO Auto-generated method stub
		
	}
	public void refreshtext()
	{
		gameview.getPlayerName().setText("***********************************************************"+model.getCurrentHero().getName() +"      HP: "+model.getCurrentHero().getCurrentHP()+"    Current Mana:  "+model.getCurrentHero().getCurrentManaCrystals()+"    Total Mana Crystals:  "+model.getCurrentHero().getTotalManaCrystals()+"***********************************");
		gameview.getOpponentName().setText("*********************************************************"+model.getOpponent().getName() +"      HP: "+model.getOpponent().getCurrentHP()+"    Current Mana:  "+model.getOpponent().getCurrentManaCrystals()+"    Total Mana Crystals:  "+model.getOpponent().getTotalManaCrystals()+"***********************************");
		
		
		gameview.getCurrentHeroHp().setText(model.getCurrentHero().getCurrentHP()+"");
		gameview.getOpponentHeroHp().setText(model.getOpponent().getCurrentHP()+"");
	}
	
	public static void main(String[] args) {
		controller c = new controller();
	}
	
	public void onGameStart() {
		JButton currentHero = new JButton();
		currentHero.setActionCommand("currentHero");
		currentHero.setBounds(0,470,200,250);
		currentHero.setBackground(Color.GREEN);
		currentHero.setForeground(Color.black);
		currentHero.setFocusPainted(false);
		currentHero.setIcon(new ImageIcon("images/"+model.getCurrentHero().getName()+"1.png"));
		gameview.getDecks().add(currentHero);
		currentHero.addActionListener(this);
		currentHero.setLayout(null);
		currentHero.add(gameview.getCurrentHeroHp());
		gameview.getCurrentHeroHp().setText(model.getCurrentHero().getCurrentHP()+"");
		
		
		
		JButton opponentHero = new JButton();
		opponentHero.setBounds(0, 0, 200, 250);
		gameview.getDecks().add(opponentHero);
		opponentHero.setBackground(Color.RED);
		opponentHero.setForeground(Color.black);
		opponentHero.setFocusPainted(false);
		opponentHero.setIcon(new ImageIcon("images/"+model.getOpponent().getName()+"1.png"));
		opponentHero.addActionListener(this);
		opponentHero.setActionCommand("opponentHero");
		opponentHero.setLayout(null);
		opponentHero.add(gameview.getOpponentHeroHp());
		gameview.getOpponentHeroHp().setText(model.getOpponent().getCurrentHP()+"");
		
	}
	public void onPlayerHandUpdated() {
		

		gameview.getPlayerHandCards().removeAll();
		gameview.getOpponentHandCards().removeAll();
		playerHandCards.removeAll(playerHandCards);
		opponentHandCards.removeAll(opponentHandCards);
		
		
		for (Card c : model.getCurrentHero().getHand())
		{
			JButton b = new JButton("<html>"+c.toString().replaceAll("\\n","<br>")+"</html>");
		b.setIcon(new ImageIcon("images/cardBG3.jpg"));
		b.setPreferredSize(new Dimension(100,200));
		b.setForeground(new Color(212,175,55));
			b.setHorizontalTextPosition(JButton.CENTER);
			b.setVerticalTextPosition(JButton.CENTER);
			b.addActionListener(this);
			playerHandCards.add(b);
			gameview.getPlayerHandCards().add(b);
			
			
		}
		
		for (Card c : model.getOpponent().getHand())
		{
			JButton b = new JButton();
			b.setHorizontalTextPosition(JButton.CENTER);
			b.setVerticalTextPosition(JButton.CENTER);
			b.setForeground(new Color(212,175,55));
			b.setPreferredSize(new Dimension(100,200));
			b.setIcon(new ImageIcon("images/cardBG3.jpg"));
			b.addActionListener(this);
			opponentHandCards.add(b);
			gameview.getOpponentHandCards().add(b);
			
			
			
		}
		
		
		
		
		
		
	}
	public void onPlayerFieldUpdated()
	{
		
		gameview.getPlayerField().removeAll();
		gameview.getOpponentField().removeAll();
		playerFieldCards.removeAll(playerFieldCards);
		opponentFieldCards.removeAll(opponentFieldCards);
		
		
		for(Card c : model.getCurrentHero().getField()) {
			
			JButton b = new JButton("<html>"+c.toString().replaceAll("\\n","<br>")+"</html>");
			b.setIcon(new ImageIcon("images/cardBG3.jpg"));
			b.setForeground(new Color(212,175,55));
			b.setPreferredSize(new Dimension(120,200));
			b.setHorizontalTextPosition(JButton.CENTER);
			b.setVerticalTextPosition(JButton.CENTER);
			playerFieldCards.add(b);
			gameview.getPlayerField().add(b);
		}
		
		for (Card c : model.getOpponent().getField())
		{
			JButton b = new JButton("<html>"+c.toString().replaceAll("\\n","<br>")+"</html>");
			b.setHorizontalTextPosition(JButton.CENTER);
			b.setVerticalTextPosition(JButton.CENTER);
			b.setForeground(new Color(212,175,55));
			b.setIcon(new ImageIcon("images/cardBG3.jpg"));
			opponentFieldCards.add(b);
			gameview.getOpponentField().add(b);
			
			
			
		}
		gameview.repaint();
		gameview.revalidate();
		
	}


}
