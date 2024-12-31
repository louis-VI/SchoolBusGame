package HSW.obj;

import HSW.GameWin;
import HSW.utils.GameUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HeadObj extends GameObj{
    //定义方向up  down left right
    private String direction="right";

    public String getDirection() {

        return direction;
    }

    public void setDirection(String direction) {

        this.direction = direction;
    }

    public HeadObj(Image img  , int x, int y, GameWin frame) {
        super(img, x, y, frame);
        //键盘监听事件
        this.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                changDirection(e);
            }
        });
    }

    //控制移动方向,w-up  a-left d-right s-down
    public void changDirection(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_A:
                //蛇不能朝反方向移动
                if(!"right".equals(direction)){
                    direction="left";
                    img= GameUtils.leftImg;//改变蛇头方向
                }
                break;

            case KeyEvent.VK_D:
                //蛇不能朝反方向移动
                if(!"left".equals(direction)){
                    direction="right";
                    img= GameUtils.rightImg;//改变蛇头方向
                }
                break;

            case KeyEvent.VK_W:
                //蛇不能朝反方向移动
                if(!"down".equals(direction)){
                    direction="up";
                    img= GameUtils.upImg;//改变蛇头方向
                }
                break;

            case KeyEvent.VK_S:
                //蛇不能朝反方向移动
                if(!"up".equals(direction)){
                    direction="down";
                    img= GameUtils.downImg;//改变蛇头方向
                }
                break;
            default:
                break;
        }

    }


    //蛇头的移动
    public void move(){

        //蛇身的移动
        java.util.List<BodyObj>bodyObjList=this.frame.bodyObjList;
        for(int i=bodyObjList.size()-1;i>=1;i--){
            bodyObjList.get(i).x=bodyObjList.get(i-1).x;
            bodyObjList.get(i).y=bodyObjList.get(i-1).y;

            //蛇头与身体碰撞判断
            if(this.x==bodyObjList.get(i).x&&this.y==bodyObjList.get(i).y){
                //失败
                GameWin.state=3;
            }

        }

        bodyObjList.get(0).x=this.x;
        bodyObjList.get(0).y=this.y;

        switch(direction){
            case "up": y-=height;
                break;
            case "down": y+=height;
                break;
            case "left": x-=width;
                break;
            case "right": x+=width;
            default:
                break;
        }

    }
    //    :定义分数获取函数，便于调用
    public int getScore(){
        return frame.score;
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);

        //蛇吃食物食物
        FoodObj food=this.frame.foodObj;

        //身体最后一节的坐标
        Integer newX=null;
        Integer newY=null;

        if(this.x==food.x&&this.y==food.y){//条件为真，表示蛇头和食物重合了，食物要被吃掉
            this.frame.foodObj=food.getFood();

            //获取蛇身的最后一个元素
            BodyObj lastBody=this.frame.bodyObjList.get(this.frame.bodyObjList.size()-1);
            newX=lastBody.x;
            newY=lastBody.y;

            //分数+1
            this.frame.score++;


        }


        //通关判断
        if(this.frame.score>=50){
            //通关
            GameWin.state=4;
        }

        move();
        if(newX!=null&&newY!=null){
            //move结束后，新的bodyObj对象添加到bodyList
            this.frame.bodyObjList.add(new BodyObj(GameUtils.bodyImg,newX,newY,this.frame));
        }

        //越界处理
        if(x<0){
            x=1950;
        }else if(x>1950){
            x=0;
        }else if(y<50){
            y=1400;
        }else if(y>1400){
            y=50;
        }
    }



}