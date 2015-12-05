package com.sheng.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 游戏面板，同时作为一个线程存在
 * */

public class GamePanel extends JPanel implements Runnable{
	protected Snake snake;
	protected Food food;
	protected int width,height;
	
	GamePanel(Snake snake,int width,int height){
		this.snake=snake;
		this.width=width;
		this.height=height;
		this.setBounds(0, 0, width, height);
		this.setBackground(Color.GRAY);
	}
	/**
	 * 随机产生食物
	 * */
	public Food createFood(){
		return new Food(snake, this);
	}
	
	/**
	 * 重写面板绘制方法，绘制蛇身和食物
	 * */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		snake.setGamePanel(this);
		g.setColor(Color.BLUE);
		g.fill3DRect(snake.head.x,snake.head.y, 8, 8,true);//绘制蛇头
		
		g.setColor(Color.CYAN);
		Iterator<Point> it=snake.body.iterator();
		Point tmpNode;
		while(it.hasNext()){
			tmpNode=it.next();
			g.fill3DRect(tmpNode.x, tmpNode.y, 8, 8,true);//绘制蛇身的每一个节点
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
			g.fill3DRect(food.pos.x, food.pos.y, 8, 8,true);//绘制食物
		}
	}
	
	/**
	 * 重写线程运行方法：做成死循环，则线程不会终结
	 * 线程每睡眠200ms后开始运行
	 * 蛇身开始运动一次
	 * 如果没有食物或者食物被吃掉则重新绘制食物
	 * 如果出界则调用死亡方法
	 * 如果咬到自己则调用死亡方法
	 * 进行重绘
	 * */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		snake.setGamePanel(this);
		try {
			while(true){
				Thread.sleep(200);
				snake.move();
				
				if(food==null || snake.isEat(food)){
					food=createFood();
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
