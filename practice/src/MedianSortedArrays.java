/**
 * Created by jiangfeipeng on 2017/8/2.
 */

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:
 *      nums1 = [1, 3]
 *      nums2 = [2]
 * The median is 2.
 * Example 2:
 *      nums1 = [1, 2]
 *      nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianSortedArrays {

    public static void main(String[] args) {
        int[] num1 = {1,2,5};
        int[] num2 = {3,4,7,8};
        MedianSortedArrays m = new MedianSortedArrays();
        double d = m.findMedianSortedArrays(num1,num2);
        System.out.println(d);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int max_of_left = 0, min_of_right = 0;
        if (m < n)
            return findMedianSortedArrays(nums2,nums1);
        if (n == 0)
            return (double)(nums1[(m-1)/2]+nums1[m/2])/2;
        int min = 0, max = m, half = (m + n + 1)/2;
        while (min < max) {
            int i = (min + max)/2;
            int j = half - i;
            if (i < m && nums2[j-1] > nums1[i]) {
                min = i + 1;
            }
            else if (i > 0 && nums1[i-1] > nums2[j]) {
                max = i - 1;
            }
            else {
                if (i == 0){
                    max_of_left = nums2[j-1];
                }else if (j == 0){
                    max_of_left = nums1[i-1];
                }else {
                    max_of_left = Math.max(nums1[i-1],nums2[j-1]);
                }
                if ((m + n)%2 == 1) {
                    return max_of_left;
                }
                if (i == m) {
                    min_of_right = nums2[j];
                }else if (j == n) {
                    min_of_right = nums1[i];
                }else {
                    min_of_right = Math.min(nums1[i],nums2[j]);
                }
                return (double)(max_of_left + min_of_right)/2;
            }
        }
        return 0;
    }
}
