import java.util.Scanner;

public class MakeCounts {
    // This is the function when we count for the digits used in an input number
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int hold = x, digits = 0;

        do{
            digits += 1;
            hold = hold/10;
        }while(hold > 0);

        System.out.println(digits);

    }
}
