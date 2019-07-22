package com.fuqi.treelearn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 二叉树的前序遍历：父左右
 * @Team 电子科技大学自动化研究所
 * @uthor 傅琦
 * @date 2019/7/22 9:56
 * @Version V1.0
 */
public class PreOrderIterator {
    /**
     * 方法一：递归
     * @param root
     * @return List<Integer>
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        // 先递归遍历左子树
        if (root.left != null){
            res.addAll(preorderTraversal1(root.left));
        }

        // 再递归遍历右子树
        if (root.right != null){
            res.addAll(preorderTraversal1(root.right));
        }

        return res;
    }
}
