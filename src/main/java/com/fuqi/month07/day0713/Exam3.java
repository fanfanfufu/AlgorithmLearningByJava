package com.fuqi.month07.day0713;

import javafx.util.Pair;

/**
 * @Description: 子树的最大平均值
 *
 * 给你一棵二叉树的根节点 root，找出这棵树的每一棵子树的平均值中的最大值。
 * 子树是树中的任意节点和它的所有后代构成的集合。
 * 树的平均值是树中节点值的总和除以节点数。
 *
 * 输入：[5,6,1]
 * 输出：6.00000
 * 解释：
 * 以 value = 5 的节点作为子树的根节点，得到的平均值为 (5 + 6 + 1) / 3 = 4。
 * 以 value = 6 的节点作为子树的根节点，得到的平均值为 6 / 1 = 6。
 * 以 value = 1 的节点作为子树的根节点，得到的平均值为 1 / 1 = 1。
 * 所以答案取最大值 6。
 *
 * @Author: 傅琦
 * @DateTime: 2019/7/13 22:30
 * @Version: V1.0
 */
public class Exam3 {

    double maxMean;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return root.val;
        }

        int count = 1;
        double sum = (double) root.val;

        if (root.left != null){
            Pair<Integer, Double> pair = helper(root.left);
            count += pair.getKey();
            sum += pair.getValue();
        }

        if (root.right != null){
            Pair<Integer, Double> pair = helper(root.right);
            count += pair.getKey();
            sum += pair.getValue();
        }

        double rootMean = sum / count;
        maxMean = maxMean > rootMean ? maxMean : rootMean;

        return maxMean;
    }

    private Pair<Integer, Double> helper(TreeNode root){
        if (root.left == null && root.right == null){
            maxMean = maxMean > root.val ? maxMean : root.val;
            return new Pair<Integer, Double>(1, 0.0 + root.val);
        }

        int nowcount = 1;
        double nowsum = (double) root.val;
        if (root.left != null){
            Pair<Integer, Double> pair = helper(root.left);
            nowcount += pair.getKey();
            nowsum += pair.getValue();
        }

        if (root.right != null){
            Pair<Integer, Double> pair = helper(root.right);
            nowcount += pair.getKey();
            nowsum += pair.getValue();
        }

        double nowMean = nowsum / nowcount;
        maxMean = maxMean > nowMean ? maxMean : nowMean;
        return new Pair<Integer, Double>(nowcount, nowsum);
    }

    public static void main(String[] args) {
        Exam3 exam3 = new Exam3();
        TreeNode node = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left = new TreeNode(6);
//        node.left.left = new TreeNode(0);
//        node.left.right = new TreeNode(2);

        double res = exam3.maximumAverageSubtree(node);
        System.out.println("res = " + res);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
}
