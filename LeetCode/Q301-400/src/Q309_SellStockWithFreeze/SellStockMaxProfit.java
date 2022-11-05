package Q309_SellStockWithFreeze;

public class SellStockMaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] futureProfit = new int[n];

        for (int i=n-2; i>=0; i--) {
            futureProfit[i] = futureProfit[i+1];
            int curMax = 0;
            // buy in on day-i;
            for (int j=i+1; j<n; j++) {
                // sell on day-j;
                curMax = Math.max(prices[j]-prices[i],0);
                if (j+2 < n) {
                    curMax += futureProfit[j+2];
                }
                if (curMax > futureProfit[i]) {
                    futureProfit[i] = curMax;
                }
            }
        }

        return futureProfit[0];
    }
}
