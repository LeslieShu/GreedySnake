package com.sheng.main;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VoiceFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton bt_upVoice = new JButton("up");
	JButton bt_downVoice = new JButton("down");
	JButton bt_sure = new JButton("sure");
	
	JButton bt_one = new JButton();//用来显示音量格
	JButton bt_two = new JButton();
	JButton bt_three = new JButton();
	JButton bt_four = new JButton();
	JButton bt_five = new JButton();
	
	// 设置按钮颜色
		Color markOn = Color.RED;
		Color markOff = Color.LIGHT_GRAY;

	

	private int voice;

	VoiceFrame() {
		this.setLayout(null);
//		this.pack();
		this.setTitle("GreedySnake");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); 
		this.setVisible(true);
		this.setResizable(false);
		

		bt_upVoice.setBounds(new Rectangle(this.getWidth() / 4, this.getHeight() * 3 / 6, 60, 60));
		bt_downVoice.setBounds(new Rectangle(this.getWidth() / 4, this.getHeight() * 4 / 6, 60, 60));
		bt_sure.setBounds(new Rectangle(this.getWidth() * 3 / 4, this.getHeight() * 4 / 6, 90, 60));

		
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
		
		bt_one.setBounds(new Rectangle(200,70,10,30));
		bt_two.setBounds(new Rectangle(210,60,10,40));
		bt_three.setBounds(new Rectangle(220,50,10,50));
		bt_four.setBounds(new Rectangle(230,40,10,60));
		bt_five.setBounds(new Rectangle(240,30,10,70));
		
		setVoice(2);
		bt_one.setBackground(markOn);//标记背景色
		bt_two.setBackground(markOn);
		bt_three.setBackground(markOn);
		bt_four.setBackground(markOff);
		bt_five.setBackground(markOff);
		
		bt_upVoice.addActionListener(new buttonListener());//绑定监听器
		bt_downVoice.addActionListener(new buttonListener());
		bt_sure.addActionListener(new buttonListener());
		
		add(bt_upVoice);
		add(bt_downVoice);
		add(bt_sure);
		/*
		 * 添加音量条（用按钮来代替）
		 */
		add(bt_one);
		add(bt_two);
		add(bt_three);
		add(bt_four);
		add(bt_five);
	}

	/*
	 * 获取当前音量值
	 */
	public int getVoice() {
		return voice;
	}

	/*
	 * 设置当前音量值
	 */
	public void setVoice(int voice) {
		this.voice = voice;
	}

	class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == bt_upVoice) {
				if(voice >=0 && voice < 4){
					setVoice(voice + 1);
					}
				
			}
			if(e.getSource() == bt_downVoice){
				if(voice >0 && voice <= 4){
				setVoice(voice - 1);
				}
			}
			if(e.getSource() == bt_sure){
				dispose();
			}
		}

	}

}
