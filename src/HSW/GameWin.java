package HSW;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import HSW.obj.BodyObj;
import HSW.obj2.BodyObj2;
import HSW.obj.FoodObj;
import HSW.obj2.FoodObj2;
import HSW.obj.HeadObj;
import HSW.obj2.HeadObj2;
import HSW.utils.GameUtils;


public class GameWin extends JFrame {

    //蛇头1分数
    public int score=0;
    //Modified Part:蛇头2分数
    public int score2=0;
    //游戏状态 0：未开始  1：游戏中 2：暂停 3：失败 4：通关 5:失败后重新开始游戏


    public static int state=0;


    //分数窗口大小
    int winWidth=2000;//2000
    int winHeight=11450;//1450


    //创建蛇头对象
    HeadObj headObj = new HeadObj(GameUtils.rightImg, 100, 500, this);//蛇头初始位置

    //Modified Part创建蛇头2对象
    HeadObj2 headObj2 = new HeadObj2(GameUtils.rightImg2, 500, 500, this);//蛇头2初始位置

    //蛇身集合
    public List<BodyObj>bodyObjList=new ArrayList<>();

    //Modified Part 蛇身2集合
    public List<BodyObj2> bodyObjList2=new ArrayList<>();

    //食物
    public FoodObj foodObj=new FoodObj().getFood();//getFood()方法返回值刚好是FoodObj的对象

    //Modified Part 食物2
    public FoodObj2 foodObj2=new FoodObj2().getFood();//getFood()方法返回值刚好是FoodObj的对象

    public void launch() {
        this.setVisible(true);//设置窗口是否可见
        this.setSize(winWidth, winHeight);//设置窗口大小
        this.setLocationRelativeTo(null);//设置窗口位置在屏幕上谷中
        this.setTitle("小火车拉客");

        //蛇身初始化
        bodyObjList.add(new BodyObj(GameUtils.bodyImg,50,500,this));
        bodyObjList.add(new BodyObj(GameUtils.bodyImg,0,500,this));//第二节身体


        //Modified Part 蛇身2初始化
        bodyObjList2.add(new BodyObj2(GameUtils.bodyImg2,450,500,this));
        bodyObjList2.add(new BodyObj2(GameUtils.bodyImg2,400,500,this));//第二节身体

        //键盘事件
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    switch(state){
                        case 0: state=1; //未开始
                            break;
                        case 1: state=2;//游戏中
                            repaint();
                            break;
                        case 2: state=1;//游戏暂停
                            break;
                        case 3: state=5;//失败后重新开始
                            break;
                        default:
                            break;
                    }
                }

            }
        });

        while (true) {

            if(state==1){
                //只有在游戏中才调用
                repaint();
            }

            //失败后重新开始
            if(state==5){

                state=0;
                resetGame();
            }
            try {
                Thread.sleep(200);//线程休眠，200毫秒，1秒会被调用5次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void paint (Graphics g){
        //灰色背景
        g.setColor(Color.gray);
        g.fillRect(0, 0, winWidth, winHeight);
        //网格线
        g.setColor(Color.black);//网格线颜色
        for (int i = 0; i <= 29 ; i++) {
            g.drawLine(0, i * 50, 2500, i * 50);//前两个参数为起点坐标，后两个为终点坐标.
        }

        //竖线
        for (int i = 0; i <= 40; i++) {
            g.drawLine(i * 50, 0, i * 50, 2500);
        }

        //绘制蛇身
        for(int i=bodyObjList.size()-1;i>=0;i--){
            bodyObjList.get(i).paintSelf(g);
        }

        //Modified part：绘制蛇身2
        for(int i=bodyObjList2.size()-1;i>=0;i--){
            bodyObjList2.get(i).paintSelf(g);
        }

        //绘制蛇头
        headObj.paintSelf(g);

        //Modified Part 绘制蛇头2
        headObj2.paintSelf(g);

        //绘制食物
        foodObj.paintSelf(g);
        foodObj2.paintSelf(g);

       //绘制蛇头1分数
        GameUtils.drawWord(g,"1车:"+score+"分",Color.BLUE,50,600,150);

        //Modified Part:绘制蛇头2分数
        GameUtils.drawWord(g,"2车:"+score2+"分",Color.BLUE,50,1000,150);




        //绘制提示语
        g.setColor(Color.gray);
        prompt(g);

    }


    //绘制提示语
    void prompt(Graphics g){
        //未开始
        if(state==0){
            GameUtils.drawWord(g,"按下空格开始游戏",Color.yellow,100,700,750);
        }
        //游戏暂停
         if(state==2){
            GameUtils.drawWord(g,"按下空格继续游戏",Color.yellow,100,700,750);
        }

        //游戏失败
        if(state==3){
            //Modified Part 代码修改部分
            //调用获取分数方法
            int currentScore = headObj.getScore();
            int currentScore2 = headObj2.getScore2();
            //输出失败结果和各方分数
            GameUtils.drawWord(g,"撞车方失败,分数比"+ currentScore+":"+currentScore2 +"\n按下空格继续游戏" ,Color.red,80,300,550);

        }

        //通关
        if(state==4){
            //Modified Part 代码修改部分
            //调用获取分数方法
            int currentScore = headObj.getScore();
            int currentScore2 = headObj2.getScore2();
            //输出成功结果和各方分数
            GameUtils.drawWord(g,"分数先达50分一方游戏通关，分数为"+currentScore+":"+currentScore2+"\n按下空格继续游戏",Color.green,80,300,550);
        }
    }


    //游戏重置
    void resetGame(){
        //关闭当前窗口
        this.dispose();
        //开启新窗口
        String[] args={};
        main(args);
    }


    public static void main(String[]args){
        GameWin gameWin = new GameWin();
        gameWin.launch();

    }
}