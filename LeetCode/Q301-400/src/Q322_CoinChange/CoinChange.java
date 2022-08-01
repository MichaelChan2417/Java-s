package Q322_CoinChange;

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount == 0) return 0;
        Arrays.sort(coins);
        if(coins[0] > amount){
            return -1;
        }

        int finallen = dpcoin(coins, amount, new int[amount+1]);

        return finallen == Integer.MAX_VALUE ? -1 : finallen;
    }

    public static int dpcoin(int[] coins, int amount, int[] count){
        for(int i=1; i<=amount; i++){
            count[i] = Integer.MAX_VALUE;
            // for each coin, try on
            for(int coin: coins){
                if (i == coin){
                    count[i] = 1;
                    continue;
                }

                if (i > coin && count[i-coin] != Integer.MAX_VALUE){
                    count[i] = Math.min(count[i], count[i-coin] + 1);
                }
            }
        }
        return count[amount];
    }



    public static void main(String[] args) {
        int[] coins = new int[]{186, 419, 83, 408};

        int ans = coinChange(coins, 6249);

        System.out.println(ans);
    }


}
