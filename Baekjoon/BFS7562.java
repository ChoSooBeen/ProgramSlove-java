package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS7562 {
    static int[][] dir = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t > 0) {
            t--;
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            bw.write(bfs(n, start, end) + "\n");
        }
        bw.flush();
        bw.close();
    }
    static int bfs(int n, Node start, Node end) {
        int[][] visited = new int[n][n];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(start);
        visited[start.x][start.y] = 1;
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.x == end.x && current.y == end.y) {
                break;
            }
            for(int i = 0; i < 8; i++) {
                int nx = current.x + dir[i][0];
                int ny = current.y + dir[i][1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if(visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[current.x][current.y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        return visited[end.x][end.y]-1;
    }
}
