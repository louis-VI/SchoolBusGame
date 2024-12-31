package HSW.obj2;

import HSW.GameWin;
import HSW.obj2.FoodObj2;
import HSW.obj2.GameObj2;
import HSW.utils.GameUtils;

import java.awt.*;
import java.util.Random;

public class FoodObj2 extends GameObj2 {
    //定义随机函数
    Random r=new Random();
    public FoodObj2() {
        super();
    }

    public FoodObj2(Image img, int x, int y, GameWin frame) {
        super(img, x, y, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }

    //获取食物
    public FoodObj2 getFood(){
        //食物是随机出现的，但范围不超过窗口，x是0~1950，随机数产生0~39；y是0~1450，随机数产生0~29
        return new FoodObj2(GameUtils.foodImg2, r.nextInt(15)*50, r.nextInt(15)*50,this.frame );
    // 35 25
    }
}
