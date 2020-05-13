package com.fuqi.year2020.month05.day13;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 二叉树层序遍历
 * @Author 傅琦
 * @date 2020/5/13 15:34
 * @Version V1.0
 */
public class LeetCode102 {
    public static void main(String[] args) {
        LeetCode102 leetCode102 = new LeetCode102();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(leetCode102.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) { return ans; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> layer = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                layer.add(cur.val);
                if (cur.left != null){ queue.offer(cur.left); }
                if (cur.right != null){ queue.offer(cur.right); }
            }
            ans.add(layer);
        }

        return ans;
    }
}
