package AtGuigu.Project2;

import java.util.Scanner;

/*
@author: Michael Chan
@create: 2022-06-23 12:56

*/
public class CustomerList {

    Scanner in = new Scanner(System.in);

    private Customer[] customers;
    private int totalnumbers;

    // Constructors;
    public CustomerList(){
        this.customers = new Customer[totalnumbers];
    }
    public CustomerList(int n){
        this.totalnumbers = n;
        this.customers = new Customer[totalnumbers];
    }

    // Methods;
    private int FindEmpty(){
        int id = 0;
        for(; id<this.totalnumbers; id++){
            if(this.customers[id] == null){
                return id;
            }
        }
        return -1;
    }

    /**
     * Add one new customer to our list
     */
    public void AddCustomer(){
        Customer cus = new Customer();
        int index = FindEmpty();

        // Set Id
        cus.setId();

        // Set name
        System.out.print("Please enter the name: ");
        String name = in.next();
        cus.setName(name);

        // Set Gender
        while (true){
            System.out.print("Please enter the gender(M/F): ");
            String gend = in.next();
            if(gend.equals("M") || gend.equals("m")){
                cus.setGender("M");
                break;
            }
            else if(gend.equals("F") || gend.equals("f")){
                cus.setGender("F");
                break;
            }
            else{
                System.out.println("Error Input!");
            }
        }

        // Set Age
        int age = CMUtility.ReadInt(0, 100);
        cus.setAge(age);

        // Set Phone
        System.out.print("Please Enter the Phone Number: ");
        String Phonenum = in.next();
        cus.setPhone(Phonenum);

        this.customers[index] = cus;

        System.out.println("Successfully Added!");
    }

    /**
     * Show the customers in the list
     */
    public void ShowCustomer(){
        System.out.println("\n----------------------------- Customer List -----------------------------");
        System.out.println("ID\t\t\tName\t\t\tGender\t\t\tAge\t\t\tPhone");

        for(int i=0; i<this.totalnumbers; i++){
            if(this.customers[i] == null){
                continue;
            }
            System.out.println(customers[i].getId() + "\t\t\t" + customers[i].getName()
                    + "\t\t" + customers[i].getGender() + "\t\t\t" + customers[i].getAge()
                    + "\t\t\t" + customers[i].getPhone());
        }
        System.out.println("\n-------------------------------------------------------------------------\n");
    }

    /**
     * Modify the customer list's info
     */
    public void ModifyCustomer(){
        ShowCustomer();
        // int holdHigh = customers[FindEmpty()].maxid;
        int n = 0;
        int i = 0;

        BIG:
        while(true){
            System.out.print("Please choose the ID: ");
            n = in.nextInt();

            for(i=0; i<this.totalnumbers; i++){
                if(this.customers[i] == null){
                    continue;
                }
                if(customers[i].getId() == n){
                    break BIG;
                }
            }
            if(i == totalnumbers){
                System.out.println("Cannot find the ID!");
            }

        }

        System.out.println("<Press Enter for not changing>");
        /*
         * Start Tracking...
         */
        System.out.print("Name: " + customers[i].getName() + "? ");
        while (true){
            String k = in.next();
            if(k.length() == 0){
                break;
            }
            customers[i].setName(k);
        }

        System.out.print("Gender: " + customers[i].getGender() + "? ");
        while (true){
            String k = in.next();
            if(k.length() == 0){
                break;
            }
            customers[i].setName(k);
        }

        System.out.print("Age: " + customers[i].getAge() + "? ");
        while (true){
            String k = in.nextLine();
            if(k.length() == 0){
                break;
            }
            customers[i].setAge(Integer.parseInt(k));
        }

    }

    /**
     * Delete the customer from list
     */
    public void DeleteCustomer(){
        ShowCustomer();
        int n = 0;
        int i = 0;

        BIG:
        while(true){
            System.out.print("Please choose the ID: ");
            n = in.nextInt();

            for(i=0; i<this.totalnumbers; i++){
                if(this.customers[i] == null){
                    continue;
                }
                if(customers[i].getId() == n){
                    break BIG;
                }
            }
            if(i == totalnumbers){
                System.out.println("Cannot find the ID!");
            }

        }

        System.out.print("Confirm Deletion?(y/n): ");
        String k = in.next();
        if(k.equals("y") || k.equals("Y")){
            customers[i] = null;
            System.out.println("Deletion Finish...");
        }

    }
}
