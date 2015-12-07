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
	
	private int level ;//�Ѷȱ���

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
		 * ���ð�ťͼƬ
		 */
		ImageIcon icon_easy = new ImageIcon("E:/GreedySnake/level/easy.png");// ����easy��ť��ͼ
		icon_easy.getImage();
		Image size_easy = icon_easy
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(190,55, Image.SCALE_DEFAULT);
		icon_easy = new ImageIcon(size_easy);
		bt_easy.setIcon(icon_easy);// ��ͼ

		ImageIcon icon_common = new ImageIcon("E:/GreedySnake/level/common.png");// ����common��ť��ͼ
		icon_common.getImage();
		Image size_common = icon_common
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(190,55, Image.SCALE_DEFAULT);
		icon_common = new ImageIcon(size_common);
		bt_common.setIcon(icon_common);// ��ͼ
		
		ImageIcon icon_hard = new ImageIcon("E:/GreedySnake/level/hard.png");// ����hard��ť��ͼ
		icon_hard.getImage();
		Image size_hard = icon_hard
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(190,55, Image.SCALE_DEFAULT);
		icon_hard = new ImageIcon(size_hard);
		bt_hard.setIcon(icon_hard);// ��ͼ
		
		/*
		 * ����ͼƬ������
		 */
		ImageIcon img_backGrand = new ImageIcon("E:/GreedySnake/level/backGrand.jpg");// ���뱳��ͼƬ
		JLabel lab_backGrand = new JLabel(img_backGrand);// ������ͼƬ�����ǩ��
		this.getLayeredPane()
				.add(lab_backGrand, new Integer(Integer.MIN_VALUE));// ����ǩ�ӵ�JFrame��
		lab_backGrand.setBounds(0, 0, 600, 400);// ���ñ�ǩ�Ĵ�Сƥ��JFrame�Ĵ�С
		Container cp = this.getContentPane();
		cp.setLayout(null);// ѡ�񲼾ַ�ʽ��Ϊ���Բ��ַ�ʽ
		((JPanel) cp).setOpaque(false);// �������������ó�͸������ʾ����ͼƬ
		
		bt_easy.addActionListener(new buttonListener());//�󶨼�����
		bt_common.addActionListener(new buttonListener());
		bt_hard.addActionListener(new buttonListener());
		
		add(bt_easy);
		add(bt_common);
		add(bt_hard);
		
		level = 1;//��ʼ���Ѷ�Ϊeasy
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
