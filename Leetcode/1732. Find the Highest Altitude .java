class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxHeight = 0;
        for(int i=0; i<gain.length; i++) {
            altitude += gain[i];
            maxHeight = Math.max(maxHeight, altitude);
        }
        return maxHeight;
    }
}