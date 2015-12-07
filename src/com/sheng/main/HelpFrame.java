package com.sheng.main;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HelpFrame extends JFrame {

//	private JTextField help = new JTextField();
	private JButton bt_getIt = new JButton();
	HelpFrame(){
		this.setLayout(null);
//		this.pack();
		this.setTitle("GreedySnake");
		this.setSize(601, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); 
		this.setVisible(true);
		this.setResizable(false);
		
//		help.setBounds(0,0,400,200);
		bt_getIt.setBounds(400,300,178,60);
		
		/*
		 * ���ð�ťͼƬ
		 */
		ImageIcon icon_getIt = new ImageIcon("E:/GreedySnake/help/getit.png");// ���밴ť��ͼ
		icon_getIt.getImage();
		Image size_getIt = icon_getIt
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(bt_getIt.getWidth(), bt_getIt.getHeight(), Image.SCALE_DEFAULT);
		icon_getIt = new ImageIcon(size_getIt);
		bt_getIt.setIcon(icon_getIt);// ��ͼ

		/*
		 * ����ͼƬ������
		 */
		ImageIcon img_backGrand = new ImageIcon("E:/GreedySnake/help/backGrand.png");// ���뱳��ͼƬ
		JLabel lab_backGrand = new JLabel(img_backGrand);// ������ͼƬ�����ǩ��
		this.getLayeredPane()
				.add(lab_backGrand, new Integer(Integer.MIN_VALUE));// ����ǩ�ӵ�JFrame��
		lab_backGrand.setBounds(0, 0, this.getWidth(), this.getHeight());// ���ñ�ǩ�Ĵ�Сƥ��JFrame�Ĵ�С
		Container cp = this.getContentPane();
		cp.setLayout(null);// ѡ�񲼾ַ�ʽ��Ϊ���Բ��ַ�ʽ
		((JPanel) cp).setOpaque(false);// �������������ó�͸������ʾ����ͼƬ
		
//		help.setText("���ǰ����ĵ������������󱿵�");
		
		bt_getIt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == bt_getIt){
					dispose();
				}
			}
			
		});
		
//		add(help);
		add(bt_getIt);
		
	}
}
