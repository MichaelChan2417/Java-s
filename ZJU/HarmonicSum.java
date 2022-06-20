import java.util.Scanner;

public class WenKai {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter n: ");
        int n = in.nextInt();

        double ans = 0;
        for(double i=1; i<=n; i++){
            ans += 1/i;
        }

        System.out.println("The harmonic sum is " + ans);
    };

}


public class WenKai {

    public static double ModHarmo(int n){
        double sum = 0;
        for(int i=1; i<=n; i++){
            if(i%2 == 0){
                sum -= 1.0/i;
            }
            else{
                sum += 1.0/i;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please Enter n: ");
        int n = in.nextInt();

        double summ = ModHarmo(n);

        System.out.println("The harmonic sum is " + summ);
    };

}
