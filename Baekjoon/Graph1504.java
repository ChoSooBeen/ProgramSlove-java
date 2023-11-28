package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Graph1504 {
    private static int INF = 200000000; // 오버플로우 방지 - 200000(e의 최댓값) * 1000(c의 최댓값)

    //Comparable : 자기 자신과 매개변수 객체를 비교
    private static class Node implements Comparable<Node> {
        int destination, weight;
        public Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        // 필수 구현 - o : 비교할 객체
        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[n+1]; //인접 리스트를 이용한 그래프
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //양방향 그래프
            graph[x].add(new Node(y, weight));
            graph[y].add(new Node(x, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int answer1 = 0; // 1 > v1 > v2 > n
        answer1 += dijkstra(graph, n, 1, v1);
        answer1 += dijkstra(graph, n, v1, v2);
        answer1 += dijkstra(graph, n, v2, n);

        int answer2 = 0; //1 > v2 > v1 > n
        answer2 += dijkstra(graph, n, 1, v2);
        answer2 += dijkstra(graph, n, v2, v1);
        answer2 += dijkstra(graph, n, v1, n);

        int result = 0;
        if(answer1 >= INF && answer2 >= INF) {
            result = -1;
        }
        else {
            result = Math.min(answer1, answer2);
        }

        System.out.println(result);
    }

    /**
     * 다익스트라
     * @param graph 인접 리스트로 구현한 그래프
     * @param n 정점의 개수
     * @param start 탐색 시작 정점
     * @param end 탐색 마지막 정점
     * @return 시작부터 마지막 정점까지의 최소 거리
     */
    public static int dijkstra(ArrayList<Node>[] graph, int n, int start, int end) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, INF);

        PriorityQueue<Node> heap = new PriorityQueue<>();
        distance[start] = 0;
        heap.offer(new Node(start, 0));

        while(!heap.isEmpty()) {
            Node current = heap.poll();
            if(distance[current.destination] >= current.weight) {
                for(Node next: graph[current.destination]) {
                    if(distance[next.destination] > current.weight + next.weight) {
                        distance[next.destination] = current.weight + next.weight;
                        heap.offer(new Node(next.destination, distance[next.destination]));
                    }
                }
            }
        }
        return distance[end];
    }
}
