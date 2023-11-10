package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 안전지대
 * https://school.programmers.co.kr/learn/courses/30/lessons/120866
 */
public class SafeZone {
    public static void main(String[] args) {
//        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};
//        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        int[][] board = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};
        System.out.println(solution(board));
    }
    public static int solution(int[][] board) {
        int n = board.length;
        int answer = n * n;
        return answer - bfs(board, n);
    }

    /**
     * 위험지대 구하기
     * @param board 지도
     * @param n 지도의 크기
     * @return 위험지대의 개수
     */
    public static int bfs(int[][] board, int n) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    answer++;
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] x = queue.poll();
            for(int i = 0; i < dx.length; i++) {
                int nx = x[0] + dx[i];
                int ny = x[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(!visited[nx][ny] && board[nx][ny] == 0) {
                        answer++;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return answer;
    }
}
