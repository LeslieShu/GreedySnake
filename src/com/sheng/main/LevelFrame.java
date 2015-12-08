package com.sheng.main;

import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LevelFrame extends JFrame{
	
	private JButton bt_easy = new JButton();
	private JButton bt_common = new JButton();
	private JButton bt_hard = new JButton();
	
	private int level ;//难度变量

	LevelFrame(){
		this.setLayout(null);
//		this.pack();
		this.setTitle("GreedySnake");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); 
		this.setVisible(true);
		this.setResizable(false);
		
		
		
		bt_easy.setBounds(new Rectangle(205,120,190, 55));
		bt_common.setBounds(new Rectangle(205,200,190, 55));
		bt_hard.setBounds(new Rectangle(205,280,190, 55));
		
		/*
		 * 设置按钮图片
		 */
		ImageIcon icon_easy = new ImageIcon("E:/GreedySnake/level/easy.png");// 载入easy按钮贴图
		icon_easy.getImage();
		Image size_easy = icon_easy
				.getImage()
				.getScaledInstance// 调整贴图大小与按钮大小匹配
				(190,55, Image.SCALE_DEFAULT);
		icon_easy = new ImageIcon(size_easy);
		bt_easy.setIcon(icon_easy);// 贴图

		ImageIcon icon_common = new ImageIcon("E:/GreedySnake/level/common.png");// 载入common按钮贴图
		icon_common.getImage();
		Image size_common = icon_common
				.getImage()
				.getScaledInstance// 调整贴图大小与按钮大小匹配
				(190,55, Image.SCALE_DEFAULT);
		icon_common = new ImageIcon(size_common);
		bt_common.setIcon(icon_common);// 贴图
		
		ImageIcon icon_hard = new ImageIcon("E:/GreedySnake/level/hard.png");// 载入hard按钮贴图
		icon_hard.getImage();
		Image size_hard = icon_hard
				.getImage()
				.getScaledInstance// 调整贴图大小与按钮大小匹配
				(190,55, Image.SCALE_DEFAULT);
		icon_hard = new ImageIcon(size_hard);
		bt_hard.setIcon(icon_hard);// 贴图
		
		/*
		 * 背景图片的设置
		 */
		ImageIcon img_backGrand = new ImageIcon("E:/GreedySnake/level/backGrand.jpg");// 载入背景图片
		JLabel lab_backGrand = new JLabel(img_backGrand);// 将背景图片加入标签内
		this.getLayeredPane()
				.add(lab_backGrand, new Integer(Integer.MIN_VALUE));// 将标签加到JFrame中
		lab_backGrand.setBounds(0, 0, 600, 400);// 设置标签的大小匹配JFrame的大小
		Container cp = this.getContentPane();
		cp.setLayout(null);// 选择布局方式，为绝对布局方式
		((JPanel) cp).setOpaque(false);// 将容器背景设置成透明，显示背景图片
		
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
