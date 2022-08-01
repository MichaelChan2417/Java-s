package Q621_TaskScheduler;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n){
        if(n == 0){
            return tasks.length;
        }

        Map<Character, Integer> schar = new HashMap<Character, Integer>();

        for (char task : tasks) {
            int nums = schar.getOrDefault(task, 0);
            nums++;
            if (nums == 1) {
                schar.put(task, nums);
            } else {
                schar.remove(task);
                schar.put(task, nums);
            }
        }

        int max_single = 0;
        int max_single_count = 0;
        for(char key : schar.keySet()){
            int l = schar.get(key);

            if(l > max_single){
                max_single_count = 1;
                max_single = l;
            }
            else if(l == max_single){
                max_single_count++;
            }

        }


        int base_size = (n+1) * (max_single-1) + 1;
        int empty_space = n * (max_single-1);

        if(tasks.length - max_single - max_single_count + 2 > empty_space){
            return tasks.length;
        }

        return base_size + max_single_count-1;
    }

    public static void main(String[] args) {

        char[] tasks = new char[]{'A', 'B', 'A' ,'B'};

        System.out.println(leastInterval(tasks, 2));
    }
}
