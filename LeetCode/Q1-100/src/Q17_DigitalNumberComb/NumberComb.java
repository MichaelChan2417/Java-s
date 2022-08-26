package Q17_DigitalNumberComb;

import java.util.*;

public class NumberComb {
    public List<String> letterCombinations(String digits) {
        // build the hashmap
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', new ArrayList<Character>(){{add('a');add('b');add('c');}});
        map.put('3', new ArrayList<Character>(){{add('d');add('e');add('f');}});
        map.put('4', new ArrayList<Character>(){{add('g');add('h');add('i');}});
        map.put('5', new ArrayList<Character>(){{add('j');add('k');add('l');}});
        map.put('6', new ArrayList<Character>(){{add('m');add('n');add('o');}});
        map.put('7', new ArrayList<Character>(){{add('p');add('q');add('r');add('s');}});
        map.put('8', new ArrayList<Character>(){{add('t');add('u');add('v');}});
        map.put('9', new ArrayList<Character>(){{add('w');add('x');add('y');add('z');}});

        Queue<StringBuilder> sbq = new LinkedList<>();
        Queue<StringBuilder> holdq = new LinkedList<>();
        StringBuilder sb0 = new StringBuilder("");
        sbq.offer(sb0);

        for(char c : digits.toCharArray()){
            List<Character> nAdds = map.get(c);
            while(!sbq.isEmpty()){
                StringBuilder curSb = sbq.poll();
                for(char nadd : nAdds){
                    curSb.append(nadd);
                    holdq.offer(curSb);
                }

                if(sbq.isEmpty()){
                    sbq = new LinkedList<>(holdq);
                    holdq.clear();
                }
            }
        }

        List<String> ans = new ArrayList<>(sbq.size());
        while (!sbq.isEmpty()){
            String curS = sbq.poll().toString();
            ans.add(curS);
        }

        return ans;
    }
}
