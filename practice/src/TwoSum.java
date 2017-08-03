/**
 * Created by jiangfeipeng on 2017/8/1.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args){
        TwoSum instance = new TwoSum();
        int[] num = {2, 7, 11, 15};
        int target = 15;
        int[] result = instance.twoSum(num, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] num, int target){
        int[] sum = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < num.length; i++) {
            map.put(num[i],i);
            if (map.containsKey(target-num[i])) {
               sum[0] = map.get(target-num[i]);
               sum[1] = i;
            }
        }
        return sum;
    }
}
