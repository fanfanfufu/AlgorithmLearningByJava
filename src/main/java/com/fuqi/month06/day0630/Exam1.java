package com.fuqi.month06.day0630;

/**
 * @Description: 分糖果 II
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 *
 * @Author: 傅琦
 * @DateTime: 2019/6/30 10:29
 * @Version: V1.0
 */
public class Exam1 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int i = 0, num = 1;
        while (candies > 0){
            if (i < num_people){
                if (candies - num > 0){
                    result[i] += num;
                    candies -= num;
                }else {
                    result[i] += candies;
                    candies -= candies;
                }
                i++;
                num++;
            }else {
                i -= num_people;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Exam1 exam1 = new Exam1();
        int[] res = exam1.distributeCandies(10, 3);
        for (int num: res) {
            System.out.print(num + " ");
        }
    }
}
