package com.belonk.designpattern.principle.lsp.bad;

/**
 * Created by sun on 2020/5/27.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class NotLiskovSubstitutionPrinciple1 {
    //~ Static fields/constants/initializer


    //~ Instance fields


    //~ Constructors


    //~ Methods

    public static void main(String[] args) {
        Bird bird = new WildGoose();
        bird.setSpeed(10);
        bird.fly(1000);

        // 运行出错
        bird = new Penguin();
        bird.fly(1000);
    }
}

abstract class Bird {
    int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void fly(int distance) {
        int time = distance / speed;
        System.out.println(getName() + "飞行了" + time + "分钟");
    }

    abstract String getName();
}

// 大雁
class WildGoose extends Bird {
    @Override
    String getName() {
        return "大雁";
    }
}

// 企鹅
class Penguin extends Bird {
    @Override
    String getName() {
        return "企鹅";
    }

    @Override
    public void setSpeed(int speed) {
        // 企鹅不会飞
        super.setSpeed(0);
    }
}