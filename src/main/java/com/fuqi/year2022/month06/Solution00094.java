package com.fuqi.year2022.month06;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/6/17 21:18
 * @description
 */
public class Solution00094 {
    /**
     * 迭代的方式
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
            root = stack.pollFirst();
            ans.add(root.val);
            root = root.right;
        }

        return ans;
    }

    /**
     * 递归方式
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        midOrder(ans, root);
        return ans;
    }

    /**
     * 中序遍历：左父右
     * @param ans
     * @param root
     */
    private void midOrder(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        // 添加左子树
        midOrder(ans, root.left);
        // 再添加当前节点
        ans.add(root.val);
        // 最后添加右子树
        midOrder(ans, root.right);
    }

    /**
     * 前序遍历：父左右
     *
     * @param ans
     * @param root
     */
    private void preOrder(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        // 添加左子树
        preOrder(ans, root.left);
        // 添加右子树
        preOrder(ans, root.right);
    }

    /**
     * 后续遍历：左右父
     *
     * @param ans
     * @param root
     */
    private void postOrder(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(ans, root.left);
        postOrder(ans, root.right);
        ans.add(root.val);
    }
}
