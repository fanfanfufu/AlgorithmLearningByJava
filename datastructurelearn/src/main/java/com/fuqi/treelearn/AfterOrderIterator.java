package com.fuqi.treelearn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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

    /**
     * 后序遍历的非递归算法比较麻烦，跟之前有所不同，
     * 需要一个额外的指针pre指向上次打印的节点，如果一个节点没有左右孩子，那么打印，
     * 如果一个节点的左右孩子都已经打印过，那么这个节点也可以打印。
     * 而新加的pre指针就是用来判断左右孩子有没有被打印过的。
     *
     * 对于任一节点P，
     *
     * 1）先将节点P入栈；
     *
     * 2）若P不存在左孩子和右孩子，或者P存在左孩子或右孩子，但左右孩子已经被输出，则可以直接输出节点P，
     *    并将其出栈，将出栈节点P标记为上一个输出的节点，再将此时的栈顶结点设为当前节点；
     *
     * 3）若不满足2）中的条件，则将P的右孩子和左孩子依次入栈，当前节点重新置为栈顶结点，之后重复操作2）；
     *
     * 4）直到栈空，遍历结束。
     *
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) { return ans; }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode cur;
        TreeNode pre = null;

        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (cur.left == pre || cur.right == pre))) {
                pre = stack.pop();
                ans.add(pre.val);
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }

        return ans;
    }
}
