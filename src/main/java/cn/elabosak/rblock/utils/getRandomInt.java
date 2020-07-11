package cn.elabosak.rblock.utils;

import java.util.Random;

public class getRandomInt {

    public Integer get(Integer start, Integer end) {
        Random rand = new Random();
        Integer randNum =rand.nextInt(end - start + 1) + start;
        return randNum;
    }

}
