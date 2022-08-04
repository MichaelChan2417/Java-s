package Q135_Candy;

public class Candy {
    public int candy(int[] ratings){
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n-1] = 1;

        // left trv
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
                continue;
            }
            left[i] = 1;
        }

        // right trv
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1] + 1;
                continue;
            }
            right[i] = 1;
        }

        int summ = 0;
        for(int i=0; i<n; i++){
            summ += Math.max(left[i], right[i]);
        }
        return summ;
    }
}
