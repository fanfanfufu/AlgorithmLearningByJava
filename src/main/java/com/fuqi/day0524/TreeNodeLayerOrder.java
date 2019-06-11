package com.fuqi.day0524;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 按层遍历二叉树，每层从左往右输出
 * @Author 傅琦
 * @Date 2019/5/24 11:19
 * @Version V1.0
 */
public class TreeNodeLayerOrder {
    public ArrayList<ArrayList<Integer>> layerOrder(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> layer = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while (!layer.isEmpty()){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if (cur.left != null){
                layer.add(cur.left);
            }
            if (cur.right != null){
                layer.add(cur.right);
            }
            if (start == end){
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<>();
            }
        }
        return result;
    }
}

