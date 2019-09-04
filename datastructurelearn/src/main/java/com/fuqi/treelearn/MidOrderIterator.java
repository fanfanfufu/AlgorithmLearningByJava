package com.fuqi.treelearn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

    /**
     * 中序遍历的非递归实现
     *
     * 对于任一节点P，
     *
     * 1）若P的左孩子不为空，则将P入栈并将P的左孩子置为当前节点，然后再对当前节点进行相同的处理；
     *
     * 2）若P的左孩子为空，则输出P节点，而后将P的右孩子置为当前节点，看其是否为空；
     *
     * 3）若不为空，则重复1）和2）的操作；
     *
     * 4）若为空，则执行出栈操作，输出栈顶节点，并将出栈的节点的右孩子置为当前节点，看起是否为空，重复3）和4）的操作；
     *
     * 5）直到当前节点P为NULL并且栈为空，则遍历结束。
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) { return ans; }

        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                while (cur == null && !stack.isEmpty()) {
                    TreeNode temp = stack.pop();
                    ans.add(temp.val);
                    cur = temp.right;
                }
            }
        }

        return ans;
    }
}
