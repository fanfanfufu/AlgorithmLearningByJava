package com.fuqi.month05.day0524;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @Author 傅琦
 * @Date 2019/5/24 14:47
 * @Version V1.0
 */
public class TreeNodeZOrder {
    public ArrayList<ArrayList<Integer>> printZOrder(TreeNode pRoot) {
        if (pRoot == null){
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<Stack<TreeNode>> stacks = new Stack<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        int layerNumber = 0;
        nodeStack.push(pRoot);
        stacks.push(nodeStack);
        while (!stacks.isEmpty()){
            ArrayList<Integer> layerList = new ArrayList<>();
            Stack<TreeNode> nowLayer = stacks.pop();
            Stack<TreeNode> nextLayer = new Stack<>();
            while (!nowLayer.isEmpty()){
                TreeNode nowTreeNode = nowLayer.pop();
                layerList.add(nowTreeNode.val);

                if (layerNumber % 2 == 0){
                    if (nowTreeNode.left != null){
                        nextLayer.push(nowTreeNode.left);
                    }
                    if (nowTreeNode.right != null){
                        nextLayer.push(nowTreeNode.right);
                    }
                }else {
                    if (nowTreeNode.right != null){
                        nextLayer.push(nowTreeNode.right);
                    }
                    if (nowTreeNode.left != null){
                        nextLayer.push(nowTreeNode.left);
                    }
                }
            }
            layerNumber += 1;
            result.add(layerList);
            if (!nextLayer.isEmpty()){
                stacks.push(nextLayer);
            }
        }
        return result;
    }
}
