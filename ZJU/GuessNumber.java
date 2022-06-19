public class WenKai {

    public static void main(String[] args){
        // This would randomly generate a number of [1,100], then the Computer would make the guess
        // Output each guess and whether it's smaller or larger.
        int target = (int)(Math.random()*100+1);
        System.out.println("Target is " + target);
        int i=1, j=101;
        int ptr = 0, num_guess=0;

        while(i<j){
            ptr = (i+j)/2;
            num_guess++;
            System.out.println("Making Guess of " + ptr);
            if(ptr < target){
                System.out.println("It's Smaller than Target");
                i = ptr + 1;
            }
            else if(ptr > target){
                System.out.println("It's larger than Target");
                j = ptr;
            }
            else{
                break;
            }
        }
        System.out.println("You make the correct Guess: " + ptr + " of " + num_guess + " times");
    };

}
