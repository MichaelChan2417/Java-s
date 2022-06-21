import java.io.IOException;
import java.util.Scanner;

public class FamilyAccount {

    public static void main(String[] args) throws IOException {

        // Parameters pre-setup
        Scanner in = new Scanner(System.in);
        int Money = 10000;  // Init the init-money
        String details = "Type\t\tAmount\t\tBlance\t\tReason\n";

        // Main func should be a loop exit only when confirmed
        // Main Loop:
        MainLoop:
        while(true){

            Utility.printMenu();
            String choice = in.next();

            switch (choice){
                // region case 1
                case "1":
                    System.out.println("\n--------------------------------------------");
                    System.out.println(details);
                    System.out.println("--------------------------------------------");

                    Utility.Enter();
                    break;
                // endregion

                // region case 2
                case "2":{
                    int m = Utility.ReadMoney();
                    Money += m;

                    String rs = Utility.ReadReason();

                    details += "Income\t\t"+m+"\t\t\t"+Money+"\t\t"+rs+"\n";

                    System.out.println("Successfully Added!");
                    Utility.Enter();
                    break;
                }
                // endregion

                case "3":{
                    int m = Utility.ReadMoney();
                    Money -= m;

                    String rs = Utility.ReadReason();

                    details += "Remove\t\t"+m+"\t\t\t"+Money+"\t\t"+rs+"\n";

                    System.out.println("Successfully Added!");
                    Utility.Enter();
                    break;
                }

                case "4":
                    System.out.print("Comfirm to leave(Y/N): ");
                    String c = in.next();

                    if(c.equals("y") || c.equals("Y")) {
                        break MainLoop;
                    }

                default:
                    System.out.println("Wrong Input");
                    System.out.println("Please Re-Enter");
            }

        }

        System.out.println("Exiting!");
    }
}
