public class Study {

    public static int[][] PascalTriangle(int n){

        if(n == 1){
            int [][] Tri = new int[1][1];
            Tri[0][0] = 1;
            return Tri;
        }

        int[][] Tri = new int[n][];
        Tri[0] = new int[]{1};  // first line init

        for(int i=1; i<n; i++){
            Tri[i] = new int[i+1];

            int length = Tri[i].length;

            for(int j=1; j<length-1; j++){
                Tri[i][j] = Tri[i-1][j-1] + Tri[i-1][j];
            }

            Tri[i][0] = 1;
            Tri[i][length-1] = 1;
        }

        return Tri;
    }

    public static void main(String[] args){

        int [][] ans = PascalTriangle(5);
        for(int i=0; i<ans.length; i++){
            for(int j=0; j<ans[i].length; j++){
                System.out.print(ans[i][j] + "-");
            }
            System.out.println();
        }
    }
}
