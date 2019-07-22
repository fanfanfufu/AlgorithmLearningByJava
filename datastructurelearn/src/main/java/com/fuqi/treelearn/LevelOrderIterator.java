package com.fuqi.treelearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 二叉树按层遍历
 * @Team 电子科技大学自动化研究所
 * @Author 傅琦
 * @date 2019/7/22 11:19
 * @Version V1.0
 */
public class LevelOrderIterator {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){ return res; }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null){ queue.offer(cur.left); }
                if (cur.right != null){ queue.offer(cur.right); }
            }
            res.add(level);
        }

        return res;
    }
}
