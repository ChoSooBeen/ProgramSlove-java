package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 미로탈출
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 */
public class Maze {
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(solution(maps));
    }

    /**
     * 출발점에서 레버를 당긴 후 미로의 출구를 탈출하는데 걸리는 시간
     * @param maps 미로의 상태를 저장한 문자열 배열
     * @return 미로를 탈출하는데 걸리는 시간
     */
    public static int solution(String[] maps) {
        int[] start = new int[2]; //시작점
        int[] labor = new int[2]; //레버의 위치
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                else if(maps[i].charAt(j) == 'L') {
                    labor[0] = i;
                    labor[1] = j;
                }
            }
        }
        int answer = -1;
        int l = bfs(maps, start, 'L'); //출발점에서 레버까지 걸리는 시간
        int e = bfs(maps,labor, 'E'); //레버에서 도착점까지 걸리는 시간
        if(l != -1 && e != -1) { //둘 중 하나라도 도달하지 못하면 탈출 불가능
            answer = l + e;
        }
        return answer;
    }

    /**
     * BFS - 비가중 그래프에서 최단거리 구하기
     * @param maps 미로
     * @param start 시작 좌표
     * @param end 도착지 상태
     * @return 시작점에서 도착점까지의 최단 거리
     */
    public static int bfs(String[] maps, int[] start, char end) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int row = maps.length;
        int col = maps[0].length();

        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        int answer = -1;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            if(maps[current[0]].charAt(current[1]) == end) {
                answer = current[2];
                break;
            }
            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if(maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, current[2]+1});
                    }
                }
            }
        }
        return answer;
    }
}