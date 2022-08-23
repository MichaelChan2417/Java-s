package Q139_WordSeperate;

import java.util.List;

public class WordSeperate {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        s = " " + s;
        boolean[] smake = new boolean[n+1];

        smake[0] = true;
        for(int i=0; i<=n; i++){
            if(!smake[i]){
                continue;
            }

            for(int j=i+1; j<=n; j++){
                String tempS = s.substring(i+1, j+1);
                if(wordDict.contains(tempS)){
                    smake[j] = true;
                }
            }
        }

        return smake[n];
    }
}
