package com.sheng.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HelpFrame extends JFrame {

	private JTextField help = new JTextField();
	private JButton bt_getIt = new JButton("get it");
	HelpFrame(){
		this.setLayout(null);
		this.pack();
		this.setTitle("GreedySnake");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		help.setText("这是帮助文档，用来帮助大笨蛋");
		bt_getIt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == bt_getIt){
					dispose();
				}
			}
			
		});
		help.setBounds(0,0,400,200);
		bt_getIt.setBounds(100,300,200,30);
		add(help);
		add(bt_getIt);
		
	}
}
