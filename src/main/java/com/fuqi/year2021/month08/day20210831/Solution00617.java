package com.fuqi.year2021.month08.day20210831;

import com.fuqi.year2020.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 */
public class Solution00617 {
    public TreeNode mergeTreeBFS(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode ans = new TreeNode(root1.val + root2.val);
        Deque<TreeNode> ansQue = new LinkedList<>();
        Deque<TreeNode> que1 = new LinkedList<>();
        Deque<TreeNode> que2 = new LinkedList<>();
        ansQue.offer(ans);
        que1.offer(root1);
        que2.offer(root2);

        while (!que1.isEmpty() && !que2.isEmpty()) {
            TreeNode cur1 = que1.poll(), cur2 = que2.poll(), ansCur = ansQue.poll();
            TreeNode left1 = cur1.left, left2 = cur2.left, right1 = cur1.right, right2 = cur2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    // 都不为空
                    ansCur.left = new TreeNode(left1.val + left2.val);
                    ansQue.offer(ansCur.left);
                    que1.offer(left1);
                    que2.offer(left2);
                } else if (left1 == null) {
                    // 左树的左节点为空
                    ansCur.left = left2;
                } else {
                    // 右树的左节点为空
                    ansCur.left = left1;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null ) {
                    ansCur.right = new TreeNode(right1.val + right2.val);
                    ansQue.offer(ansCur.right);
                    que1.offer(right1);
                    que2.offer(right2);
                } else if (right1 == null) {
                    ansCur.right = right2;
                } else {
                    ansCur.right = right1;
                }
            }
        }

        return ans;
    }

    /**
     * 使用深度优先搜索
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTree(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode ans = new TreeNode(root1.val + root2.val);
        ans.left = mergeTree(root1.left, root2.left);
        ans.right = mergeTree(root1.right, root2.right);

        return ans;
    }
}
