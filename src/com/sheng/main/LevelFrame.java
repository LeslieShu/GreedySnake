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
	
	private JButton bt_easy = new JButton("easy");
	private JButton bt_common = new JButton("common");
	private JButton bt_hard = new JButton("hard");
	
	private int level ;//�Ѷȱ���

	LevelFrame(){
		this.setLayout(null);
//		this.pack();
		this.setTitle("GreedySnake");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); 
		this.setVisible(true);
		this.setResizable(false);
		
		bt_easy.setBounds(new Rectangle(this.getWidth()/ 4, this.getHeight() *2/10,200, 50));
		bt_common.setBounds(new Rectangle(this.getWidth()/ 4, this.getHeight() *4/10,200, 50));
		bt_hard.setBounds(new Rectangle(this.getWidth()/ 4, this.getHeight() *6/10,200, 50));
		
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
