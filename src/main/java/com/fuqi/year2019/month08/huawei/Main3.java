package com.fuqi.year2019.month08.huawei;

import java.util.*;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/21 19:00
 * @Version V1.0
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initial = scanner.nextLine();
        int groupQuantities = Integer.valueOf(scanner.nextLine());
        String[] groups = new String[groupQuantities];
        Map<String, Integer> map = new LinkedHashMap<>();
        int index = 0;
        for (int i = 0; i < groupQuantities; i++) {
            groups[i] = scanner.nextLine();
            String[] temp = groups[i].trim().split(",");
            for (String name : temp) {
                if (map.get(name) == null) {
                    map.put(name, index++);
                }
            }
        }

        if (map.get(initial) == null) {
            System.out.println(1);
            return;
        }

        UnionFind unionFind = new UnionFind(index);

        for (int i = 0; i < groupQuantities; i++) {
            String[] names = groups[i].trim().split(",");
            int len = names.length;
            int groupLeader = map.get(names[0]);
            for (int j = 1; j < len; j++) {
                unionFind.union(groupLeader, map.get(names[j]));
            }
        }

        int first = map.get(initial);
        int root = unionFind.find(first);
        int res = unionFind.getUnionSize(root);
        System.out.println(res);

        scanner.close();
    }

    static class UnionFind {
        private int[] parent;
        private int[] weight;

        UnionFind(int num) {
            parent = new int[num];
            weight = new int[num];
            for (int i = 0; i < num; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        int find(int p) {
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }

            return p;
        }

        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot){ return; }

            if (weight[qRoot] < weight[pRoot]) {
                parent[qRoot] = pRoot;
            }else if (weight[qRoot] > weight[pRoot]){
                parent[pRoot] = qRoot;
            }else {
                parent[qRoot] = pRoot;
                weight[pRoot]++;
            }
        }

        int getUnionSize(int root) {
            int count = 0;
            for (int num : parent) {
                if (num == root) {
                    count++;
                }
            }

            return count;
        }
    }
}
