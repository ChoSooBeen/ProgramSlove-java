package Baekjoon;

import java.io.*;
import java.util.*;

public class DFS13023 {

    static ArrayList<Integer>[] friendship;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        friendship = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            friendship[i] = new ArrayList<>();
        }
        flag = false;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            friendship[x].add(y);
            friendship[y].add(x);
        }

        for(int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
            if(flag) {
                break;
            }
        }

        if(flag) {
            bw.write("1");
        }
        else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int c, int count) {
        if(count == 5) {
            flag = true;
            return;
        }
        if(flag) {
            return;
        }
        for(int i : friendship[c]) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, count + 1);
                visited[i] = false;
            }
        }
    }
}
