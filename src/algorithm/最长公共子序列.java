package algorithm;

public class 最长公共子序列 {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(longestCommonSubsequence(s1,s2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int length1 = c1.length;
        int length2 = c2.length;

        int[][] dp = new int[length1+1][length2+1];

        for(int i = 1;i < length1+1;i++){
            for(int j = 1;j < length2+1;j++){
                if(c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[length1][length2];
    }
}
