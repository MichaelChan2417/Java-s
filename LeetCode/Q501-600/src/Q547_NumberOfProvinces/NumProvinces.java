package Q547_NumberOfProvinces;

public class NumProvinces {
    static int[] city;
    static int cur_num = 0;
    public static int findCircleNum(int[][] isConnected){
        int n = isConnected.length; // there are total n cities
        city = new int[n];

        for(int i=0; i<n ; i++){
            if(city[i] == 0){
                cur_num++;
                getconnect(i, isConnected);
            }
        }

        return cur_num;
    }

    public static void getconnect(int i, int[][] isConnected){
        // set the current to be cur_num
        city[i] = cur_num;
        int[] neighbors = isConnected[i];
        for(int j=0; j<neighbors.length; j++){
            if(neighbors[j] == 1 && city[j] == 0){
                getconnect(j, isConnected);
            }
        }
    }

    public static void main(String[] args) {
        int[][] cts = new int[][]{{1,0,0,1},{0,1,0,1},{0,0,1,0},{1,1,0,1}};

        int a = findCircleNum(cts);

        System.out.println(a);
    }
}
