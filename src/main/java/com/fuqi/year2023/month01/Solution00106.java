package com.fuqi.year2023.month01;

import com.fuqi.year2020.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FuQi
 * @date 2023/1/9 20:50
 * @description 根据中序遍历和后序遍历构造二叉树
 */
public class Solution00106 {
    private Map<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        for (int i = 0; i < inorder.length; i++) {
            idx_map.put(inorder[i], i);
        }

//        return dfs(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    /**
     * 借助一个中序遍历元素的索引map
     * (比较依赖每个节点的值都不同这个条件)
     *
     * @param inorder
     * @param postorder
     * @param inorderLeft
     * @param inorderRight
     * @param postorderLeft
     * @param postorderRight
     * @return
     */
    private TreeNode helper(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        // 递归终止条件
        if (inorderLeft > inorderRight) {
            return null;
        }
        if (inorderLeft == inorderRight) {
            return new TreeNode(inorder[inorderLeft]);
        }
        int rootVal = postorder[postorderRight];
        TreeNode root = new TreeNode(rootVal);
        // 得到根节点在inorder中的位置
        int inorderMid = idx_map.get(rootVal);
        int leftTreeLen = inorderMid - inorderLeft;

        root.left = helper(inorder, postorder, inorderLeft, inorderMid-1, postorderLeft, postorderLeft+leftTreeLen-1);
        root.right = helper(inorder, postorder, inorderMid+1, inorderRight, postorderLeft+leftTreeLen, postorderRight-1);

        return root;
    }

    /**
     * 在原数组上操作
     *
     * @param inorder
     * @param postorder
     * @param inorderLeft
     * @param inorderRight
     * @param postorderLeft
     * @param postorderRight
     * @return
     */
    private TreeNode dfs(int[] inorder, int[] postorder, int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        // 递归终止条件
        if (inorderLeft > inorderRight) {
            return null;
        }
        if (inorderLeft == inorderRight) {
            return new TreeNode(inorder[inorderLeft]);
        }
        int rootVal = postorder[postorderRight];
        TreeNode root = new TreeNode(rootVal);
        int inorderMid = inorderLeft;
        // 遍历寻找父节点在中序遍历中的位置
        for (int i = inorderLeft; i <= inorderRight; i++) {
            if (inorder[i] == rootVal) {
                inorderMid = i;
                break;
            }
        }
        int leftTreeLen = inorderMid - inorderLeft;
        root.left = dfs(inorder, postorder, inorderLeft, inorderMid-1, postorderLeft, postorderLeft+leftTreeLen-1);
        root.right = dfs(inorder, postorder, inorderMid+1, inorderRight, postorderLeft+leftTreeLen, postorderRight-1);

        return root;
    }
}
