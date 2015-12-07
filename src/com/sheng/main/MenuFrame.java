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
public class MenuFrame extends JFrame {

	private JButton bt_start = new JButton();
	private JButton bt_voice = new JButton();
	private JButton bt_exit = new JButton();
	private JButton bt_help = new JButton();
	private JButton bt_level = new JButton();

	public MenuFrame() {// ��ʼ����ܺ���
		this.setLayout(null);
		// this.pack();//�Զ����ÿ�ܴ�С���Լ��ڿ��з��������ֻ����ȥ���˺���������ȥJFrame�Ŀ�
		this.setTitle("GreedySnake");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); // ��ȥ�߿�
		this.setVisible(true);
		this.setResizable(false);

		bt_start.setBounds(new Rectangle(408,100,130,218));// ���ð�ť�����menu_subPanel��λ�úʹ�С);
		bt_voice.setBounds(new Rectangle(37,50,159,61));
		bt_exit.setBounds(new Rectangle(37,130,159,61));
		bt_help.setBounds(new Rectangle(37,210,159,61));
		bt_level.setBounds(new Rectangle(37,290,159,61));

		/*
		 * ���ð�ťͼƬ
		 */
		ImageIcon icon_start = new ImageIcon("E:/GreedySnake/menu/start.png");// ����start��ť��ͼ
		icon_start.getImage();
		Image size_start = icon_start
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(136, 218, Image.SCALE_DEFAULT);
		icon_start = new ImageIcon(size_start);
		bt_start.setIcon(icon_start);// ��ͼ
		
		ImageIcon icon_voice = new ImageIcon("E:/GreedySnake/menu/voice.png");// ����voice��ť��ͼ
		icon_voice.getImage();
		Image size_voice = icon_voice
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(icon_voice.getIconWidth(),icon_voice.getIconHeight(), Image.SCALE_DEFAULT);
		icon_voice = new ImageIcon(size_voice);
		bt_voice.setIcon(icon_voice);// ��ͼ

		
		ImageIcon icon_exit = new ImageIcon("E:/GreedySnake/menu/exit.png");// ����exit��ť��ͼ
		icon_exit.getImage();
		Image size_exit = icon_exit
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(icon_exit.getIconWidth(),icon_exit.getIconHeight(), Image.SCALE_DEFAULT);
		icon_exit = new ImageIcon(size_exit);
		bt_exit.setIcon(icon_exit);// ��ͼ

		
		ImageIcon icon_help = new ImageIcon("E:/GreedySnake/menu/help.png");// ����help��ť��ͼ
		icon_help.getImage();
		Image size_help = icon_help
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(icon_help.getIconWidth(),icon_help.getIconHeight(), Image.SCALE_DEFAULT);
		icon_help = new ImageIcon(size_help);
		bt_help.setIcon(icon_help);// ��ͼ

		
		ImageIcon icon_level = new ImageIcon("E:/GreedySnake/menu/level.png");// ����level��ť��ͼ
		icon_level.getImage();
		Image size_level = icon_level
				.getImage()
				.getScaledInstance// ������ͼ��С�밴ť��Сƥ��
				(icon_level.getIconWidth(),icon_level.getIconHeight(), Image.SCALE_DEFAULT);
		icon_level = new ImageIcon(size_level);
		bt_level.setIcon(icon_level);// ��ͼ


		/*
		 * ����ͼƬ������
		 */
		ImageIcon img_backGrand = new ImageIcon("E:/GreedySnake/menu/menu.jpg");// ���뱳��ͼƬ
		JLabel lab_backGrand = new JLabel(img_backGrand);// ������ͼƬ�����ǩ��
		this.getLayeredPane()
				.add(lab_backGrand, new Integer(Integer.MIN_VALUE));// ����ǩ�ӵ�JFrame��
		lab_backGrand.setBounds(0, 0, 600, 400);// ���ñ�ǩ�Ĵ�Сƥ��JFrame�Ĵ�С
		Container cp = this.getContentPane();
		cp.setLayout(null);// ѡ�񲼾ַ�ʽ��Ϊ���Բ��ַ�ʽ
		((JPanel) cp).setOpaque(false);// �������������ó�͸������ʾ����ͼƬ

		add(bt_start);
		add(bt_voice);
		add(bt_exit);
		add(bt_help);
		add(bt_level);

		bt_start.addActionListener(new ButtonActionListener());// �󶨰�ť������
		bt_voice.addActionListener(new ButtonActionListener());
		bt_exit.addActionListener(new ButtonActionListener());
		bt_help.addActionListener(new ButtonActionListener());
		bt_level.addActionListener(new ButtonActionListener());
	}

	class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bt_start) {
				start();
			}
			if (e.getSource() == bt_voice) {
				VoiceFrame voiceFrame = new VoiceFrame();
			}
			if (e.getSource() == bt_exit) {
				exit();// �˳���Ϸ
			}
			if (e.getSource() == bt_help) {
				help();
			}
			if (e.getSource() == bt_level) {
				LevelFrame levelFrame = new LevelFrame();
			}
		}

		private void help() {
			// TODO Auto-generated method stub
			HelpFrame help = new HelpFrame();

		}

		private boolean exit() {// �˳�����
			// TODO Auto-generated method stub
			dispose();
			return false;

		}

		private void start() {
			// TODO Auto-generated method stub
			dispose();
			new GameFrame();// ��ʼ��Ϸ��������ʢ��д�ĺ���
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuFrame menuFrame = new MenuFrame();

	}

}
