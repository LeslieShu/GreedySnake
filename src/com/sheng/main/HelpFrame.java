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
		
		help.setText("���ǰ����ĵ������������󱿵�");
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
