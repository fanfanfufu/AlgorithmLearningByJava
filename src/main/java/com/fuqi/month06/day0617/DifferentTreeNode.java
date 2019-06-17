package com.fuqi.month06.day0617;

/**
 * @Description: 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @Author 傅琦
 * @Date 2019/6/17 10:34
 * @Version V1.0
 */
public class DifferentTreeNode {
    /**
     * 每个n的结果叫卡特兰数，直接根据公式实现即可
     * 标签：动态规划
     * 假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则
     * G(n) = f(1)+f(2)+f(3)+f(4)+...+f(n)
     *
     * 当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
     * f(i) = G(i-1)*G(n-i)=G(i−1)∗G(n−i)
     *
     * 综合两个公式可以得到 卡特兰数 公式
     * G(n) = G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
     *
     * @param n
     * @return int
     */
    public int numTrees(int n) {
        int[] record = new int[n+1];
        record[0] = 1;
        record[1] = 1;

        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i+1; j++) {
                record[i] += record[j-1] * record[i-j];
            }
        }
        return record[n];
    }

    public static void main(String[] args) {
        DifferentTreeNode treeNode = new DifferentTreeNode();
        int res = treeNode.numTrees(5);
        System.out.println(res);
    }
}
