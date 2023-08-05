package com.fuqi.year2023.month08;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/5 22:31
 * @description
 */
public class Solution06990 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        if (purchaseAmount < 5) return 100;
        if (purchaseAmount < 15) return 90;
        if (purchaseAmount < 25) return 80;
        if (purchaseAmount < 35) return 70;
        if (purchaseAmount < 45) return 60;
        if (purchaseAmount < 55) return 50;
        if (purchaseAmount < 65) return 40;
        if (purchaseAmount < 75) return 30;
        if (purchaseAmount < 85) return 20;
        if (purchaseAmount < 95) return 10;

        return 0;
    }

    public int accountBalanceAfterPurchase2(int purchaseAmount) {
        int t=purchaseAmount%10;
        purchaseAmount/=10;
        if (t>=5){
            purchaseAmount++;
        }
        return 100-purchaseAmount*10;
    }


}
