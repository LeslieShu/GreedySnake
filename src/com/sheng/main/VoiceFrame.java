package com.sheng.main;

import java.awt.Color;
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

public class VoiceFrame extends JFrame {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton bt_upVoice = new JButton();
	JButton bt_downVoice = new JButton();
	JButton bt_sure = new JButton();
	
	JButton bt_one = new JButton();//������ʾ������
	JButton bt_two = new JButton();
	JButton bt_three = new JButton();
	JButton bt_four = new JButton();
	JButton bt_five = new JButton();
	
	// ���ð�ť��ɫ
		Color markOn = Color.RED;
		Color markOff = Color.LIGHT_GRAY;

	

	private int voice;

	VoiceFrame() {
		this.setLayout(null);
//		this.pack();
		this.setTitle("GreedySnake");
		this.setSize(601, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); 
		this.setVisible(true);
		this.setResizable(false);
		

		bt_upVoice.setBounds(new Rectangle(50,150,117,53));
		bt_downVoice.setBounds(new Rectangle(50,250,117,53));
		bt_sure.setBounds(new Rectangle(400,243,178,60));

		
		/*
		 * ���ð�ťͼƬ
		 */
		ImageIcon icon_up = new ImageIcon("E:/GreedySnake/voice/up.png");// ����up��ť��ͼ
		icon_up.getImage();
		Image size_up = icon_up
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(bt_upVoice.getWidth(), bt_downVoice.getHeight(), Image.SCALE_DEFAULT);
		icon_up = new ImageIcon(size_up);
		bt_upVoice.setIcon(icon_up);// ��ͼ
		
		ImageIcon icon_down = new ImageIcon("E:/GreedySnake/voice/down.png");// ����down��ť��ͼ
		icon_up.getImage();
		Image size_down = icon_down
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(bt_upVoice.getWidth(), bt_downVoice.getHeight(), Image.SCALE_DEFAULT);
		icon_down = new ImageIcon(size_down);
		bt_downVoice.setIcon(icon_down);// ��ͼ

		
		ImageIcon icon_sure = new ImageIcon("E:/GreedySnake/voice/sure.png");// ����sure��ť��ͼ
		icon_sure.getImage();
		Image size_sure = icon_sure
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(bt_sure.getWidth(), bt_sure.getHeight(), Image.SCALE_DEFAULT);
		icon_sure = new ImageIcon(size_sure);
		bt_sure.setIcon(icon_sure);// ��ͼ


		/*
		 * ����ͼƬ������
		 */
		ImageIcon img_backGrand = new ImageIcon("E:/GreedySnake/voice/backGrand.jpg");// ���뱳��ͼƬ
		JLabel lab_backGrand = new JLabel(img_backGrand);// ������ͼƬ�����ǩ��
		this.getLayeredPane()
				.add(lab_backGrand, new Integer(Integer.MIN_VALUE));// ����ǩ�ӵ�JFrame��
		lab_backGrand.setBounds(0, 0, this.getWidth(), this.getHeight());// ���ñ�ǩ�Ĵ�Сƥ��JFrame�Ĵ�С
		Container cp = this.getContentPane();
		cp.setLayout(null);// ѡ�񲼾ַ�ʽ��Ϊ���Բ��ַ�ʽ
		((JPanel) cp).setOpaque(false);// �������������ó�͸������ʾ����ͼƬ
		
		bt_one.setBounds(new Rectangle(193,375,40,20));
		bt_two.setBounds(new Rectangle(233,375,40,20));
		bt_three.setBounds(new Rectangle(273,375,40,20));
		bt_four.setBounds(new Rectangle(313,375,40,20));
		bt_five.setBounds(new Rectangle(353,375,40,20));
		
		setVoice(3);
		bt_one.setBackground(markOn);//��Ǳ���ɫ
		bt_two.setBackground(markOn);
		bt_three.setBackground(markOn);
		bt_four.setBackground(markOff);
		bt_five.setBackground(markOff);
		
		bt_upVoice.addActionListener(new buttonListener());//�󶨼�����
		bt_downVoice.addActionListener(new buttonListener());
		bt_sure.addActionListener(new buttonListener());
		
		add(bt_upVoice);
		add(bt_downVoice);
		add(bt_sure);
		
		/*
		 * ������������ð�ť�����棩
		 */
		add(bt_one);
		add(bt_two);
		add(bt_three);
		add(bt_four);
		add(bt_five);
	}

	/*
	 * ��ȡ��ǰ����ֵ
	 */
	public int getVoice() {
		return voice;
	}

	/*
	 * ���õ�ǰ����ֵ
	 */
	public void setVoice(int voice) {
		this.voice = voice;
	}

	class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == bt_upVoice) {
				if(voice >=0 && voice <= 4){
					setVoice(voice + 1);
					paint(voice);
					}
				
			}
			if(e.getSource() == bt_downVoice){
				if(voice >0 && voice <= 5){
				setVoice(voice - 1);
				paint(voice);
				}
			}
			if(e.getSource() == bt_sure){
				dispose();
			}
		}

	}
	
	public void paint(int x){//���ư�ť��ɫ
		
		bt_one.setBackground(markOff);
		bt_two.setBackground(markOff);
		bt_three.setBackground(markOff);
		bt_four.setBackground(markOff);
		bt_five.setBackground(markOff);
		
		switch(x){
		
		case 5:bt_five.setBackground(markOn);
		case 4:bt_four.setBackground(markOn);
		case 3:bt_three.setBackground(markOn);
		case 2:bt_two.setBackground(markOn);
		case 1:bt_one.setBackground(markOn);
		case 0:;
		}
	}

}
