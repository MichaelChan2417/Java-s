package Q210_CourseScheduleII;

import java.util.*;

public class CourseScheduleII {

//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//        if(numCourses == 1) return new int[]{0};
//        // considering the in-degree
//        Map<Integer, Integer> Indegree = new HashMap<Integer, Integer>();
//        Map<Integer, HashSet<Integer>> follows = new HashMap<Integer, HashSet<Integer>>();
//        int[] ans = new int[numCourses];
//        int index = 0;
//
//        // Setup In-degree map && follows set
//        for (int[] prerequisite : prerequisites) {
//            int post = prerequisite[0];
//            int pre = prerequisite[1];
//
//            // in-degree modify
//            int ing = Indegree.getOrDefault(pre, -1);
//            if(ing == -1){
//                Indegree.put(pre, 0);
//            }
//            ing = Indegree.getOrDefault(post, -1);
//            if(ing == -1){
//                Indegree.put(post, 1);
//            }
//            else{
//                Indegree.remove(post);
//                Indegree.put(post, ing+1);
//            }
//
//            // mapping modify
//            HashSet<Integer> tp = follows.get(pre);
//            if(tp == null){
//                tp = new HashSet<Integer>(post);
//            }
//            else{
//                tp.add(post);
//                follows.remove(pre);
//
//            }
//            follows.put(pre, tp);
//        }
//
//
//        // Count down the numbers
//        while(Indegree.keySet().size() > 0){
//            for(int i : Indegree.keySet()){
//                int loc_degree = Indegree.get(i);
//                if(loc_degree == 0){
//                    Indegree.remove(i);
//                    ans[index++] = i;
//                    // indegree update
//                    HashSet<Integer> follow_set = follows.get(i);
//                    follows.remove(i);
//                    for(int flw : follow_set){
//                        int updated = Indegree.get(flw);
//                        Indegree.remove(flw);
//                        Indegree.put(flw, updated-1);
//                    }
//                }
//            }
//        }
//
//        return ans;
//    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 1) return new int[]{0};

        // Parameters
        List<List<Integer>> graph = new ArrayList<List<Integer>>();  // show the graph conneciton
        int[] indeg = new int[numCourses];
        int[] ans = new int[numCourses];
        int index = 0;
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }

        // Fill in the upper tables
        for(int[] prerequisite:prerequisites){
            // add the in-degree
            indeg[prerequisite[0]]++;
            // set the directed-path
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // add all nodes in if their in-degree is 0
        for(int i=0; i<numCourses; i++){
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }

        // dealing
        while(!queue.isEmpty()){
            int pre = queue.poll();
            ans[index++] = pre;

            for(int post : graph.get(pre)){
                indeg[post]--;
                if(indeg[post] == 0){
                    queue.offer(post);
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> Indegree = new HashMap<Integer, Integer>();

        Indegree.put(1,2);
        Indegree.put(2,8);
        Indegree.put(3,6);

        for(int i: Indegree.keySet()){
            System.out.println(i);
        }

        System.out.println(Indegree.get(5));
    }

}
