package com.fuqi.year2023.month04;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/30 17:23
 * @description
 */
public class Solution01033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] positions = new int[]{a, b, c};
        Arrays.sort(positions);
        int[] ans = new int[2];
        // 三个的位置连续的时候，由于数组的初始值的特性，所以可以不用赋值
        if (positions[2] - positions[1] == 1 && positions[1] - positions[0] == 1) {
            return ans;
        }
        // 只有两个的位置是连续或者间隔为2的时候，最小的次数就是1
        // 其中两个数中间有一个空位置时，最小次数只需要移动一次，即可使三个数连续
        if (positions[2] - positions[1] <= 2 || positions[1] - positions[0] <= 2) {
            ans[0] = 1;
        } else {
            // 普通的不连续的情况下，最小次数就是2
            ans[0] = 2;
        }
        // 最大的次数就是最边缘的两个之间的距离再减2：pos[2]-pos[0]-2
        ans[1] = positions[2] - positions[0] - 2;

        return ans;
    }

    public static void main(String[] args) {
        Solution01033 solution01033 = new Solution01033();
        solution01033.numMovesStones(3,5,1);
    }
}
