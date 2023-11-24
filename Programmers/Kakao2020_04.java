package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 경주로 건설
 * https://school.programmers.co.kr/learn/courses/30/lessons/67259
 */
public class Kakao2020_04 {
    public static class Node { //그래프 노드 클래스
        int r, c, dir, cost;
        public Node(int r, int c, int dir, int cost) {
            this.r = r; //x좌표
            this.c = c; //y좌표
            this.dir = dir; //들어온 방향
            this.cost = cost; //현재까지 필요한 비용
        }
    }

    public static void main(String[] args) {
        int[][] board = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        System.out.println(solution(board));
    }

    /**
     * DP + BFS
     * @param board 경주로 설계 도면
     * @return 비용 최솟값
     */
    public static int solution(int[][] board) {
        int n = board.length;
        int[][] direct = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int[][][] visited = new int[n][n][4]; //3차원 배열
        Queue<Node> queue = new LinkedList<>();

        int min_cost = Integer.MAX_VALUE;
        queue.offer(new Node(0, 0, -1, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.r == n-1 && current.c == n-1) {
                min_cost = Math.min(min_cost, current.cost);
                continue;
            }
            for(int d = 0; d < 4; d++) {
                int x = current.r + direct[d][0];
                int y = current.c + direct[d][1];
                if(x < 0 || x >= n || y < 0 || y >= n || board[x][y] == 1) {
                        continue;
                }
                int nextCost = current.cost;
                if(current.dir == -1 || current.dir == d) {
                    nextCost += 100;
                }
                else {
                    nextCost += 600;
                }
                if(visited[x][y][d] == 0 || visited[x][y][d] > nextCost) {
                    queue.offer(new Node(x, y, d, nextCost));
                    visited[x][y][d] = nextCost;
                }
            }
        }
        return min_cost;
    }
}
