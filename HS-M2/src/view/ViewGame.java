package view;

import javax.swing.*;
import java.awt.*;
public class ViewGame extends JFrame {
	private JLabel Container;
	private JLabel playerHand;
	private JLabel playerField;
	private JLabel opponentHand;
	private JLabel opponentField;
	private JTextPane playerName;
	private JTextPane opponentName;
	private JLabel Decks;
	private JLabel Area;
	private JLabel playerHandCards;
	private JLabel opponentHandCards;
	private JButton Attack;
	private JButton endTurn;
	private JButton playCard;
	private JButton usePower;
	private JLabel userButtons;
	public ViewGame()
	{
		super();
		setBounds(100,0,1200,750);
		setResizable(false);
		setTitle("HearthStone");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// initialize fields
		
		Container = new JLabel();
		playerHand = new JLabel();
		playerField = new JLabel();
		opponentHand = new JLabel();
		opponentField = new JLabel();
		Decks = new JLabel();
		playerName = new JTextPane();
		opponentName = new JTextPane();
		Area= new JLabel();
		setLayout(new BorderLayout());
		
		playerHandCards = new JLabel();
		opponentHandCards = new JLabel();
		//setting sizes
		
		playerHand.setPreferredSize(new Dimension(1000,getHeight()/4-25));
		
		
		playerField.setPreferredSize(new Dimension(1000,getHeight()/4));
		opponentField.setPreferredSize(new Dimension(1000,getHeight()/4));
		opponentHand.setPreferredSize(new Dimension(1000,getHeight()/4-25));
				
		
		playerName.setPreferredSize(new Dimension(1000,25));
		playerName.setEditable(false);
		playerName.setBackground(new Color(48,71,94));
		playerName.setForeground(Color.white);
		opponentName.setPreferredSize(new Dimension(1000,25));
		opponentName.setEditable(false);
		opponentName.setBackground(new Color(48,71,94));
		opponentName.setForeground(Color.white);
		Decks.setPreferredSize(new Dimension(200,getHeight()));
		userButtons = new JLabel();
		
		
		playerHand.setLayout(new BorderLayout());
		opponentHand.setLayout(new BorderLayout());
		
		
		Area.setLayout(new GridLayout(4,1));
		Area.add(opponentHand);
		playerHand.add(playerName,BorderLayout.SOUTH);
		opponentHand.add(opponentName,BorderLayout.NORTH);
		Area.add(opponentField);
		Area.add(playerField);
		Area.add(playerHand);
		
		Container.setPreferredSize(new Dimension(1200,750));
		Container.setIcon(new ImageIcon("images/playground.jpg"));
		Container.setLayout(new BorderLayout());
		Container.add(Area,BorderLayout.CENTER);
		Container.add(Decks,BorderLayout.EAST);
		add(Container);
		
		
		
		Attack = new JButton("Attack");
		Attack.setBackground(new Color(35, 143, 101));
		endTurn = new JButton("End Turn");
		endTurn.setBackground(new Color(35, 143, 101));
		playCard = new JButton("Play Card");
		playCard.setBackground(new Color(35, 143, 101));
		usePower = new JButton("Use Hero Power");
		usePower.setBackground(new Color(120,24,155));
		usePower.setForeground(Color.white);
		
		
		userButtons.setLayout(new FlowLayout());
		userButtons.add(Attack);
		userButtons.add(playCard);
		userButtons.add(usePower);
		userButtons.add(endTurn);
		Decks.setLayout(null);
		userButtons.setBounds(10,280,200,200);
		Decks.add(userButtons);
		
		
		
		
		playerHandCards.setPreferredSize(new Dimension(1000,playerHand.getHeight()-25));
		playerHandCards.setLayout(new GridLayout(0,10));
		playerHand.add(playerHandCards,BorderLayout.CENTER);
		
		
		opponentHandCards.setPreferredSize(new Dimension(1000,opponentHand.getHeight()-25));
		opponentHandCards.setLayout(new GridLayout(0,10));
		opponentHand.add(opponentHandCards,BorderLayout.CENTER);
		
		
		
		playerField.setLayout(new GridLayout(0,7));
		opponentField.setLayout(new GridLayout(0,7));
		
		
		
		revalidate();
		repaint();
		
	}
public JButton getAttack() {
		return Attack;
	}
	public void setAttack(JButton attack) {
		Attack = attack;
	}
	public JButton getEndTurn() {
		return endTurn;
	}
	public void setEndTurn(JButton endTurn) {
		this.endTurn = endTurn;
	}
	public JButton getPlayCard() {
		return playCard;
	}
	public void setPlayCard(JButton playCard) {
		this.playCard = playCard;
	}
	public JButton getUsePower() {
		return usePower;
	}
	public void setUsePower(JButton usePower) {
		this.usePower = usePower;
	}
	public JLabel getUserButtons() {
		return userButtons;
	}
	public void setUserButtons(JLabel userButtons) {
		this.userButtons = userButtons;
	}
public JLabel getOpponentHandCards() {
		return opponentHandCards;
	}
	public void setOpponentHandCards(JLabel opponentHandCards) {
		this.opponentHandCards = opponentHandCards;
	}
public JLabel getPlayerHandCards() {
		return playerHandCards;
	}
	public void setPlayerHandCards(JLabel playerHandCards) {
		this.playerHandCards = playerHandCards;
	}
public void setContainer(JLabel container) {
		Container = container;
	}
	public void setPlayerHand(JLabel playerHand) {
		this.playerHand = playerHand;
	}
	public void setPlayerField(JLabel playerField) {
		this.playerField = playerField;
	}
	public void setOpponentHand(JLabel opponentHand) {
		this.opponentHand = opponentHand;
	}
	public void setOpponentField(JLabel opponentField) {
		this.opponentField = opponentField;
	}
	public void setPlayerName(JTextPane playerName) {
		this.playerName = playerName;
	}
	public void setOpponentName(JTextPane opponentName) {
		this.opponentName = opponentName;
	}
	public JLabel getContainer() {
		return Container;
	}
	public JLabel getPlayerHand() {
		return playerHand;
	}
	public JLabel getPlayerField() {
		return playerField;
	}
	public JLabel getOpponentHand() {
		return opponentHand;
	}
	public JLabel getOpponentField() {
		return opponentField;
	}
	public JTextPane getPlayerName() {
		return playerName;
	}
	public JTextPane getOpponentName() {
		return opponentName;
	}
	public JLabel getDecks() {
		return Decks;
	}
	public JLabel getArea() {
		return Area;
	}
	public void setDecks(JLabel decks) {
		Decks = decks;
	}
	public void setArea(JLabel area) {
		Area = area;
	}
	//	  protected void paintComponent(Graphics g) {
//
//	    super.paintComponent(g);
//	        g.drawImage(bgImage, 0, 0, null);
//	}
	public static void main(String[] args) {
		
		ViewGame view = new ViewGame();
	}

}
