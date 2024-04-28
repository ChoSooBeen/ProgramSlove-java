package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph9372 {
    static LinkedList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        while(testcase > 0) {
            testcase--;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new LinkedList[n+1];
            for(int i = 0; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            bw.write(BFS(n) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int count = 0;

        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for(int c : graph[cur]) {
                if(!visited[c]) {
                    visited[c] = true;
                    queue.add(c);
                }
            }
        }

        return count-1;
    }
}
