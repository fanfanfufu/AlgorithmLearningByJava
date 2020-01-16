package com.fuqi.year2019.month08.beikezhengshipi;

import java.util.Scanner;

/**
 * @Description: 贪心问题
 * @Author 傅琦
 * @date 2019/8/23 19:22
 * @Version V1.0
 */
public class Main3 {
    private static long helper(long capacity, int[] volumes, int[] quantities) {
        long ans = 0;
        for (int i = 0; i < volumes.length; i++) {
            for (int j = quantities[i]; j >= 0; j--) {
                if (capacity - volumes[i] * j >= 0){
                    ans += j;
                    capacity -= j * volumes[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long capacity = scanner.nextLong();
        int[] volumes = new int[n];
        int[] quantities = new int[n];
        for (int i = 0; i < n; i++) {
            quantities[i] = scanner.nextInt();
            volumes[i] = scanner.nextInt();
        }
        System.out.println(helper(capacity, volumes, quantities));

        scanner.close();
    }

//    public static void main(String[] args) {
//
//        // 放每种贝壳的数量
//        List<Integer> num = Arrays.asList(3, 3, 1, 1);
//
//        // 放每种贝壳的体积
//        List<Long> size = Arrays.asList(40L, 6L, 1L, 5L);
//
//        // 总容量
//        long contain = 100L;
//        long remain = contain;
//
//        long number = 0;
//
//        for (int i = 0; i < size.size(); i++) {
//            Long s = size.get(i);
//            long canNum = remain / s;
//            if (canNum > 0) {
//                if (canNum <= num.get(i)) {
//                    remain = remain - canNum * size.get(i);
//                    number = number + canNum;
//                } else {
//                    remain = remain - num.get(i) * s;
//                    number = number + num.get(i);
//                }
//            }
//
//        }
//        System.out.println(number);
//    }

}
