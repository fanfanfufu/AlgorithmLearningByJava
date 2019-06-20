package com.fuqi.month06.day0620;

/**
 * @Description: 假设1元、2元、5元、10元、20元、50元、100元的纸币，张数不限制，现在要用来支付K元，至少要多少张纸币？
 * 贪心算法的例子
 * @Author 傅琦
 * @Date 2019/6/20 11:22
 * @Version V1.0
 */
public class 纸币找零 {
    public static void main(String[] args) {
        int money = 8;
        System.out.println("需要找零: " + money);
        int[] moneyLevel = {1, 5, 10, 20, 50, 100};
        for (int i = moneyLevel.length - 1; i >= 0; i--) {
            int num = money/ moneyLevel[i];
            int mod = money % moneyLevel[i];
            money = mod;
            if (num > 0) {
                System.out.println("需要" + num + "张" + moneyLevel[i] + "块的");
            }
        }
    }
}
