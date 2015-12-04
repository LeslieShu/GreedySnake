package com.sheng.main;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
	protected GamePanel gamePanel;
	protected Snake snake;
	public GameFrame(){
		snake=new Snake();
		gamePanel=new GamePanel(snake, 400, 400);
		Thread panel=new Thread(gamePanel);
		panel.start();
		
		add(gamePanel);
		setBounds(550, 300, gamePanel.width, gamePanel.height);
		setVisible(true);
		setResizable(false);
		setTitle("Ã∞≥‘…ﬂ");
		setIconImage(new ImageIcon(getClass().getResource("GreedySnake.png")).getImage());
		addKeyListener(new MyKeyListener(snake));
	}
}
