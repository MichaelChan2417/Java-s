package Q123_SellStockIII;

public class BestSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ToTail = new int[n];
        int[] FromHead = new int[n];

        int curMax = prices[n-1];
        for (int i=n-2; i>=0; i--) {
            if (prices[i] > curMax) {
                curMax = prices[i];
            }
            int curDiff = curMax - prices[i];
            if (curDiff > ToTail[i+1]) {
                ToTail[i] = curDiff;
            }
            else {
                ToTail[i] = ToTail[i+1];
            }
        }

        int curMin = prices[0];
        for (int i=1; i<n; i++) {
            if (prices[i] < curMin) {
                curMin = prices[i];
            }

            int curDiff = prices[i] - curMin;
            if (curDiff > FromHead[i-1]) {
                FromHead[i] = curDiff;
            }
            else {
                FromHead[i] = FromHead[i-1];
            }
        }

        int maxAns = 0;
        for (int i=0; i<n; i++) {
            if (FromHead[i] + ToTail[i] > maxAns) {
                maxAns = FromHead[i] + ToTail[i];
            }
        }

        return maxAns;
    }
}
