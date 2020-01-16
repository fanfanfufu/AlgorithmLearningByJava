package com.fuqi.year2019.month07.pinduoduo;

import java.util.*;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/28 13:45
 * @Version V1.0
 */
public class Pin3 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int tasckNumber = sc.nextInt();
//        int lines = sc.nextInt();
//        System.out.println("tasckNumber = " + tasckNumber);
//        System.out.println("lines = " + lines);
//        int[] tascks = new int[tasckNumber];
//        for (int i = 0; i < tasckNumber; i++) {
//            int x = sc.nextInt();
//            tascks[i] = x;
//        }
//
//        for (int num: tascks) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
//
//        int[][] dependency = new int[lines][2];
//        for (int i = 0; i < lines; i++) {
//            for (int j = 0; j < 2; j++) {
//                int x = sc.nextInt();
//                dependency[i][j] = x;
//            }
//        }
//
//        for (int i = 0; i < dependency.length; i++) {
//            for (int num : dependency[i]) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
        helper();
    }

    public static void helper(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), eNum = sc.nextInt();
        int[] time = new int[num + 1];
        Map<Integer, Set<Integer>> in = new HashMap<>();
        Map<Integer, Set<Integer>> out = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < num; i++) {
            time[i + 1] = sc.nextInt();
            in.put(i + 1, new HashSet<>());
            out.put(i + 1, new HashSet<>());
        }
        for(int i = 0; i < eNum; i++){
            int to = sc.nextInt(), from = sc.nextInt();
            in.get(to).add(from);
            out.get(from).add(to);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> (time[i1] - time[i2]) );
        for(int i = 1; i <= num; i++){
            if(out.get(i).isEmpty()) {
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            int size = pq.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++){
                int node = pq.poll();
                if(set.contains(node)) {
                    continue;
                }
                set.add(node);
                res.add(node);
                for(int next : in.get(node)){
                    out.get(next).remove(node);
                    if(out.get(next).isEmpty()) {
                        list.add(next);
                    }
                }
            }
            pq.addAll(list);
        }
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
