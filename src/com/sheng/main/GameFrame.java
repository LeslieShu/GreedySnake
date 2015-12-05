package com.sheng.main;


import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	protected GamePanel gamePanel;
	protected Snake snake;
	private JPanel contentPane;
	public GameFrame(){
		contentPane=(JPanel) this.getContentPane();
		contentPane.setLayout(null);
		
		snake=new Snake();
		gamePanel=new GamePanel(snake, 400, 400);
		gamePanel.setLayout(null);
		Thread panel=new Thread(gamePanel);
		panel.start();
		
		contentPane.add(gamePanel);
		setUndecorated(true);
		
		int locationX=Toolkit.getDefaultToolkit().getScreenSize().width/2-gamePanel.width/2;
		int locationY=Toolkit.getDefaultToolkit().getScreenSize().height/2-gamePanel.height/2;
		setBounds(locationX, locationY, gamePanel.width, gamePanel.height);
		setVisible(true);
		setResizable(false);
//		setTitle("Ã∞≥‘…ﬂ");
//		setIconImage(new ImageIcon(getClass().getResource("GreedySnake.png")).getImage());
		addKeyListener(new MyKeyListener(snake));
	}
}
