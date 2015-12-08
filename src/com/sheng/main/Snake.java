package com.sheng.main;

import java.awt.Point;
import java.util.LinkedList;

public class Snake {
	protected Point head;
	protected LinkedList<Point> body;
	protected int length;
	protected int throughWall;//�ɴ�ǽ����
	protected int throughBody;//�ɴ�������
	protected GamePanel gamePanel;
	protected int direction;
	protected int score;
	/**
	 * ����1,2,3�ֱ������и߼�������ĸı��Ӱ���ߵ��ٶȣ���������ڿ�ʼ����н��п��ƣ�Ҳ������Ϸ���й��������ŵ÷����ӽ������
	 * */
	protected int level;	
	/**
	 * �ߵĹ��췽�����ߵĲ�����������Ϸ���
	 * */
	Snake(GamePanel gamePanel){//�ߵĲ�����������Ϸ���
		this.gamePanel=gamePanel;
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
		score=0;
		level=1;//��Ϸ����Ĭ��Ϊ1����ͣ�����һ��set�������Խ�������
	}
	
	
	/**
	 * ������Ϸ����ͨ���ߵ�level����������
	 * */
	public void setLevel(int level){
		this.level=level;
	}
	
	/**
	 * �����ߵ��˶�����
	 * */
	public void setDirection(int direction){
		this.direction=direction;
	}
	/**
	 * �Ƿ�Ե�ʳ�
	 * �㷨��ÿ�α���ס���һ���ڵ㣬����ͷ��ʳ���غϣ��򽫱����ڵ������β��ͬʱ���ȼ�1������true��
	 * */
	public boolean isEat(Food food){
		Point tmpNode=this.body.getLast();
		if(head.equals(food.pos)){
			
			//���Ե�����ʳ���������Ӧ���ܺͷ���
			if(food.flag==1){
				throughBody++;
				score+=3;
			}else if(food.flag==2){
				throughWall++;
				score+=2;
			}else{
				score++;
			}
			
			body.add(tmpNode);
			length++;
			return true;
		}
		return false;
	}
	/**
	 * �ƶ��㷨��ÿ���ƶ����������ƶ������½���ʱͷ��㣬Ȼ���½���ʱ����������ԭ��ͷ�ڵ����μ���ڵ㣬ȥ��ԭ��������������һ���ڵ㣬
	 * Ȼ����ͷ����������ָ���½���ͷ���������һ���ƶ�
	 * */
	public void move(){
		Point tmpHeadNode=new Point(0, 0);
		Point tmpBodyNode;
		LinkedList<Point> tmpBody=new LinkedList<Point>();
		switch(direction){
		case 0:
			tmpHeadNode=new Point(head.x,head.y-8);
			if(tmpHeadNode.y<0 && throughWall>0){					//�������������Ӧ�߶��ڶԱ߳��֣�������ƶ�ԭ��ͬ��
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
	 * �Ƿ����
	 * */
	public boolean isOut(){
		if(head.x>gamePanel.width || head.x<0 || head.y <0 || head.y >gamePanel.height){
			return true;
		}
		return false;
	}
	/**
	 * �Ƿ�ҧ���Լ�
	 * */
	public boolean isPitch(){
		if(body.contains(head)){//������ڵ����ͷ���ڵ��ж�Ϊҧ���Լ�
			return true;
		}
		return false;
	}
	/**
	 * ����������ֱ���˳���Ϸ��
	 * */
	public void dead(){
		System.exit(0);
	}
	
}

