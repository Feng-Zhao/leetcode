package test;


public class Test32 {
    public static void main(String[] args) {
        Solution32 s = new Solution32();
        String str = "(()((())(((";
        System.out.println(s.longestValidParentheses(str));
    }
}

class Solution32 {
    public int longestValidParentheses(String s) {
        if(s.length() < 2){
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        int curPos = 0;
        int curCount = 0;
        for (int i = 1; i < s.length(); i++) {
            curCount = 0;
            // 左括号直接赋值 0;
            if(s.charAt(i) == '('){
                dp[i] = curCount;
            }
            // 右括号
            else {
                // 右括号匹配
                curPos = i - dp[i-1] - 1;
                if(curPos >= 0 && s.charAt(curPos) == '('){
                    curCount += 2;// 基础长度为2
                    curCount += dp[i-1]; // 括号内长度
                    if(i-dp[i-1]-2 >= 0){
                        curCount += dp[i-dp[i-1]-2];
                    }
                    dp[i] = curCount;
                    if(curCount > max){
                        max = curCount;
                    }
                }
                // 右括号不匹配
                else {
                    dp[i] = 0;
                }
            }
        }
        return max;
    }
}