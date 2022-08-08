package Q2079_WaterPlants;

public class WaterPlants {
    public int wateringPlants(int[] plants, int capacity) {
        int cur = capacity;
        int steps = 0;

        for(int i=0; i<plants.length;){
            if(cur >= plants[i]){
                steps++;
                cur -= plants[i];
                i++;
                continue;
            }
            steps += 2*i;
            cur = capacity;

        }

        return steps;
    }
}
