import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Utility {

    public static void printMenu(){
        System.out.println("\n======== Family Balance Records ========\n");
        System.out.println("           1. Show Balance");
        System.out.println("           2.  Add Income");
        System.out.println("           3.  Add Usage");
        System.out.println("           4.    Exit\n");
        System.out.print("Please Enter Your Move(1-4): ");
    }

    public static int ReadMoney(){
        int n;
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.print("Please enter the amount of money: ");
            String str = in.next();
            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("Error Number Input! Please Retry");
            }
        }
        return n;
    }

    public static String ReadReason(){
        Scanner in = new Scanner(System.in);
        String a;

        while(true){
            System.out.print("Please enter the reason: ");
            a = in.next();
            if(a.length() < 20){
                return a;
            }
            else{
                System.out.println("Reason too long, please shorten and retry");
            }
        }
    }

    public static void Enter() throws IOException {
        System.out.print("Press Enter to continue ...");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }


}
