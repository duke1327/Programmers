class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for(int[] size : sizes) {
            // 길이 긴 건 가로로, 짧은 건 세로로
            int big = Math.max(size[0], size[1]);
            int small = Math.min(size[0], size[1]);
            
            maxWidth = Math.max(maxWidth, big);
            maxHeight = Math.max(maxHeight, small);
        }
        
        return maxWidth * maxHeight;
    }
}