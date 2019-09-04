package com.fuqi.treelearn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

    /**
     * 非递归前序遍历
     *
     * 对于任一节点P，
     *
     * 1）输出节点P，然后将其入栈，再看P的左孩子是否为空；
     *
     * 2）若P的左孩子不为空，则置P的左孩子为当前节点，重复1）的操作；
     *
     * 3）若P的左孩子为空，则将栈顶节点出栈，但不输出，并将出栈节点的右孩子置为当前节点，看其是否为空；
     *
     * 4）若不为空，则循环至1）操作；
     *
     * 5）如果为空，则继续出栈，但不输出，同时将出栈节点的右孩子置为当前节点，看其是否为空，重复4）和5）操作；
     *
     * 6）直到当前节点P为NULL并且栈空，遍历结束。
     *
     */
    public List<Integer> preOrder2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) { return ans; }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                ans.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }

        return ans;
    }
}
