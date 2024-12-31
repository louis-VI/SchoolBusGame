package HSW.obj2;
/**
 * 考虑到新玩家的操作方向不一样，我们这里创建第二个对象包进行行为管理
 */

import HSW.GameWin;
import HSW.obj.BodyObj;
import HSW.obj.FoodObj;
import HSW.obj2.GameObj2;
import HSW.utils.GameUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HeadObj2 extends GameObj2 {
    //定义方向up  down left right
    private String direction="right";

    public String getDirection() {

        return direction;
    }

    //ADD 定义第二个蛇头的移动方法
    // ... 其他属性和方法 ...

    public HeadObj2(Image img, int x, int y, GameWin frame) {
        super(img, x, y, frame);
        // 键盘监听事件
        this.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                changDirection2(e);
            }
        });
    }

    // ... 其他方法 ...

    // 控制移动方向
    // 第二个玩家的方向键是上为8 下为2 左为4 右为6，注意键盘控制事件限制在NumLock关闭的状态下才能使用这个方向键
    public void changDirection2(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_4:
                // 蛇不能朝反方向移动
                if (!"right".equals(direction)) {
                    direction = "left";
                    img = GameUtils.leftImg2; // 改变蛇头方向
                }
                break;

            case KeyEvent.VK_6:
                // 蛇不能朝反方向移动
                if (!"left".equals(direction)) {
                    direction = "right";
                    img = GameUtils.rightImg2; // 改变蛇头方向
                }
                break;

            case KeyEvent.VK_8:
                // 蛇不能朝反方向移动
                if (!"down".equals(direction)) {
                    direction = "up";
                    img = GameUtils.upImg2; // 改变蛇头方向
                }
                break;

            case KeyEvent.VK_2:
                // 蛇不能朝反方向移动
                if (!"up".equals(direction)) {
                    direction = "down";
                    img = GameUtils.downImg2; // 改变蛇头方向
                }
                break;

            // 新增处理第二个蛇头的移动方法
            case KeyEvent.VK_LEFT:
                // 蛇不能朝反方向移动
                if (!"right".equals(direction)) {
                    direction = "left";
                    img = GameUtils.leftImg2; // 改变蛇头方向
                }
                break;

            case KeyEvent.VK_RIGHT:
                // 蛇不能朝反方向移动
                if (!"left".equals(direction)) {
                    direction = "right";
                    img = GameUtils.rightImg2; // 改变蛇头方向
                }
                break;

            case KeyEvent.VK_UP:
                // 蛇不能朝反方向移动
                if (!"down".equals(direction)) {
                    direction = "up";
                    img = GameUtils.upImg2; // 改变蛇头方向
                }
                break;

            case KeyEvent.VK_DOWN:
                // 蛇不能朝反方向移动
                if (!"up".equals(direction)) {
                    direction = "down";
                    img = GameUtils.downImg2; // 改变蛇头方向
                }
                break;

            default:
                break;
        }
    }

    //蛇头移动
    //蛇头的移动
    public void move(){

        //蛇身的移动
        java.util.List<BodyObj2>bodyObjList=this.frame.bodyObjList2;
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
    public int getScore2(){
        return frame.score2;
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);

        //蛇吃食物食物
        FoodObj2 food=this.frame.foodObj2;

        //身体最后一节的坐标
        Integer newX=null;
        Integer newY=null;

        if(this.x==food.x&&this.y==food.y){//条件为真，表示蛇头和食物重合了，食物要被吃掉
            this.frame.foodObj2=food.getFood();

            //获取蛇身的最后一个元素
            BodyObj2 lastBody=this.frame.bodyObjList2.get(this.frame.bodyObjList2.size()-1);
            newX=lastBody.x;
            newY=lastBody.y;

            //分数+1
            this.frame.score2++;


        }


        //通关判断
        if(this.frame.score2>=50){
            //通关
            GameWin.state=4;
        }

        move();
        if(newX!=null&&newY!=null){
            //move结束后，新的bodyObj对象添加到bodyList
            this.frame.bodyObjList2.add(new BodyObj2(GameUtils.bodyImg2,newX,newY,this.frame));
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
