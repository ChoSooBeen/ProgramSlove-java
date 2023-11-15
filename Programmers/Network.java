package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 네트워크
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162#
 */
public class Network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, computers));
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }
            visited = bfs(visited, computers, i);
            answer++;
        }
        return answer;
    }

    /**
     * BFS
     * @param visited 방문 여부 저장 배열
     * @param computers 컴퓨터 연결 관계
     * @param s 현재 탐색을 시작할 컴퓨터 번호
     * @return 변경된 visited 배열
     */
    public static boolean[] bfs(boolean[] visited, int[][] computers, int s) {
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.offer(s);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i = 0; i < visited.length; i++) {
                if(current == i || computers[current][i] == 0 || visited[i]) {
                    continue;
                }
                visited[i] = true;
                queue.offer(i);
            }
        }
        return visited;
    }
}
