import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int m = maps[0].length;
        int n = maps.length;
        
        if(maps[0][0] == 0 || maps[n - 1][m - 1] == 0) {
            return -1;
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int[][] dist = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        
        dist[0][0] = 1;
        queue.offer(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            
            if(r == n - 1 && c == m - 1) {
                return dist[r][c];
            }
            
            for(int i = 0; i < dr.length; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                if(maps[nr][nc] == 0) continue;
                if(dist[nr][nc] != 0) continue;
                
                dist[nr][nc] = dist[r][c] + 1;
                
                queue.offer(new int[]{nr, nc});
            }
        }
        
        return -1;
    }
}