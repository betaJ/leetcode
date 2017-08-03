/**
 * Created by jiangfeipeng on 2017/8/3.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZag {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        ZigZag z = new ZigZag();
        System.out.println(z.convert(s,3));
    }

    private String convert(String s, int n) {
        String result = "";
        if (n == 1) {
            return s;
        }
        int len = s.length();
        for (int i = 0; i < n; i++) {
            int step1 = (n - i - 1) * 2;
            int step2 = 2 * i;
            int pos = i;
            if(pos < len) {
                result += s.charAt(i);
            }
            while(true) {
                pos += step1;
                if(pos >= len) {
                    break;
                }
                if(step1 != 0)
                    result += s.charAt(pos);
                pos += step2;
                if(pos >= len) {
                    break;
                }
                if(step2 != 0)
                    result += s.charAt(pos);
            }
        }
        return result;
    }
}
