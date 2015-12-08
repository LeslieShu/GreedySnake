package com.sheng.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener{
	protected GameFrame gameFrame;
	
	MyActionListener(GameFrame gameFrame){
		this.gameFrame=gameFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()){
		case "exit":
			System.exit(0);
			break;
		case "pause":
			gameFrame.gamePanel.isPaused=true;
			break;
		case "continue":
			gameFrame.gamePanel.isPaused=false;
			break;
		}
	}

}
