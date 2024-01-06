package Baekjoon;

import java.io.*;

public class String7490 {
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t > 0) {
            int n = Integer.parseInt(br.readLine());
            DFS(n, 1, "");
            sb.append("\n");
            t--;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    /**
     * 계산 순서 탐색 - 백트래킹
     * @param n 수열의 마지막 값
     * @param c 현재 수
     * @param result 계산식
     */
    public static void DFS(int n, int c, String result) {
        if(n == c) {
            result += c;
            if(calculate(result) == 0) {
                sb.append(result + "\n");
            }
            return;
        }
        DFS(n, c+1, result+c+" ");
        DFS(n, c+1, result+c+"+");
        DFS(n, c+1, result+c+"-");
    }

    /**
     * 계산하기
     * @param result 계산삭
     * @return 계산 결과값
     */
    public static int calculate(String result) {
        int answer = 0;
        result = result.replaceAll(" ", "");

        int tmp = 0;
        boolean flag = true;
        for(int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if(c >= '1' && c <= '9') {
                tmp = tmp * 10 + (c - '0');
            }
            else {
                if(flag) {
                    answer += tmp;
                }
                else {
                    answer -= tmp;
                }

                flag = c == '+' ? true : false;
                tmp = 0;
            }
        }
        if(flag) {
            answer += tmp;
        }
        else {
            answer -= tmp;
        }
        return answer;
    }
}
