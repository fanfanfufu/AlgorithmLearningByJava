package com.fuqi.treelearn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 二叉树后续遍历（左右父）
 * @Author 傅琦
 * @date 2019/7/22 11:09
 * @Version V1.0
 */
public class AfterOrderIterator {
    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null){ return new ArrayList<>(); }

        List<Integer> res = new ArrayList<>();
        if (root.left != null){
            res.addAll(postorderTraversal1(root.left));
        }

        if (root.right != null){
            res.addAll(postorderTraversal1(root.right));
        }

        res.add(root.val);

        return res;
    }
}
