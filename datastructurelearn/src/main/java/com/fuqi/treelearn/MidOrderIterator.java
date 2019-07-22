package com.fuqi.treelearn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 二叉树中序遍历(左父右)
 * @Team 电子科技大学自动化研究所
 * @Author 傅琦
 * @date 2019/7/22 10:56
 * @Version V1.0
 */
public class MidOrderIterator {
    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null){ return new ArrayList<>(); }

        List<Integer> res = new ArrayList<>();
        // 先递归遍历左子树
        if (root.left != null){
            res.addAll(inorderTraversal1(root.left));
        }

        // 再添加父节点
        res.add(root.val);

        // 再递归遍历右子树
        if (root.right != null){
            res.addAll(inorderTraversal1(root.right));
        }

        return res;
    }
}
