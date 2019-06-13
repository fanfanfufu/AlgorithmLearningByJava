package com.fuqi.month05.day0522;

import java.util.LinkedList;

/**
 * @Description: 首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？
 * (注：小朋友的编号是从0到n-1)
 * @Author 傅琦
 * @Date 2019/5/22 22:16
 * @Version V1.0
 */
public class LastRemainingSolution {

    public static void main(String[] args){
        System.out.println(9 % 10);
    }

    public int lastRemaining(int n, int m) {
        if(n<1||m<1) {return -1;}
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1){
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }
}
