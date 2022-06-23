package AtGuigu.Project2;

/*
@author: Michael Chan
@create: 2022-06-23 12:56

@Description:
*/

import java.io.*;
import java.util.Scanner;

public class CustomerView {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        CustomerList MyCustomers = new CustomerList(10);

        while(true){
            EnterMenu();

            int MenuChoice = CMUtility.MenuSelection();

            switch (MenuChoice){
                case 1:
                    MyCustomers.AddCustomer();
                    CMUtility.Enter();
                    break;

                case 2:
                    MyCustomers.ModifyCustomer();
                    CMUtility.Enter();
                    break;

                case 3:
                    MyCustomers.DeleteCustomer();
                    CMUtility.Enter();
                    break;

                case 4:
                    MyCustomers.ShowCustomer();
                    CMUtility.Enter();
                    break;

                case 5:
                    ExitMenu();
            }
        }

    }

    public static void EnterMenu(){
        System.out.println("\n==================== Customer Information Management System ====================\n");
        System.out.println("\t\t\t\t\t\t\t\t1 Add Customer");
        System.out.println("\t\t\t\t\t\t\t\t2 Modify Customer");
        System.out.println("\t\t\t\t\t\t\t\t3 Delete Customer");
        System.out.println("\t\t\t\t\t\t\t\t4 View List");
        System.out.println("\t\t\t\t\t\t\t\t5 Exit System");
        System.out.println("================================================================================\n");
    }

    public static void ExitMenu(){

        while (true) {

            System.out.print("Confirm to leave(y/n): ");
            String confirmed = in.next();

            if (confirmed.equals("y") || confirmed.equals("Y")) {
                System.out.println("Successfully Exit!");
                System.exit(0);
            }
            else if (confirmed.equals("n") || confirmed.equals("N")) {
                break;
            }
            else{
                System.out.println("Cannot read your choice. Please Retry!");
            }

        }
    }
}
