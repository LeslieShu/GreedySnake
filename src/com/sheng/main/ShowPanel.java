package com.sheng.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ShowPanel extends JPanel implements Runnable{
	protected int x,y,width,height;
	protected MyActionListner myActionListener;
	protected JLabel score,bodyThgh,wallThgh,level;
	protected JButton btnPause,btnContinue,btnExit;
	protected GameFrame gameFrame;
	
	ShowPanel(int x,int y,int width,int height,GameFrame gameFrame){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.gameFrame=gameFrame;
		this.myActionListener=new MyActionListner(this.gameFrame);
				
		this.setBackground(new Color(100, 149, 237));
		this.setBorder(new LineBorder(new Color(0, 0, 128)));
		this.setBounds(0, 0, 560, 30);
		this.setLayout(null);
		
		//score = new JLabel("Score : "+this.gameFrame.gamePanel.snake.score);		//得分之后可以动态改变
		score = new JLabel();
		score.setFont(new Font("宋体", Font.BOLD, 10));
		score.setBounds(0, 0, 90, 30);
		this.add(score);
		
		bodyThgh = new JLabel();
		bodyThgh.setFont(new Font("宋体", Font.BOLD, 10));
		bodyThgh.setBounds(95, 0, 90, 30);
		this.add(bodyThgh);
		
		wallThgh = new JLabel("WallThgh : "+this.gameFrame.gamePanel.snake.throughWall);
		wallThgh.setFont(new Font("宋体", Font.BOLD, 10));
		wallThgh.setBounds(190, 0, 90, 30);
		this.add(wallThgh);
		
		level = new JLabel();
		level.setFont(new Font("宋体", Font.BOLD, 10));
		level.setBounds(280, 0, 90, 30);
		this.add(level);
		
		btnPause = new JButton("pau");
		btnPause.setLayout(null);
		btnPause.setFont(new Font("宋体", Font.PLAIN, 9));
		btnPause.setBounds(400, 2, 50, 26);
		btnPause.setActionCommand("pause");
		btnPause.addActionListener(myActionListener);
		btnPause.setFocusable(false);
		this.add(btnPause);
		
		btnContinue = new JButton("con");
		btnContinue.setFont(new Font("宋体", Font.PLAIN, 9));
		btnContinue.setBounds(455, 2, 50, 26);
		btnContinue.setActionCommand("continue");
		btnContinue.addActionListener(myActionListener);
		btnContinue.setFocusable(false);
		this.add(btnContinue);
		
		btnExit = new JButton("ext");
		btnExit.setFont(new Font("宋体", Font.PLAIN, 9));
		btnExit.setBounds(510, 2, 50, 26);
		btnExit.setActionCommand("exit");
		btnExit.addActionListener(myActionListener);
		btnExit.setFocusable(false);
		this.add(btnExit);
		this.setFocusable(false);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			score.setText("Score : "+this.gameFrame.gamePanel.snake.score);
			bodyThgh.setText("BodyThgh : "+this.gameFrame.gamePanel.snake.throughBody);
			wallThgh.setText("WallThgh : "+this.gameFrame.gamePanel.snake.throughWall);
			
			switch(this.gameFrame.gamePanel.snake.level){
			case 1:
				level.setText("Level : Primary");
				break;
			case 2:
				level.setText("Level : Middle");
				break;
			case 3:
				level.setText("Level : High");
				break;
			}
			
		}
	}
}
