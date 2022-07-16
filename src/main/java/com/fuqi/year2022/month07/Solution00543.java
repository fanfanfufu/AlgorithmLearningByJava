package com.fuqi.year2022.month07;

import com.fuqi.year2020.TreeNode;

/**
 * @author FuQi
 * @date 2022/7/16 23:27
 * @description
 */
public class Solution00543 {
    int maxd=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }

    /**
     * 任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到
     *
     * @param node
     * @return
     */
    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        maxd=Math.max(Left+Right,maxd);
        //返回节点深度
        return Math.max(Left,Right)+1;
    }
}
