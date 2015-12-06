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
//		this.pack();
		this.setTitle("GreedySnake");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); 
		this.setVisible(true);
		this.setResizable(false);
		
//		/*
//		 * 设置按钮图片
//		 */
//		ImageIcon icon_start = new ImageIcon("E:/picture/start.jpg");// 载入按钮贴图
//		icon_start.getImage();
//		Image size = icon_start
//				.getImage()
//				.getScaledInstance// 调整贴图大小与按钮大小匹配
//				(bt_start.getWidth(), bt_start.getHeight(), Image.SCALE_DEFAULT);
//		icon_start = new ImageIcon(size);
//		bt_start.setIcon(icon_start);// 贴图
//
//		/*
//		 * 背景图片的设置
//		 */
//		ImageIcon img_backGrand = new ImageIcon("E:/picture/start.jpg");// 载入背景图片
//		JLabel lab_backGrand = new JLabel(img_backGrand);// 将背景图片加入标签内
//		this.getLayeredPane()
//				.add(lab_backGrand, new Integer(Integer.MIN_VALUE));// 将标签加到JFrame中
//		lab_backGrand.setBounds(0, 0, this.getWidth(), this.getHeight());// 设置标签的大小匹配JFrame的大小
//		Container cp = this.getContentPane();
//		cp.setLayout(null);// 选择布局方式，为绝对布局方式
//		((JPanel) cp).setOpaque(false);// 将容器背景设置成透明，显示背景图片
		
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
