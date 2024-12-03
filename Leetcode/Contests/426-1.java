class Solution {
    public int smallestNumber(int n) {
        int divisor=0;
        while(n>=1) {
            n = n/2;
            divisor++;
        }
        int smallestNumberDec = (int) Math.pow(2,divisor)-1;
        // int answer = 0;
        
        return smallestNumberDec;
        
    }
}