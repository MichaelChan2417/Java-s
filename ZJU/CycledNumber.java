public class Study {

    public static int[][] Cycle_Numbers(int n){

        int [][] hold = new int[n][n];
        int i=0, j=0, cnt=1, doo=0;

        String act = "right";

        do{
            doo = 0;
            switch (act) {
                case "right":
                    while (j < n && hold[i][j] == 0) {
                        hold[i][j] = cnt++;
                        j++;
                        doo++;
                    }
                    j--;
                    i++;  // get to the next place
                    act = "down";
                    break;

                case "down":
                    while (i < n && hold[i][j] == 0) {
                        hold[i][j] = cnt++;
                        i++;
                        doo++;
                    }
                    i--;
                    j--;
                    act = "left";
                    break;

                case "left":
                    while (j >= 0 && hold[i][j] == 0) {
                        hold[i][j] = cnt++;
                        j--;
                        doo++;
                    }
                    j++;
                    i--;
                    act = "up";
                    break;

                case "up":
                    while (i >= 0 && hold[i][j] == 0) {
                        hold[i][j] = cnt++;
                        i--;
                        doo++;
                    }
                    i++;
                    j++;
                    act = "right";
                    break;
            }
        }while(doo>0);

        return hold;
    }

    public static void main(String[] args){

        int [][] ans = Cycle_Numbers(5);
        for(int i=0; i<ans.length; i++){
            for(int j=0; j<ans[i].length; j++){
                System.out.print(ans[i][j] + "-");
            }
            System.out.println();
        }
    }
}
