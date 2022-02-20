package com.fuqi.year2022.month02.week281;

/**
 * @author FuQi
 * @date 2022/2/20 10:47
 * @description
 */
public class Solution06012 {
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) {
            if (judgeEvent(i)) {
                System.out.println(i);
                ans++;
            }
        }

        return ans;
    }

    /**
     * 判断数字的各位之和是否为偶数
     *
     * @param i
     * @return
     */
    private boolean judgeEvent(int i) {
        int sum = 0;
        while (i != 0) {
            int last = i % 10;
            sum += last;
            i /= 10;
        }

        return sum % 2 == 0;
    }

    public static void main(String[] args) {
        Solution06012 solution06012 = new Solution06012();
        int num = 30;
        System.out.println("res = " + solution06012.countEven(num));
    }
}
