import java.util.Scanner;

public class WenKai {

    public static int[] PrimaryTable(int n){
        int[] table = new int[n]; // table is for full contain
        int counts = 0;
        for(int i=1; i<n; i++){
            if(table[i] == 1){
                continue;
            }
            int j = 2;
            counts++;
            while((i+1)*j < n+1){
                table[(i+1)*j - 1] = 1;
                j++;
            }
        }

        int[] ans = new int[counts];
        int cnt = 0;
        for(int i=1; i<n; i++){
            if(table[i] == 0){
                ans[cnt++] = i+1;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please Enter n: ");
        int x = in.nextInt();

        int[] temp = PrimaryTable(x);

        for (int j : temp) {
            System.out.print(j + " ");
        }

    };

}
