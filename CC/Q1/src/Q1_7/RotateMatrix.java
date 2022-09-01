package Q1_7;

public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // the layer is from the outer going inner
        for(int layer=0; layer<n/2; layer++){
            int first = layer;
            int last = n-1-layer;
            // the range is from (first, first) to (last, last)
            for(int offset = 0; offset<last-first; offset++){
                // save top value
                int top = matrix[first][first+offset];

                // left -> top
                matrix[first][first+offset] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];

                // right -> bottom
                matrix[last][last-offset] = matrix[first+offset][last];

                // top -> right
                matrix[first+offset][last] = top;
            }
        }
    }
}
