package org.example.LeetCode;

public class RodCutting {

    public static void main(String[] args) {
// 		System.out.println("Hello World");
        int[] prices = {2, 5, 7, 8}; //1,2,3,4
        int n = 5;

        int ans = cutRod(prices, n);
        System.out.println(ans);
    }

    public static int cutRod(int[] prices, int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int maxProfit = 0;
            for (int j = 0; j < i; j++) {
                maxProfit = Math.max(maxProfit, prices[j] + dp[i - j - 1]);
            }
            dp[i] = maxProfit;
        }
        return dp[n];
    }
}