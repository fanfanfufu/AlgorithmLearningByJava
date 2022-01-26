package com.fuqi.year2022.month01;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author FuQi
 * @date 2022/1/26 22:36
 * @description 按层序遍历二叉树
 */
public class Solution00102 {
    /**
     * 借助队列的数据结构
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.offer(root);
        while (!treeNodeDeque.isEmpty()) {
            int len = treeNodeDeque.size();
            List<Integer> curLayer = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = treeNodeDeque.poll();
                curLayer.add(cur.val);
                if (cur.left != null) {
                    treeNodeDeque.offer(cur.left);
                }
                if (cur.right != null) {
                    treeNodeDeque.offer(cur.right);
                }
            }
            ans.add(curLayer);
        }

        return ans;
    }
}
