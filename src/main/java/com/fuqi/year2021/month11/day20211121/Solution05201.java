package com.fuqi.year2021.month11.day20211121;

/**
 * @author FuQi
 * @date 2021/11/21 10:39
 * @description
 */
public class Solution05201 {
    public static int wateringPlants(int[] plants, int capacity) {
        // 初始化变量
        int curWater = capacity-plants[0];
        int ans = 1;
        int back = 1;
        if (plants.length == 1) {
            return ans;
        }
        for (int i = 1; i < plants.length; i++) {
            // 如果水不够了
            if (plants[i] > curWater) {
                // 回到河边取水
                ans = ans + back;
                // 水已经装满
                curWater=capacity;
                // 再回到需要浇水的植物位置
                ans = ans+i;
            }
            curWater -= plants[i];
            ans++;
            back++;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] plants = {2, 2, 3, 3};
//        int capacity = 5;
//        int[] plants = {1,1,1,4,2,3};
//        int capacity = 4;
        int[] plants = {7,7,7,7,7,7,7};
        int capacity = 8;
        int ans = wateringPlants(plants, capacity);
        System.out.println(ans);
    }
}
