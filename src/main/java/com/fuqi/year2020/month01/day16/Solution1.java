package com.fuqi.year2020.month01.day16;

/**
 * @Description:
 * @Author 傅琦
 * @date 2020/1/16 9:54
 * @Version V1.0
 */
public class Solution1 {
    public int[] getNoZeroIntegers(int n) {
        int mid = n / 2;
        int num1, num2;



        if (n % 2 == 0) {
            if (!String.valueOf(mid).contains("0")){
                return new int[]{mid, mid};
            }
            num1 = mid - 1;
            num2 = mid + 1;
        }else {
            num1 = mid;
            num2 = mid + 1;
        }

        while (num1 > 0){
            String str1 = String.valueOf(num1);
            String str2 = String.valueOf(num2);
            if (str1.contains("0") || str2.contains("0")){
                num1--;
                num2++;
            }else {
                break;
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] res = solution1.getNoZeroIntegers(19);
        System.out.print("[");
        for (int num : res) {
            System.out.print(num + ",");
        }
        System.out.print("]");
    }
}
