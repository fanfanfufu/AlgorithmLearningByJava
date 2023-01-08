package com.fuqi.year2022.month01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author FuQi
 * @date 2022/1/16 21:14
 * @description
 */
public class Solution00120 {
    public static int minimumTotal1(List<List<Integer>> triangle) {
        // 长度位1是直接返回其中的元素
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>(triangle.get(0)));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> curLayer = triangle.get(i);
            List<Integer> lastLayerDistance = dp.get(i - 1);
            List<Integer> curLayerDistance = new ArrayList<>(curLayer.size());
            for (int j = 0; j < curLayer.size(); j++) {
                Integer curDist = curLayer.get(j);
                if (j == 0) {
                    // 最左边的只能从上一层的最左边下来
                    curLayerDistance.add(lastLayerDistance.get(0) + curDist);
                    continue;
                }
                if (j == curLayer.size()-1) {
                    // 同理：最右边的只能从上一层的最右边下来
                    curLayerDistance.add(lastLayerDistance.get(curLayer.size()-2) + curDist);
                    continue;
                }
                // 中间的则比较其中的最小值
                int curMinDist = Math.min(lastLayerDistance.get(j - 1) + curDist, lastLayerDistance.get(j) + curDist);
                curLayerDistance.add(curMinDist);
            }
            dp.add(curLayerDistance);
        }
        // 去除最后一层的距离，按升序排序
        List<Integer> latestLayerDist = dp.get(dp.size() - 1).stream().sorted().collect(Collectors.toList());
        // 返回最小值即可
        return latestLayerDist.get(0);
    }

    /**
     * 空间优化到O(n)
     * 由于每层的元素数量与层数相同，因此可以优化
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }

    public static void main(String[] args) {
        List<Integer> firstLayer = Stream.of(2).collect(Collectors.toList());
        List<Integer> secondLayer = Stream.of(3,4).collect(Collectors.toList());
        List<Integer> thirdLayer = Stream.of(6,5,7).collect(Collectors.toList());
        List<Integer> fourthLayer = Stream.of(4,1,8,3).collect(Collectors.toList());
        List<List<Integer>> input = Stream.of(firstLayer, secondLayer, thirdLayer, fourthLayer).collect(Collectors.toList());
        System.out.println("res = " + minimumTotal1(input));
    }
}
