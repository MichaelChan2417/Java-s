package Q131_PalindromePartition;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    List<String> part;
    List<List<String>> ans;
    boolean[][] ps;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        part = new ArrayList<>();
        int n = s.length();
        ps = new boolean[n][n];

        for(int i=0; i<n; i++){
            ps[i][i] = true;
            for(int j=0; j<i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j == i-1){
                        ps[j][i] = true;
                    }
                    if(j < i-1 && ps[j+1][i-1]){
                        ps[j][i] = true;
                    }
                }
            }
        }

        dfs(s, 0, n);

        return ans;
    }

    public void dfs(String s, int start, int n){
        if (start == n) {
            ans.add(new ArrayList<>(part));
            return;
        }

        for(int i=start; i<n; i++){
            if(ps[start][i]){
                part.add(s.substring(start,i+1));
                dfs(s, i+1, n);
                part.remove(part.size() - 1);
            }
        }
    }
}
