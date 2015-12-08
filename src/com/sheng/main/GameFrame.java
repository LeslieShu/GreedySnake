package com.sheng.main;


import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
	protected GamePanel gamePanel;
	protected ShowPanel showPanel;
	private JPanel contentPane;
	public GameFrame(){
		
		gamePanel=new GamePanel(0, 30, 560, 376);
		showPanel=new ShowPanel(0, 30, 560, 30,this);
		Thread gamePanelThread=new Thread(gamePanel);
		Thread showPanelThread=new Thread(showPanel);
		gamePanelThread.start();
		showPanelThread.start();
		
		contentPane=(JPanel) this.getContentPane();
		contentPane.setLayout(null);
		
		contentPane.add(gamePanel);
		contentPane.add(showPanel);
		
//		gamePanel.addKeyListener(new MyKeyListener(gamePanel.snake));
		setUndecorated(true);
		int x=Toolkit.getDefaultToolkit().getScreenSize().width/2-gamePanel.width/2;
		int y=Toolkit.getDefaultToolkit().getScreenSize().height/2-gamePanel.height/2;
		setBounds(x, y, 560, 406);
		setVisible(true);
		setResizable(false);
		setTitle("Ã∞≥‘…ﬂ");
		setIconImage(new ImageIcon(getClass().getResource("GreedySnake.png")).getImage());
		addKeyListener(new MyKeyListener(gamePanel.snake,this));
	}
}
