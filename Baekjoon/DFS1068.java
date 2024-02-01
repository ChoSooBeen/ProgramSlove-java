package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS1068 {
    static ArrayList<Integer>[] tree;
    static int count;
    static int remove;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        count = 0;
        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == -1) {
                root = i;
            }
            else {
                tree[p].add(i);
            }
        }

        remove = Integer.parseInt(br.readLine());
        if(root != remove) {
            dfs(root);
        }
        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int n) {
        boolean flag = false;
        for(int i = 0; i < tree[n].size(); i++) {
            int c = tree[n].get(i);
            if(c != remove) {
                dfs(c);
                flag = true;
            }
        }
        if(!flag){
            count++;
        }
    }
}
