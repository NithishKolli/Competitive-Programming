// https://leetcode.com/problems/decode-ways/

class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if(length==0 || s.charAt(0)=='0'){
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        if(length==1){
            return dp[0];
        }
        if(s.charAt(1)!='0'){
            dp[1] = 1;
        }
        else{
            if(dp[0]>2){
                return 0;
            }
            dp[1] = 0;
        }
        int firstTwo = Integer.parseInt(s.substring(0,2));
        if(firstTwo>9 && firstTwo<27){
            dp[1] += 1;
        }
        System.out.println(dp[0]);
        for(int i = 2; i<length; i++){
            if(s.charAt(i)!='0'){
               dp[i] = dp[i-1];
            }
            else{
                dp[i] = 0;
            }
            int doubleDigit = Integer.parseInt(s.substring(i-1,i+1));
            if(doubleDigit>9 && doubleDigit<27){
                System.out.println(i);
                dp[i] += dp[i-2];
            }
        }
        return dp[length-1];
    }
}