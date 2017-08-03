/**
 * Created by jiangfeipeng on 2017/8/3.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abba";
        LongestPalindrome p = new LongestPalindrome();
        System.out.println(p.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s,i,i);
            int len2 = expandAroundCenter(s,i,i+1);
            int len = Math.max(len1,len2);
            if (len > end - start) {
                end = i + len / 2;
                start = i - (len - 1 ) / 2;
            }
        }
        return s.substring(start,end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
       int l = left, r = right;
       while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
           l--;r++;
       }
       return  r - l - 1;
    }
}
