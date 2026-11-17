import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 2배로 늘리기 51 * 2
        int[][] map = new int[102][102];
        
        for(int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2; // 좌표값 2배씩
            int x2 = rect[2] * 2, y2 = rect[3] * 2;
            
            // 바깥은 0, 테두리는 1, 내부는 2로 설정하기
            for(int x = x1; x <= x2; x++) {
                for(int y = y1; y <= y2; y++) {
                    //내부인지 확인
                    boolean inside = x > x1 && x < x2 && y > y1 && y < y2;
                    
                    if(inside) {
                        map[x][y] = 2;
                    } else if(map[x][y] != 2) { // 다른 사각형의 내부가 아니면
                        map[x][y] = 1;
                    }
                }
            }
        }
        
        // 이동 경로
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 시작 지점, 아이템 지점 좌표 2배씩
        int sx = characterX * 2, sy = characterY * 2; 
        int ex = itemX * 2, ey = itemY * 2;
        
        int[][] dist = new int[102][102];
        Queue<int[]> queue = new ArrayDeque<>();
        dist[sx][sy] = 1;
        queue.offer(new int[]{sx, sy});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            
            if(x == ex && y == ey) {
                return (dist[x][y] - 1) / 2; // 1부터 시작했으니 1 빼고 나누기 2
            }
            
            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if(nx < 0 || nx >= 102 || ny < 0 || ny >= 102) {
                    continue;
                }
                if(map[nx][ny] != 1) continue; // 테두리만
                if(dist[nx][ny] != 0) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
        
        return 0;
    }
}