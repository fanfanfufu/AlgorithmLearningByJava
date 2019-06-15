package com.fuqi.month06.day0615;

/**
 * @Description: 最小元素各数位之和
 *
 * 示例1：
 * 输入：[34,23,1,24,75,33,54,8]
 * 输出：0
 * 解释：
 * 最小元素为 1，该元素各个数位上的数字之和 S = 1，是奇数所以答案为 0。
 *
 * 示例2：
 * 输入：[99,77,33,66,55]
 * 输出：1
 * 解释：
 * 最小元素为 33，该元素各个数位上的数字之和 S = 3 + 3 = 6，是偶数所以答案为 1。
 *
 * @Author: 傅琦
 * @DateTime: 2019/6/15 22:32
 * @Version: V1.0
 */
public class Exam1 {
    public static void main(String[] args) {
        int[] arr = new int[]{99,77,33,66,55};
        Exam1 exam1 = new Exam1();
        int res = exam1.sumOfDigits(arr);
        System.out.println(res);
    }

    public int sumOfDigits(int[] A) {
        int minNum = Integer.MAX_VALUE;
        for (int num: A) {
            minNum = Math.min(minNum, num);
        }
        minNum = Math.abs(minNum);
        int sum = 0;
        while (minNum != 0){
            sum += minNum % 10;
            minNum /= 10;
        }
        return sum % 2 == 0 ? 1 : 0;
    }
}
