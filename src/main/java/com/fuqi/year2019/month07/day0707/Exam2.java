package com.fuqi.year2019.month07.day0707;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/7/7 10:28
 * @Version: V1.0
 */
public class Exam2 {
    /**
     * 暴力解法，时间复杂度O(n^2)
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] bookdetail: bookings) {
            int start = bookdetail[0] - 1;
            int end = bookdetail[1];
            int seats = bookdetail[2];
            for (int i = start; i < end; i++) {
                if (result[i] + seats < Integer.MAX_VALUE){
                    result[i] += seats;
                }else {
                    result[i] = Integer.MAX_VALUE;
                }
            }
        }
        return result;
    }

    /**
     * O(n)的解法
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] ans = new int[n+1];
        for (int[] bookdetails : bookings) {
            int start = bookdetails[0] - 1;
            int end = bookdetails[1];
            int number = bookdetails[2];
            ans[start] += number;
            ans[end] -= number;
        }

        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i-1];
        }
        int[] res = new int[n];
        System.arraycopy(ans, 0, res, 0, res.length);
        return res;
    }

    public static void main(String[] args) {
        Exam2 exam2 = new Exam2();
        int[][] input = {{1,2,10}, {2,3,20}, {2,5,25}};
        int n = 5;
        int[] res = exam2.corpFlightBookings2(input, n);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
