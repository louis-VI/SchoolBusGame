package HSW.utils;
//游戏工具类的编写

import java.awt.*;

public class GameUtils{

    //蛇头
    public static Image upImg=Toolkit.getDefaultToolkit().getImage("img/up.jpg");
    public static Image downImg=Toolkit.getDefaultToolkit().getImage("img/down.jpg");
    public static Image leftImg=Toolkit.getDefaultToolkit().getImage("img/left.jpg");
    public static Image rightImg=Toolkit.getDefaultToolkit().getImage("img/right.jpg");
    //蛇身
    public static Image bodyImg=Toolkit.getDefaultToolkit().getImage("img/body.jpg");

    //蛇头2
    public static Image upImg2=Toolkit.getDefaultToolkit().getImage("img/2up.jpg");
    public static Image downImg2=Toolkit.getDefaultToolkit().getImage("img/2down.jpg");
    public static Image leftImg2=Toolkit.getDefaultToolkit().getImage("img/2left.jpg");
    public static Image rightImg2=Toolkit.getDefaultToolkit().getImage("img/2right.jpg");
    //蛇身2
    public static Image bodyImg2=Toolkit.getDefaultToolkit().getImage("img/2body.jpg");

    //食物
    public static Image foodImg=Toolkit.getDefaultToolkit().getImage("img/food.jpg");
    //食物2
    public static Image foodImg2=Toolkit.getDefaultToolkit().getImage("img/2food.jpg");


    //绘制文字
    public static void drawWord(Graphics g,String str,Color color,int size,int x,int y){
        g.setColor(color);
        g.setFont(new Font("楷体",Font.BOLD,size));
        g.drawString(str,x,y);//把文字绘制在屏幕上
    }
}