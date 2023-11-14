package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class ROR {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(solution(maps));
        System.out.println(solution(maps2));
    }
    public static int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            if(current[0] == n-1 && current[1] == m-1) {
                answer = current[2];
            }
            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, current[2]+1});
                    }
                }
            }
        }
        return answer;
    }
}
