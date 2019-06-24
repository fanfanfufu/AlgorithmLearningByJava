package com.fuqi.month06.day0624;

import java.util.*;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/6/24 10:44
 * @Version V1.0
 */
public class 二叉树锯齿形层次遍历 {
    /**
     * 采用双栈法
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        // 该变量用于记录层数，偶数层从左往右入栈，奇数层从优往左入栈
        int level = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            if (level % 2 == 0){
                while (!stack1.isEmpty()){
                    TreeNode cur = stack1.pop();
                    temp.add(cur.val);
                    if (cur.left != null){ stack2.push(cur.left); }
                    if (cur.right != null){ stack2.push(cur.right); }
                }
                res.add(temp);
            }else {
                while (!stack2.isEmpty()){
                    TreeNode cur = stack2.pop();
                    temp.add(cur.val);
                    if (cur.right != null){ stack1.push(cur.right); }
                    if (cur.left != null){ stack1.push(cur.left); }
                }
                res.add(temp);
            }
            level++;
        }
        return res;
    }
}
