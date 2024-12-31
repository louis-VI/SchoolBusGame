package HSW.obj;

import HSW.GameWin;

import java.awt.*;
//父类编写
public class GameObj{
    //定义图片
    Image img;
    //坐标
    int x;
    int y;
    //宽高
    int width=50;
    int height=50;
    //窗口类的引用
    protected GameWin frame;


    //getter和setter方法
    public Image getImg(){

        return img;
    }

    public void setImg(Image img){

        this.img = img;
    }

    public void setX(int x){

        this.x = x;
    }

    public void setY(int y){

        this.y = y;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public GameWin getFrame(){
        return frame;
    }

    public void setFrame(GameWin frame){
        this.frame=frame;
    }


    //有参构造和无参构造
    public GameObj(){

    }

    public GameObj(Image img,int x, int y, GameWin frame){
        this.x = x;
        this.y = y;
        this.img = img;
        this.frame = frame;
    }

    public GameObj( Image img,int x, int y, int width, int height, GameWin frame){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
        this.frame = frame;
    }

    //定义绘制自身方法
    public void paintSelf(Graphics g){
        g.drawImage(img,x,y,null);
    }
}