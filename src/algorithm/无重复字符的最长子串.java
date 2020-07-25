package algorithm;

import java.util.HashSet;
import java.util.Set;

public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(new 无重复字符的最长子串().lengthOfLongestSubstring2("abcde"));
    }

    /**
     * 暴力for循环
     *
     * @param s 字符串
     * @return 最长无重复字串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        String resultStr = "";
        int moveIndex = 0;
        int result = resultStr.length();
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            if (resultStr.indexOf(s1) == -1) {  //resultStr不含有s1字符
                resultStr += s1;
            } else {
                //有重复字符
                int tempLength = resultStr.length();
                if (tempLength > result) {
                    result = tempLength;
                }
                resultStr = "";
                i = moveIndex;
                moveIndex++;
            }
        }
        return result > resultStr.length() ? result : resultStr.length();
    }

    /**
     * 滑动窗口
     *
     * @param s 字符串
     * @return 最长无重复字串的长度
     */
    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();

        while (r < s.length()) {

            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }

            res = Math.max(res, r - l);  //不是(r-l+1),因为while中r++比实际的r大1

            if (r == s.length()) break;   //当字符串s本身就无重复字符串时，break,无需继续执行

            while (l < r) {
                set.remove(s.charAt(l));
                l++;
                if (s.charAt(l - 1) == s.charAt(r)) break;  //一直移除set中的字符，直到使窗口中的子串合法
            }
        }
        return res;
    }


    //    public int lengthOfLongestSubstring(String s) {
//        char[] arr = s.toCharArray();
//        char[] arr2 = new char[arr.length];
//        int target = 0;
//        for (int i = 0; i < arr.length; i++) {
//            arr2[i] = arr[i];
//            target++;
//            for (int j = 0; j < target; j++) {
//                if (j != 0 && arr2[j-1] == arr[i]) {
//                    return i;
//                }
//            }
//        }
//        return arr.length;
//    }
}