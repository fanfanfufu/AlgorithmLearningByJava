package com.fuqi.month09.五八同城;

import org.omg.PortableInterceptor.INACTIVE;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * @Description: 二叉树中找出平均值最大的一层，输出层号。并且二叉树不为空，如果有均值相同的，输出大的层号
 * @Author 傅琦
 * @date 2019/9/16 20:37
 * @Version V1.0
 */
public class Solution1 {
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    private Node createBinaryTreeByArray(Integer[] array,int index)
    {
        Node tn = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new Node(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

    public int levelOrder(Node root){
        //请您完成此方法
        int ans = 1, layerNumber = 1;
        double mean = (double) root.val;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                sum += cur.val;
                if (cur.left != null){ queue.offer(cur.left); }
                if (cur.right != null){ queue.offer(cur.right); }
            }
            double tempMean = sum / size;
            if (mean <= tempMean) {
                ans = layerNumber;
                mean = tempMean;
            }
            layerNumber++;
        }

        return ans;
    }


    public  Node createTree(int[] array){
        List<Node> nodeList=new LinkedList<Node>();

        for(int nodeIndex=0;nodeIndex<array.length;nodeIndex++){
            nodeList.add(new Node(array[nodeIndex]));
        }
        for(int parentIndex=0;parentIndex<=array.length/2-1;parentIndex++){
            nodeList.get(parentIndex).left =nodeList.get(parentIndex*2+1);
            //防止是非完全二叉树
            if((parentIndex*2+2)<array.length) {
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
            }
        }
        return nodeList.get(0);
    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int [] array = new int [n];
        Integer [] array = new Integer[n];
        for(int i = 0;i < n;i++){
            String value =scanner.next();
            if(value.equals( "null" )){
                array[i]=null;
            }else{
                array[i] = Integer.valueOf( value );
            }

        }
        Solution1 solution = new Solution1 ();
        Node root =solution.createBinaryTreeByArray(array,0);
        int level = solution.levelOrder( root );
        System.out.println(level);

    }
}
