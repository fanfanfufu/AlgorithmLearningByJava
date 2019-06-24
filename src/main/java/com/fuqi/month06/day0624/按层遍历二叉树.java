package com.fuqi.month06.day0624;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 按层遍历二叉树
 * @Author 傅琦
 * @date 2019/6/24 9:23
 * @Version V1.0
 */
public class 按层遍历二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null){ queue.offer(cur.left); }
                if (cur.right != null){ queue.offer(cur.right); }
            }
            res.add(temp);
        }

        return res;
    }
}
