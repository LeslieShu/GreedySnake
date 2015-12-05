package com.sheng.main;

import java.awt.Point;
import java.util.Random;

public class Food {
	protected Point pos;
	protected int flag;//表示不同的食物，0表示一般食物，只增加长度，着色红；1表示可增加穿身次数食物，着色绿；2表示可增加穿墙次数食物，着色黄
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
		
		/**
		 * 随机产生食物颜色算法：当随机小数范围在0.0到0.2之间产生可穿墙食物；当范围在0.9到1.0之间产生可穿身食物；其余范围产生一般食物
		 * */
		double tmpFlag=new Random().nextDouble();
		if(tmpFlag<0.2){
			flag=2;
		}else if(tmpFlag>=0.2 && tmpFlag<0.9){
			flag=0;
		}else{
			flag=1;
		}
	}
}