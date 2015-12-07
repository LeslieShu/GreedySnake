package com.sheng.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MyKeyListener extends KeyAdapter {
	protected Snake snake;
	protected GameFrame gameFrame;
	
	MyKeyListener(Snake snake,GameFrame gameFrame){
		this.snake=snake;
		this.gameFrame=gameFrame;
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
			case KeyEvent.VK_DOWN:
				snake.setDirection(2);
				break;
			case KeyEvent.VK_UP:
				snake.setDirection(0);
				break;
			case KeyEvent.VK_LEFT:
				snake.setDirection(3);
				break;
			case KeyEvent.VK_RIGHT:
				snake.setDirection(1);
				break;
			case KeyEvent.VK_SPACE:
				gameFrame.gamePanel.isPaused=!gameFrame.gamePanel.isPaused;
				break;
		}
	}
}
