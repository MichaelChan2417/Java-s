package Q121_BestTimeToSellStock;

public class BestTimeToSell {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] future = new int[n];
        future[n-1] = prices[n-1];

        for(int i=n-2; i>=0; i--){
            if(prices[i] > future[i+1]){
                future[i] = prices[i];
            }
        }

        int temp_max = future[0] - prices[0];
        for(int i=1; i<n; i++){
            if(future[i] - prices[i] > temp_max){
                temp_max = future[i] - prices[i];
            }
        }

        return temp_max;
    }
}
