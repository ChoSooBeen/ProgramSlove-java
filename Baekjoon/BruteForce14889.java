package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BruteForce14889 {
    static int n;
    static int[][] ability;
    static boolean[] visited;
    static int memberNumber;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ability = new int[n][n];
        visited = new boolean[n];
        memberNumber = n / 2;
        min = Integer.MAX_VALUE;
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeTeam(0, 0);
        System.out.println(min);
    }

    static void makeTeam(int count, int idx) {
        if(count == memberNumber) {
            min = Math.min(min, getDiff());
            return;
        }

        if(min == 0) return;

        for(int i = idx; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                makeTeam(count+1, i+1);
                visited[i] = false;
            }
        }
    }

    static int getDiff() {
        int star = 0;
        int link = 0;
        for(int i = 0; i < n-1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(visited[i] && visited[j]) {
                    star += ability[i][j];
                    star += ability[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    link += ability[i][j];
                    link += ability[j][i];
                }
            }
        }
        return Math.abs(star - link);
    }
}
