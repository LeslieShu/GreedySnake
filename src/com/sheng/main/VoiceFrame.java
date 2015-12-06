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
//		 * ���ð�ťͼƬ
//		 */
//		ImageIcon icon_start = new ImageIcon("E:/picture/start.jpg");// ���밴ť��ͼ
//		icon_start.getImage();
//		Image size = icon_start
//				.getImage()
//				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
//				(bt_start.getWidth(), bt_start.getHeight(), Image.SCALE_DEFAULT);
//		icon_start = new ImageIcon(size);
//		bt_start.setIcon(icon_start);// ��ͼ
//
//		/*
//		 * ����ͼƬ������
//		 */
//		ImageIcon img_backGrand = new ImageIcon("E:/picture/start.jpg");// ���뱳��ͼƬ
//		JLabel lab_backGrand = new JLabel(img_backGrand);// ������ͼƬ�����ǩ��
//		this.getLayeredPane()
//				.add(lab_backGrand, new Integer(Integer.MIN_VALUE));// ����ǩ�ӵ�JFrame��
//		lab_backGrand.setBounds(0, 0, this.getWidth(), this.getHeight());// ���ñ�ǩ�Ĵ�Сƥ��JFrame�Ĵ�С
//		Container cp = this.getContentPane();
//		cp.setLayout(null);// ѡ�񲼾ַ�ʽ��Ϊ���Բ��ַ�ʽ
//		((JPanel) cp).setOpaque(false);// �������������ó�͸������ʾ����ͼƬ
		
		bt_one.setBounds(new Rectangle(200,70,10,30));
		bt_two.setBounds(new Rectangle(210,60,10,40));
		bt_three.setBounds(new Rectangle(220,50,10,50));
		bt_four.setBounds(new Rectangle(230,40,10,60));
		bt_five.setBounds(new Rectangle(240,30,10,70));
		
		setVoice(2);
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
