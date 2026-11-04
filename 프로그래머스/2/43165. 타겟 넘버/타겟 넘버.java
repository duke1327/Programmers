class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] numbers, int target, int depth, int current) {
        if(depth == numbers.length) {
            return current == target ? 1 : 0;
        }
        
        int add = dfs(numbers, target, depth + 1, current + numbers[depth]);
        int minus = dfs(numbers, target, depth + 1, current - numbers[depth]);
        
        return add + minus;
    }
}