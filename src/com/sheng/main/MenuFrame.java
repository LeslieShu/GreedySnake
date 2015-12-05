package com.sheng.main;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MenuFrame extends JFrame {

	private JButton bt_start = new JButton("start");
	private JButton bt_voice = new JButton("voice");
	private JButton bt_exit  = new JButton("exit");
	private JButton bt_help  = new JButton("help");
	private JButton bt_level = new JButton("level");

	public MenuFrame() {//��ʼ����ܺ���
		this.setLayout(null);
		this.pack();
		this.setTitle("GreedySnake");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
	

		bt_start.setBounds(new Rectangle(this.getWidth()/ 4, this.getHeight() *2/10,200, 50));// ���ð�ť�����menu_subPanel��λ�úʹ�С);
		bt_voice.setBounds(new Rectangle(this.getWidth()/ 4, this.getHeight() *4/10,200, 50));
		bt_exit.setBounds(new Rectangle(this.getWidth()/ 4, this.getHeight() *6/10,200, 50));
		bt_help.setBounds(new Rectangle(this.getWidth()/ 4, this.getHeight() *30/40,100, 50));
		bt_level.setBounds(new Rectangle(this.getWidth()*2/4, this.getHeight() *30/40,100, 50));
		
		add(bt_start);
		add(bt_voice);
		add(bt_exit);
		add(bt_help);
		add(bt_level);
		
		bt_start.addActionListener(new ButtonActionListener());//�󶨰�ť������
		bt_voice.addActionListener(new ButtonActionListener());
		bt_exit.addActionListener(new ButtonActionListener());
		bt_help.addActionListener(new ButtonActionListener());
		bt_level.addActionListener(new ButtonActionListener());
	}

    class ButtonActionListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if(e.getSource() == bt_start){
    			start();
    		}
    		if(e.getSource() == bt_voice){
    			VoiceFrame voiceFrame = new VoiceFrame();
    		}
    		if(e.getSource() == bt_exit){
    			exit();//�˳���Ϸ
    		}
    		if(e.getSource() == bt_help){
    			help();
    		}
    		if(e.getSource() == bt_level){
    			LevelFrame levelFrame = new LevelFrame();
    		}
    	}

		private void help() {
			// TODO Auto-generated method stub
			HelpFrame help =new HelpFrame();
			
		}

		private boolean exit() {//�˳�����
			// TODO Auto-generated method stub
			dispose();
			return false;
			
		}

		private  void start() {
			// TODO Auto-generated method stub
			dispose();
			new GameFrame();//��ʼ��Ϸ��������ʢ��д�ĺ���
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuFrame menuFrame = new MenuFrame();
		
	}

}
