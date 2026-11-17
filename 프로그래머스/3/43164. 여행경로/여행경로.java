import java.util.*;

class Solution {
    boolean[] used;
    List<String> route = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0])
            ? a[1].compareTo(b[1])
            : a[0].compareTo(b[0]));
        
        used = new boolean[tickets.length];
        route.add("ICN");
        dfs("ICN", 0, tickets);
        
        return route.toArray(String[]::new);
    }
    
    private boolean dfs(String cur, int count, String[][] tickets) {
        if(count == tickets.length) {
            return true;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            // 아직 방문 안했고 첫번째가 같다면
            if(!used[i] && tickets[i][0].equals(cur)) {
                used[i] = true; // 방문처리
                route.add(tickets[i][1]); // 도착지 루트에 추가

                if(dfs(tickets[i][1], count + 1, tickets)) {
                    return true;
                }

                used[i] = false; // 백트래킹
                route.remove(route.size() - 1);
            }
        }
        
        return false;
    }
}