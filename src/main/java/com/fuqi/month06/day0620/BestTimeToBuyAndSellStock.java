package com.fuqi.month06.day0620;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/6/20 8:56
 * @Version V1.0
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }

        int maxProfit = 0;
        /**
         * 暴力解法：
         * 时间复杂度为O(n^2)
         * 空间复杂度为O(1)
         */
//        for (int i = 0; i < prices.length-1; i++) {
//            for (int j = i+1; j < prices.length; j++) {
//                if (prices[i] < prices[j]){
//                    maxProfit = maxProfit > (prices[j] - prices[i]) ? maxProfit : (prices[j] - prices[i]);
//                }
//            }
//        }

        /**
         * 优化：
         * 时间复杂度为O(n)
         * 空间复杂度O(1)
         */
        int minPrice = Integer.MAX_VALUE;
        for (int price: prices) {
            if (price < minPrice){
                minPrice = price;
            }else {
                maxProfit = maxProfit > (price - minPrice) ? maxProfit : (price - minPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sellStock = new BestTimeToBuyAndSellStock();
        int[] input1 = {7,2,1,5,3,6,4,8};
        int[] input2 = {7,6,4,3,1};
        int res = sellStock.maxProfit(input1);
        System.out.println("res = " + res);
    }
}
