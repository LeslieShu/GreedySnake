package com.sheng.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter {
	protected Snake snake;
	
	MyKeyListener(Snake snake){
		this.snake=snake;
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
		}
	}
}
