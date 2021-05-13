package practice.interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class IndexSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 7};
        int target = 6;
        int[] outputArr = new int[2];

        Map<Integer, Integer> complimentMap = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (complimentMap.containsKey(target - arr[i])) {
                outputArr[0] = complimentMap.get(target - arr[i]);
                outputArr[1] = i;
            }
            complimentMap.putIfAbsent(arr[i], i);
        }
        System.out.println("first val" + outputArr[0] + " second Val : " + outputArr[1]);
    }
}
