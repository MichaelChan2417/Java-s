package AtGuigu.Project2;

import java.io.*;
import java.util.Scanner;

/*
@author: Michael Chan
@create: 2022-06-23 12:56
*/
public class CMUtility {

    static Scanner in  = new Scanner(System.in);

    // The method use to read input for menu selection
    public static int MenuSelection(){
        int n = 0;

        while(true) {
            System.out.print("Please Enter Your Selection(1-5): ");
            String str = in.next();

            try {
                n = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Error Input! Please Retry");
                continue;
            }

            if(n>=1 && n<=5){
                return n;
            }
            System.out.println("Error Input! Please Retry");
        }
    }

    // The method making Enter IOException
    public static void Enter() throws IOException {
        System.out.print("Press Enter to continue ...");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    // The method used to read legal (ranged) age
    public static int ReadInt(int lowerbound, int higherbound){
        int n = 0;

        while(true){
            System.out.print("Please enter the age: ");
            String str = in.next();
            try {
                n = Integer.parseInt(str);
            }catch (NumberFormatException e){
                System.out.println("Error Number Input! Please Retry");
            }

            if(n>=lowerbound && n<=higherbound){
                return n;
            }
            else{
                System.out.println("Possibly Error Age?");
            }
        }

    }
}
