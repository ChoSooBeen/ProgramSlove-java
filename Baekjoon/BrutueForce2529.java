package Baekjoon;

import java.io.*;
import java.util.ArrayList;

public class BrutueForce2529 {

    static String[] sign;
    static boolean[] visited;
    static ArrayList<String> answers;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        sign = br.readLine().strip().split(" ");

        visited = new boolean[10];
        answers = new ArrayList<>();

        dfs(0, k+1, new int[k+1]);

        bw.write(answers.get(answers.size()-1)+"\n");
        bw.write(answers.get(0));
        bw.flush();
        bw.close();
    }

    static void dfs(int count, int n, int[] result) {
        if(count == n) {
            if(isOk(result)) {
                String t = "";
                for(int i : result) {
                    t += i;
                }
                answers.add(t);
            }
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[count] = i;
                dfs(count+1, n, result);
                visited[i] = false;
            }
        }
    }

    static boolean isOk(int[] result) {
        for(int i = 0; i < sign.length; i++) {
            if(sign[i].equals("<")) {
                if(result[i] > result[i+1]) {
                    return false;
                }
            }
            else {
                if(result[i] < result[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
