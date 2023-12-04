package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph12851 {
    public static class Node {
        int x, time;
        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if(start >= end) { //만약 수빈이가 동생보다 앞에 있을 경우 뒤로만 가는 방식으로 도착
            System.out.println(start-end);
            System.out.println(1);
            return;
        }
        bfs(start, end);
    }

    /**
     * 최소 시간과 방법의 개수 출력하는 함수
     * @param s 수빈이의 시작 위치
     * @param e 동생이 있는 도착 위치
     */
    public static void bfs(int s, int e) {
        int answer = 0;
        int minTime = Integer.MAX_VALUE;
        int[] visited = new int[100001];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(s, 0));

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if(minTime < current.time) {
                continue;
            }

            if(current.x == e) {
                if(answer == 0) { //BFS는 최단경로를 구하기 때문에 처음에 도달한 경우가 최소 시간
                    minTime = current.time;
                }

                if(current.time == minTime) {
                    answer++;
                    continue;
                }
            }

            int[] next = {current.x-1, current.x+1, current.x*2};
            for(int i = 0; i < 3; i++) {
                if(next[i] < 0 || next[i] > 100000) {
                    continue;
                }

                //0일 경우 방문한 적이 없으므로 현재 시간이 최소 시간
                //현재 정점에 최소시간으로 도달해야 동생의 위치까지 최소로 올수 있는 가능성 존재
                if(visited[next[i]] == 0 || visited[next[i]] == current.time + 1) {
                    visited[next[i]] = current.time + 1;
                    queue.offer(new Node(next[i], current.time+1));
                }
            }
        }

        System.out.println(minTime);
        System.out.println(answer);
    }
}
