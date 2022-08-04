import java.util.LinkedList;
import java.util.Queue;

public class pressingButtons {

    Queue<StringBuilder> q = new LinkedList<StringBuilder>();
    String[] ans;

    String[] solution(String buttons) {
        if(buttons.length() == 0){
            return new String[]{};
        }
        char[][] dicts = new char[][] {
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };

        StringBuilder sb = new StringBuilder("");
        q.offer(sb);

        for(char c : buttons.toCharArray()){
            char[] cset = dicts[c-'2'];

            int cur_size = q.size();
            for(int i=0; i<cur_size; i++){
                StringBuilder cur_sb = q.poll();
                for(char added_c : cset){
                    StringBuilder nsb = new StringBuilder(cur_sb);
                    nsb.append(added_c);
                    q.offer(nsb);
                }
            }
        }

        ans = new String[q.size()];
        int qsize = q.size();
        for(int i=0; i<qsize; i++){
            ans[i] = q.poll().toString();
        }

        return ans;
    }

}
