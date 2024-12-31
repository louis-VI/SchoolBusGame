package HSW.obj;

import HSW.utils.GameUtils;
import HSW.GameWin;

import java.awt.*;
import java.util.Random;

//import static HSW.GameWin.winHeight;
//import static HSW.GameWin.winWidth;

public class FoodObj extends GameObj{

    //定义随机函数
    Random r=new Random();


    public FoodObj() {
        super();
    }

    public FoodObj(Image img, int x, int y, GameWin frame) {
        super(img, x, y, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }

    //获取食物
    public  FoodObj getFood(){
        //食物是随机出现的，但范围不超过窗口，x是0~1950，随机数产生0~39；y是0~1450，随机数产生0~29


        //Mpdified Part:因为在边界值为题上，会出现接送不到小孩的bug，这里将bondx值减20， 以缩小人物出现的范围
        return new FoodObj(GameUtils.foodImg, r.nextInt(15)*50, r.nextInt(15)*50,this.frame);
        //35 25
    }
}
