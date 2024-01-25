package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int high = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        int[] visited = new int[high+1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = 1;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(current == destination) {
                break;
            }

            int u = current + up;
            int d = current - down;

            if(u <= high && visited[u] == 0) {
                visited[u] = visited[current] + 1;
                queue.offer(u);
            }
            if(d > 0 && visited[d] == 0) {
                visited[d] = visited[current] + 1;
                queue.offer(d);
            }
        }

        if(visited[destination] == 0) {
            bw.write("use the stairs");
        }
        else {
            bw.write(visited[destination]-1 + "");
        }

        bw.flush();
        bw.close();
    }
}
