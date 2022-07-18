package Q54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();

        int m = matrix.length, n = matrix[0].length;
        int[] view = new int[m*n];
        int mode = 0; // 0 means right, 1 means down, 2 means left, 3 means up
        int step = 0;
        int i=0, j=0; // start point;

        while(step < m*n){
            switch (mode) {
                case 0 -> {
                    while (j < n && view[i * n + j] != 1) {
                        ans.add(matrix[i][j]);
                        view[i * n + j] = 1;
                        j++;
                        step++;
                    }
                    mode = 1;
                    j--;
                    i++;
                }
                case 1 -> {
                    while (i < m && view[i * n + j] != 1) {
                        ans.add(matrix[i][j]);
                        view[i * n + j] = 1;
                        i++;
                        step++;
                    }
                    mode = 2;
                    i--;
                    j--;
                }
                case 2 -> {
                    while (j >= 0 && view[i * n + j] != 1) {
                        ans.add(matrix[i][j]);
                        view[i * n + j] = 1;
                        j--;
                        step++;
                    }
                    mode = 3;
                    j++;
                    i--;
                }
                case 3 -> {
                    while (i >= 0 && view[i * n + j] != 1) {
                        ans.add(matrix[i][j]);
                        view[i * n + j] = 1;
                        i--;
                        step++;
                    }
                    mode = 0;
                    i++;
                    j++;
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] mt = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> ans = spiralOrder(mt);
        System.out.println(ans);
    }
}
