import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        
        int[] dist = new int[n];
        Queue<String> wordQueue = new ArrayDeque<>();
        Queue<Integer> stepQueue = new ArrayDeque<>();
        
        wordQueue.offer(begin);
        stepQueue.offer(0);
        
        while(!wordQueue.isEmpty()) {
            String cur = wordQueue.poll();
            int step = stepQueue.poll();
            
            if(cur.equals(target)) {
                return step;
            }
            
            for(int i = 0; i < n; i++) {
                if(dist[i] != 0) continue;
                if(!changeWord(cur, words[i])) continue;
                
                dist[i] = step + 1;
                wordQueue.offer(words[i]);
                stepQueue.offer(step + 1);
            }
        }
        
        return 0;
    }
    
    private boolean changeWord(String a, String b) {
        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diff++;
                if(diff > 1) return false;
            }
        }
        
        return diff == 1;
    }
}