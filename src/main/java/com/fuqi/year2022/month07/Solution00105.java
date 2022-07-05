package com.fuqi.year2022.month07;

import com.fuqi.year2020.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FuQi
 * @date 2022/7/5 22:12
 * @description
 */
public class Solution00105 {
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return dfsBuild(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * 递归构造的方法
     *
     * @param preorder 前序遍历的数据
     * @param preStart 前序遍历的开始索引
     * @param preEnd 前序遍历的终止索引
     * @param inorder 中序遍历的数据
     * @param inStart 中序遍历的开始索引
     * @param inEnd 中序遍历的截至索引
     * @return treeNode
     */
    private TreeNode dfsBuild(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }
        // 构造根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 找到根节点在中序遍历中的索引位置
        int rootIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        // 计算左子树的节点个数
        int leftCount = rootIndex-inStart;
        // 构造左子树
        root.left = dfsBuild(preorder, preStart+1, preStart+leftCount+1, inorder, inStart, rootIndex);
        // 构造右子树
        root.right = dfsBuild(preorder, preStart+leftCount+1, preEnd, inorder, rootIndex+1, inEnd);

        return root;
    }

    /**
     * 进一步优化：借助HashMap存储节点在中序遍历数组中的索引
     *
     * @param preorder 前序遍历数组
     * @param inorder 中序遍历数组
     * @return 树
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return dfsBuild(preorder, 0, preorder.length, inorder, 0, inorder.length, indexMap);
    }

    /**
     *
     * @param preorder 前序遍历的数据
     * @param preStart 前序遍历的开始索引
     * @param preEnd 前序遍历的终止索引
     * @param inorder 中序遍历的数据
     * @param inStart 中序遍历的开始索引
     * @param inEnd 中序遍历的截至索引
     * @param indexMap 中序遍历节点对应索引的Map
     * @return 树
     */
    private TreeNode dfsBuild(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        if (preStart == preEnd) {
            return null;
        }
        // 构造根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 取出根节点的索引
        Integer rootIndex = indexMap.get(rootVal);
        // 计算左子树的节点个数
        int leftCount = rootIndex-inStart;
        // 构造左子树
        root.left = dfsBuild(preorder, preStart+1, preStart+leftCount+1, inorder, inStart, rootIndex, indexMap);
        // 构造右子树
        root.right = dfsBuild(preorder, preStart+leftCount+1, preEnd, inorder, rootIndex+1, inEnd, indexMap);

        return root;
    }
}
