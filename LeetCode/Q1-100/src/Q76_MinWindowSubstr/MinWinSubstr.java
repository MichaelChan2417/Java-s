package Q76_MinWindowSubstr;

import java.util.*;

class MyWrongMinWinSubstr {

    public static String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(n > m) return "";

        // T should contain the set
        Set<Character> T = new LinkedHashSet<Character>();
        for(char c : t.toCharArray()){
            T.add(c);
        }

        // Build a hash map
        HashMap<Character, Queue<Integer>> map = new HashMap<Character, Queue<Integer>>();
        for(int i=0; i<m; i++){
            char c = s.charAt(i);

            if(T.contains(c)){
                Queue<Integer> tempq = map.getOrDefault(c, new LinkedList<Integer>());
                tempq.offer(i);
                map.put(c, tempq);
            }
        }

        // CHECK: judge whether all have
        boolean[] hc = new boolean[m];
        int l = Integer.MAX_VALUE;
        int r = 0;

        for (Character key : T) {
            Queue<Integer> tq = map.get(key);

            if (tq == null || tq.size() == 0) {
                return "";
            }

            int ic = tq.poll();
            hc[ic] = true;
            if(ic > r){
                r = ic;
            }
            if(ic < l){
                l = ic;
            }
        }

        int templ = r - l;
        int start = l;

        while(true){
            int idx = l;
            char cur_char = s.charAt(idx);
            hc[idx] = false;

            Queue<Integer> tq = map.get(cur_char);
            if(tq == null || tq.size() == 0){
                break;
            }
            int next_cur_char = tq.poll();
            if(next_cur_char > r){
                r = next_cur_char;
            }
            hc[next_cur_char] = true;

            while(!hc[idx]){
                idx++;
            }
            l = idx;

            if(r - l < templ){
                start = l;
                templ = r - l;
            }

        }
        // Wrong Ans with "aa" "aa" -> "aa"
        return s.substring(start, start+templ+1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "NB";
        System.out.println(minWindow(s, t));
    }

}


public class MinWinSubstr {

    class Solution {
        Map<Character, Integer> ori = new HashMap<Character, Integer>();
        Map<Character, Integer> cnt = new HashMap<Character, Integer>();

        public String minWindow(String s, String t) {
            int tLen = t.length();
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                ori.put(c, ori.getOrDefault(c, 0) + 1);
            }
            int l = 0, r = -1;
            int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
            int sLen = s.length();
            while (r < sLen) {
                ++r;
                if (r < sLen && ori.containsKey(s.charAt(r))) {
                    cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
                }
                while (check() && l <= r) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        ansL = l;
                        ansR = l + len;
                    }
                    if (ori.containsKey(s.charAt(l))) {
                        cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    ++l;
                }
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR);
        }

        public boolean check() {
            Iterator<Map.Entry<Character, Integer>> iter = ori.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Character key = (Character) entry.getKey();
                Integer val = (Integer) entry.getValue();
                if (cnt.getOrDefault(key, 0) < val) {
                    return false;
                }
            }
            return true;
        }
    }

}