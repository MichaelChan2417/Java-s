package Q2105_WateringPlantsII;

public class WaterPlantsII {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int curA = capacityA, curB = capacityB;

        int n = plants.length;
        int i = 0, j = n-1;
        int fills = 0;
        boolean flag;

        while(i < j){
            flag = false;
            if(curA < plants[i]){
                curA = capacityA;
                fills++;
                flag = true;
            }

            if(curB < plants[j]){
                curB = capacityB;
                fills++;
                flag = true;
            }

            if(!flag){
                curA -= plants[i];
                i++;
                curB -= plants[j];
                j--;
            }
        }

        if(i == j){
            if(curA<plants[i] && curB<plants[i]){
                fills++;
            }
        }
        return fills;
    }
}
