import java.util.Scanner;

public class WenKai {

    public static int GCD(int x, int y){
        int r;
        while(y != 0){
            r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Please Enter x and y: ");
        int x = in.nextInt();
        int y = in.nextInt();

        int gcd = GCD(x, y);

        System.out.println("The gcd of " + x + " and " + y + " is " + gcd);
    };

}
