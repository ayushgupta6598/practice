package org.example.LeetCode;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
       return findTotalWays(coins, amount, coins.length-1);
        
    }
    public int findTotalWays(int[] coins, int amount, int idx){
        if(idx==0){
            return amount%coins[0]==0?1:0;
        }
        int notTake= findTotalWays(coins, amount, idx-1);

        int take= 0;
        if(coins[idx]<=amount){
            take= findTotalWays(coins, amount-coins[idx], idx);
        }
        return Math.min(take,notTake);
    }
}