package com.sheng.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * ��Ϸ��壬ͬʱ��Ϊһ���̴߳���
 * */

public class GamePanel extends JPanel implements Runnable{
	protected Snake snake;
	protected Food food;
	protected boolean isPaused;//��ͣ��־
	protected int x,y,width,height;//����Ϸ���Ҫ���״̬��壬����Ϸ���ĳ�ʼλ����Ҫ�ı䣬�����x,y����
	
	GamePanel(int x,int y,int width,int height){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.isPaused=false;
		this.setBounds(this.x, this.y, this.width, this.height);
		this.setBackground(new Color(143, 188, 143));
		this.setLayout(null);
		this.setBorder(new LineBorder(new Color(0, 0, 128)));
		addSnake(new Snake(this));
	}
	/**
	 * Ϊ������һ����
	 * */
	public void addSnake(Snake snake){
		this.snake=snake;
	}
	
	/**
	 * �������ʳ��
	 * */
	public Food createFood(){
		return new Food(snake, this);
	}
	
	/**
	 * ��д�����Ʒ��������������ʳ��
	 * */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fill3DRect(snake.head.x,snake.head.y, 8, 8,true);//������ͷ
		
		g.setColor(Color.CYAN);
		Iterator<Point> it=snake.body.iterator();
		Point tmpNode;
		while(it.hasNext()){
			tmpNode=it.next();
			g.fill3DRect(tmpNode.x, tmpNode.y, 8, 8,true);//���������ÿһ���ڵ�
		}
		
		if(food!=null){
			switch(food.flag){
			case 0:
				g.setColor(Color.RED);
				break;
			case 1:
				g.setColor(Color.GREEN);
				break;
			case 2:
				g.setColor(Color.YELLOW);
				break;
			}
			g.fill3DRect(food.pos.x, food.pos.y, 8, 8,true);//����ʳ��
		}
	}
	
	/**
	 * ��д�߳����з�����������ѭ�������̲߳����ս�
	 * �߳�ÿ˯��200ms��ʼ����
	 * ����ʼ�˶�һ��
	 * ���û��ʳ�����ʳ�ﱻ�Ե������»���ʳ��
	 * ��������������������
	 * ���ҧ���Լ��������������
	 * �����ػ�
	 * */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				//������Ϸ�����������߳�˯��ʱ��ĳ���
				switch(snake.level){
				case 1:
					Thread.sleep(200);
					break;
				case 2:
					Thread.sleep(150);
					break;
				case 3:
					Thread.sleep(100);
					break;
				}
				
				if(!isPaused){
					snake.move();
				}
				
				if(food==null || snake.isEat(food)){
					food=createFood();
				}
				//���м��������
				if(snake.score>10 && snake.score<=20){
					snake.level=2;
				}else if(snake.score>20){
					snake.level=3;
				}
				
				if(snake.isOut()){
					snake.dead();
				}
				
				if(snake.isPitch()){
					if(snake.throughBody==0){
						snake.dead();
					}
					snake.throughBody--;
				}
				
				repaint();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
