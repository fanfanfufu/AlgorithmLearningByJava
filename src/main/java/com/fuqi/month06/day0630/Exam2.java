package com.fuqi.month06.day0630;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 二叉树寻路
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 * 输入：label = 14
 * 输出：[1,3,4,14]
 *
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *
 * @Author: 傅琦
 * @DateTime: 2019/6/30 10:29
 * @Version: V1.0
 */
public class Exam2 {
    public List<Integer> pathInZigZagTree(int label) {
        int n = 1;
        while (label >= Math.pow(2, n)){
            n++;
        }
        // 根据当前值计算其父节点的标签值
        Integer[] arr = new Integer[n];
        while (label >= 1){
            arr[n-1] = label;
            label = (int) ((Math.pow(2, n-1) + Math.pow(2, n) - label - 1) / 2);
            n--;
        }

        return Arrays.asList(arr);
    }
}
