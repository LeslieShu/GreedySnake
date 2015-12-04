package com.sheng.main;

import java.awt.Point;
import java.util.Random;

public class Food {
	protected Point pos;
	protected Snake snake;
	protected GamePanel gamePanel;
	
	Food(Snake snake,GamePanel gamePanel){
		this.snake=snake;
		this.gamePanel=gamePanel;
		
		/**
		 * 随机产生食物位置算法：随机拿到一个正随机整数对面板宽高进行求模，拿到位置后要进行位置修正，因为每个节点的宽高都是8，那么食物随机出现的位置
		 * 必须是8的倍数，不然会出现错位和蛇吃不到食物的情况，修正的做法是先除以8拿掉小数然后乘以8
		 * */
		Point tmpNode=new Point(1, 1);
		do{
			tmpNode.x=(Math.abs(new Random().nextInt()))%(gamePanel.getWidth());
			tmpNode.y=(Math.abs(new Random().nextInt()))%(gamePanel.getHeight());
			tmpNode.x=tmpNode.x/8*8;
			tmpNode.y=tmpNode.y/8*8;
		}while(snake.head.equals(tmpNode) || snake.body.contains(tmpNode));
		
		pos=tmpNode;
	}
}