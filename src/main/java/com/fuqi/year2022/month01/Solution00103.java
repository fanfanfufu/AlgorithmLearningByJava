package com.fuqi.year2022.month01;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/1/29 21:13
 * @description
 */
public class Solution00103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        boolean isOrderLeft = true;
        nodeDeque.offer(root);
        while (!nodeDeque.isEmpty()) {
            int len = nodeDeque.size();
            Deque<Integer> curLayer = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode pop = nodeDeque.poll();
                if (isOrderLeft) {
                    curLayer.offerLast(pop.val);
                } else {
                    curLayer.offerFirst(pop.val);
                }
                if (pop.left != null) {
                    nodeDeque.offer(pop.left);
                }
                if (pop.right != null) {
                    nodeDeque.offer(pop.right);
                }
            }
            ans.add(new ArrayList<>(curLayer));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode seven = new TreeNode(7);
        TreeNode fifteen = new TreeNode(15);
        TreeNode nine = new TreeNode(9);
        TreeNode three = new TreeNode(3);
        TreeNode twenty = new TreeNode(20);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        twenty.left = fifteen;
        twenty.right = seven;
        three.left = nine;
        three.right = twenty;
        seven.left = six;
        fifteen.right = one;

        List<List<Integer>> res = zigzagLevelOrder(three);
        res.forEach(System.out::println);
    }
}
