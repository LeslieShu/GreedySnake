package com.sheng.main;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class LevelFrame extends JFrame{
	
	private JButton bt_easy = new JButton("easy");
	private JButton bt_common = new JButton("common");
	private JButton bt_hard = new JButton("hard");
	
	private int level ;//难度变量

	LevelFrame(){
		this.setLayout(null);
		this.pack();
		this.setTitle("GreedySnake");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		bt_easy.setBounds(new Rectangle(this.getWidth()/ 4, this.getHeight() *2/10,200, 50));
		bt_common.setBounds(new Rectangle(this.getWidth()/ 4, this.getHeight() *4/10,200, 50));
		bt_hard.setBounds(new Rectangle(this.getWidth()/ 4, this.getHeight() *6/10,200, 50));
		
		bt_easy.addActionListener(new buttonListener());//绑定监听器
		bt_common.addActionListener(new buttonListener());
		bt_hard.addActionListener(new buttonListener());
		
		add(bt_easy);
		add(bt_common);
		add(bt_hard);
		
		level = 1;//初始化难度为easy
	}
	
	 public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == bt_easy){
				setLevel(1);
				dispose();
			}
			if(e.getSource() == bt_common){
				setLevel(2);
				dispose();
			}
			if(e.getSource() == bt_hard){
				setLevel(3);
				dispose();
			}
			
		}
		
	}
}
