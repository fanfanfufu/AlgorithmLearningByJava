package com.fuqi.month07.day0713;

/**
 * @Description: 一个月有多少天
 *
 * 指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。
 *
 * @Author: 傅琦
 * @DateTime: 2019/7/13 22:30
 * @Version: V1.0
 */
public class Exam1 {
    public int numberOfDays(int Y, int M) {
        switch (M){
            case 1:
                return 31;
            case 2:
                // 判断闰年
                if ((Y % 4 == 0 && Y % 100 != 0) || (Y % 100 == 0 && Y % 400 == 0)){
                    return 29;
                }else {
                    return 28;
                }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }
}
