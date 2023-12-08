package Baekjoon;

import java.io.*;
import java.util.*;

public class Graph11779 {
    public static class Node implements Comparable<Node>{
        int destination, cost;
        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static int[] preNode; //최단 경로로 올 경우 이전 노드 저장할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Node>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        preNode = new int[n+1];
        bw.write(dijkstra(graph, start, end) + "\n");
        bw.write(trace(start, end));
        bw.flush();
        bw.close();
    }

    /**
     * 다익스트라
     * @param graph 방향 가중치 그래프
     * @param start 시작 정점
     * @param end 도착 정점
     * @return 시작에서 도착까지의 최단 거리
     */
    public static int dijkstra(ArrayList<Node>[] graph, int start, int end){
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> heap = new PriorityQueue<>();
        distance[start] = 0;
        heap.offer(new Node(start, 0));

        while (!heap.isEmpty()) {
            Node current = heap.poll();

            if(distance[current.destination] < current.cost) {
                continue;
            }

            for(Node next : graph[current.destination]) {
                if(distance[next.destination] > distance[current.destination] + next.cost) {
                    distance[next.destination] = distance[current.destination] + next.cost;
                    heap.offer(new Node(next.destination, distance[next.destination]));
                    preNode[next.destination] = current.destination; //경로를 찾기 위한 이전 노드 저장
                }
            }
        }
        return distance[end];
    }

    /**
     * 경로 탐색
     * @param start 시작 정점
     * @param end 도착 정점
     * @return 노드 개수 및 경로 문자열
     */
    public static String trace(int start, int end) {
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int current = end;
        while(preNode[current] != start) {
            current = preNode[current];
            stack.push(current);
        }
        StringBuilder answer = new StringBuilder();
        answer.append(stack.size()+1 + "\n");
        answer.append(start + " ");
        while(!stack.isEmpty()) {
            answer.append(stack.pop() + " ");
        }
        return answer.toString();
    }
}
