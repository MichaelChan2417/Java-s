package Q815_BusRoute;

import java.util.*;

/**
 * OOM
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> station2Bus = new HashMap<>();

        int n = routes.length;
        // set up the map from station to bus number
        for(int i=0; i<n; i++){
            int[] stations = routes[i];
            for(int station : stations){
                HashSet<Integer> tempSet = station2Bus.getOrDefault(station, new HashSet<>());
                tempSet.add(i);
                station2Bus.put(station, tempSet);
            }
        }

        boolean[] ridden = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> holdq = new LinkedList<>();

        HashSet<Integer> startSet = station2Bus.get(source);
        for(int startBus : startSet){
            q.offer(startBus);
            ridden[startBus] = true;
        }

        int trans = 1;
        boolean flag = false;
        BIG:
        while (!q.isEmpty()){
            int curBus = q.poll();
            int[] nextStation = routes[curBus];

            for(int station : nextStation){
                if (station == target){
                    flag = true;
                    break BIG;
                }
                HashSet<Integer> posBus = station2Bus.get(station);
                for(int bus : posBus){
                    if(!ridden[bus]){
                        holdq.offer(bus);
                    }
                }
            }

            if(q.isEmpty()){
                q = new LinkedList<>(holdq);
                holdq.clear();
                trans++;
            }

        }

        return flag ? trans : -1;
    }
}

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;

        int n = routes.length; // the number of buses
        boolean[][] reach = new boolean[n][n];

        HashMap<Integer, HashSet<Integer>> station2Bus = new HashMap<>();
        // set up the map from station to bus number
        for(int i=0; i<n; i++){
            int[] stations = routes[i];
            for(int station : stations){
                HashSet<Integer> tempSet = station2Bus.getOrDefault(station, new HashSet<>());
                tempSet.add(i);
                station2Bus.put(station, tempSet);
            }
        }

        // construct reach table
        for(int bus : station2Bus.keySet()){
            HashSet<Integer> buses = station2Bus.get(bus);
            Object[] list = buses.toArray();
            if(list.length < 2){
                continue;
            }
            for(int i=0; i<list.length-1; i++){
                for(int j=i+1; j<list.length; j++){
                    int b1 = (Integer) list[i];
                    int b2 = (Integer) list[j];
                    reach[b1][b2] = true;
                    reach[b2][b1] = true;
                }
            }
        }

        boolean[] ridden = new boolean[n];
        // bfs-prework
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> holdq = new LinkedList<>();
        HashSet<Integer> startSet = station2Bus.get(source);
        HashSet<Integer> dstSet = station2Bus.get(target);
        if(dstSet == null || dstSet.isEmpty()) return -1;

        // init bfs queue
        for(int bus : startSet){
            ridden[bus] = true;
            q.offer(bus);
        }

        int ans = 1;
        boolean flag = false;
        while(!q.isEmpty()){
            int curBus = q.poll();

            if(dstSet.contains(curBus)){
                flag = true;
                break;
            }

            for(int i=0; i<n; i++){
                if(reach[curBus][i] && !ridden[i]){
                    holdq.offer(i);
                    ridden[curBus] = true;
                }
            }

            if(q.isEmpty()){
                q = new LinkedList<>(holdq);
                holdq.clear();
                ans++;
            }
        }

        return flag ? ans : -1;
    }
}