package com.sheng.main;

import java.awt.Point;
import java.util.LinkedList;

public class Snake {
	protected Point head;
	protected LinkedList<Point> body;
	protected int length;
	protected int throughWall;//可穿墙属性
	protected int throughBody;//可穿身属性
	protected GamePanel gamePanel;
	protected int direction;	
	
	Snake(){
		head=new Point(4*8, 0);
		body=new LinkedList<Point>();
		body.add(new Point(3*8, 0));
		body.add(new Point(2*8, 0));
		body.add(new Point(1*8, 0));
		body.add(new Point(0*8, 0));
		length=5;
		direction=1;
		throughWall=0;
		throughBody=0;
		gamePanel=null;
	}
	/**
	 * 设置蛇所在游戏面板
	 * */
	public void setGamePanel(GamePanel gamePanel){
		this.gamePanel=gamePanel;
	}
	
	/**
	 * 设置蛇的运动方向
	 * */
	public void setDirection(int direction){
		this.direction=direction;
	}
	/**
	 * 是否吃到食物。
	 * 算法：每次保留住最后一个节点，当蛇头与食物重合，则将保留节点加入蛇尾，同时长度加1，返回true。
	 * */
	public boolean isEat(Food food){
		Point tmpNode=this.body.getLast();
		if(head.equals(food.pos)){
			
			//若吃到特殊食物可增加相应技能
			if(food.flag==1){
				throughBody++;
			}else if(food.flag==2){
				throughWall++;
			}
			
			body.add(tmpNode);
			length++;
			return true;
		}
		return false;
	}
	/**
	 * 移动算法：每次移动按照最新移动方向新建临时头结点，然后新建临时身体链表，从原来头节点依次加入节点，去掉原来身体链表的最后一个节点，
	 * 然后将蛇头和蛇身重新指向新建蛇头和蛇身，完成一次移动
	 * */
	public void move(){
		Point tmpHeadNode=new Point(0,0);
		Point tmpBodyNode;
		LinkedList<Point> tmpBody=new LinkedList<Point>();
		switch(direction){
		case 0:
			tmpHeadNode=new Point(head.x,head.y-8);
			if(tmpHeadNode.y<0 && throughWall>0){					//若出界则加上相应高度在对边出现，下面的移动原理同此
				tmpHeadNode.y+=gamePanel.height;
				throughWall--;
			}
			tmpBody.add(head);
			for(int i=0;i<body.size()-1;i++){
				tmpBodyNode=body.get(i);
				if(tmpBodyNode.y<0){
					tmpBodyNode.y+=gamePanel.height;
				}
				tmpBody.add(tmpBodyNode);
			}
			break;
		case 1:
			tmpHeadNode=new Point(head.x+8,head.y);
			if(tmpHeadNode.x>=gamePanel.width && throughWall>0){
				tmpHeadNode.x-=gamePanel.width;
				throughWall--;
			}
			tmpBody.add(head);
			for(int i=0;i<body.size()-1;i++){
				tmpBodyNode=body.get(i);
				if(tmpBodyNode.x>=gamePanel.width){
					tmpBodyNode.x-=gamePanel.width;
				}
				tmpBody.add(tmpBodyNode);
			}
			break;
		case 2:
			tmpHeadNode=new Point(head.x,head.y+8);
			if(tmpHeadNode.y>=gamePanel.height && throughWall>0){
				tmpHeadNode.y-=gamePanel.height;
				throughWall--;
			}
			tmpBody.add(head);
			for(int i=0;i<body.size()-1;i++){
				tmpBodyNode=body.get(i);
				if(tmpBodyNode.y>=gamePanel.height){
					tmpBodyNode.y-=gamePanel.height;
				}
				tmpBody.add(tmpBodyNode);
			}
			break;
		case 3:
			tmpHeadNode=new Point(head.x-8,head.y);
			if(tmpHeadNode.x<0 && throughWall>0){
				tmpHeadNode.x+=gamePanel.width;
				throughWall--;
			}
			tmpBody.add(head);
			for(int i=0;i<body.size()-1;i++){
				tmpBodyNode=body.get(i);
				if(tmpBodyNode.x<0){
					tmpBodyNode.x+=gamePanel.width;
				}
				tmpBody.add(tmpBodyNode);
			}
			break;
		}
		head=tmpHeadNode;
		body=tmpBody;
	}
	/**
	 * 是否出界
	 * */
	public boolean isOut(){
		if(head.x>gamePanel.width || head.x<0 || head.y <0 || head.y >gamePanel.height){
			return true;
		}
		return false;
	}
	/**
	 * 是否咬到自己
	 * */
	public boolean isPitch(){
		if(body.contains(head)){//当身体节点包括头部节点判断为咬到自己
			return true;
		}
		return false;
	}
	/**
	 * 死亡方法，直接退出游戏。
	 * */
	public void dead(){
		System.exit(0);
	}
}

