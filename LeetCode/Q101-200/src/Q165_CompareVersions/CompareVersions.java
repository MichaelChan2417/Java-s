package Q165_CompareVersions;

import java.util.Deque;
import java.util.LinkedList;

public class CompareVersions {
    public int compareVersion(String version1, String version2) {
        Deque<Integer> q1 = new LinkedList<Integer>();
        Deque<Integer> q2 = new LinkedList<Integer>();
        q1.offerLast(0);
        q2.offerLast(0);

        // get v1
        for(char c : version1.toCharArray()){
            if(c == '.'){
                q1.offerLast(0);
                continue;
            }
            int num = q1.pollLast();
            num = num*10 + (c-'0');
            q1.offerLast(num);
        }
        // get v2
        for(char c : version2.toCharArray()){
            if(c == '.'){
                q2.offerLast(0);
                continue;
            }
            int num = q2.pollLast();
            num = num*10 + (c-'0');
            q2.offerLast(num);
        }

        // make same size
        while(q1.size() < q2.size()){
            q1.offerLast(0);
        }
        while(q2.size() < q1.size()){
            q2.offerLast(0);
        }

        // compare
        while(q1.size() > 0){
            int n1 = q1.pollFirst();
            int n2 = q2.pollFirst();

            if(n1 > n2){
                return 1;
            }
            if(n1 < n2){
                return -1;
            }
        }
        return 0;
    }
}
