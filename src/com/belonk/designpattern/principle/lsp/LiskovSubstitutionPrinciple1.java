package com.belonk.designpattern.principle.lsp;

/**
 * Created by sun on 2020/5/27.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class LiskovSubstitutionPrinciple1 {
    //~ Static fields/constants/initializer


    //~ Instance fields


    //~ Constructors


    //~ Methods
    public static void main(String[] args) {
        Bird bird = new WildGoose();
        bird.setSpeed(10);
        bird.fly(1000);

        Animal animal = new Penguin();
    }
}

abstract class Animal {
    int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    abstract String getName();
}

abstract class Bird extends Animal {
    public void fly(int distance) {
        int time = distance / speed;
        System.out.println(getName() + "飞行了" + time + "分钟");
    }
}

// 大雁
class WildGoose extends Bird {
    @Override
    String getName() {
        return "大雁";
    }
}

// 企鹅
class Penguin extends Animal {
    @Override
    String getName() {
        return "企鹅";
    }

    @Override
    public void setSpeed(int speed) {
        super.setSpeed(0);
    }
}