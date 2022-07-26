package Q658_FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {
//Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
//An integer a is closer to x than an integer b if:
// 1. |a-x| < |b-x|
// 2. |a-x| = |b-x| && a < b


    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> fullList = new ArrayList<Integer>();

        for(int i: arr){
            fullList.add(i);
        }

        // if the smallest one is larger than target-X
        if(arr[0] >= x){
            return fullList.subList(0, k);
        }
        // if the largest is smaller than target-X
        if(arr[n-1] <= x){
            return fullList.subList(n-k, n);
        }
        if(k == n){
            return fullList;
        }

        // now the closest should be in the middle
        int l = 0, r = n;
        while(l < r){
            int mid = (l + r)/2;
            if(arr[mid] == x){
                l = mid;
                break;
            }
            else if(arr[mid] > x){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }

        int center = l;
        l = Math.max(0, center-k);
        r = Math.min(n, center+k);

        while( r-l > k ){
            if(Math.abs(x - arr[l]) > Math.abs(x - arr[r-1])){
                l++;
                continue;
            }
            r--;
        }

        return fullList.subList(l, r);
    }



    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};
        int k = 4;
        int x = 4;

        List<Integer> ans = findClosestElements(arr, k, x);
        System.out.println(ans.toString());
    }
}
