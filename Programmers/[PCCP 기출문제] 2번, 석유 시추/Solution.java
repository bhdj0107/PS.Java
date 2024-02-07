import java.util.*;

class Solution {
    public int solution(int[][] land) {
        Map<Integer, Integer> hm = new HashMap<>();
        int r = land.length;
        int c = land[0].length;
        
        
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < c; i++) {
            hm.put(i, 0);
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (land[i][j] == 1 && visited[i][j] == false) {
                    Queue<int[]> q = new LinkedList<>();
                    int[] tmp = {i, j};
                    Set<Integer> s = new HashSet<>();
                    
                    q.add(tmp);
                    int cnt = 0;
                    
                    while (!q.isEmpty()) {
                        int[] poped = q.poll();
                        int y = poped[0];
                        int x = poped[1];
                        if (visited[y][x]) continue;
                        else {
                            cnt += 1;
                            visited[y][x] = true;
                            s.add(x);
                            int[] dx = {1, 0, -1, 0};
                            int[] dy = {0, 1, 0, -1};
                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];
                                if (nx >= 0 && nx < c && ny >= 0 && ny < r) {
                                    if (land[ny][nx] == 1) {
                                        int[] ttmp = {ny, nx};
                                        q.add(ttmp);
                                    }
                                }
                                    
                            }
                        }
                    } 
                    for (int cx : s) {
                        int currentCnt = hm.get(cx);
                        hm.put(cx, currentCnt + cnt);
                    }
                }
            }
        }
        
        int maxOil = -1;
        for (int i = 0; i < c; i++) {
            maxOil = Integer.max(maxOil, hm.get(i));
        }
        return maxOil;
    }
}