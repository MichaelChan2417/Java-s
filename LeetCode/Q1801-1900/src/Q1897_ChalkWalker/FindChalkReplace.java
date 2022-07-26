package Q1897_ChalkWalker;

public class FindChalkReplace {

    public static int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if(chalk[0] > k){
            return 0;
        }
        for(int i=1; i<n; i++){
            chalk[i] += chalk[i-1];
            if(chalk[i] > k){
                return i;
            }
        }

        k = k % chalk[n-1];

        int i = 0, j = n;
        while(i < j){
            int mid = i + (j-i)/2;
            if(chalk[mid] == k){
                return (mid+1)%n;
            }
            else if(chalk[mid] > k){
                j = mid;
            }
            else{
                i = mid + 1;
            }
        }

        if(i == n){
            return 0;
        }
        return i;
    }


    public static void main(String[] args) {

    }
}
