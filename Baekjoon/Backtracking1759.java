package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backtracking1759 {
    public static StringBuilder sb;
    public static char[] characters;
    public static int l;
    public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        characters = br.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(characters);
        dfs(0, false, 0, 0, "");
        System.out.println(sb);
    }

    /**
     * 암호 추정하기
     * @param count 현재 암호 문자 개수
     * @param flag 모음 포함 여부
     * @param consonant 자음 개수
     * @param idx 탐색할 인덱스
     * @param result 암호문
     */
    public static void dfs(int count, boolean flag, int consonant, int idx, String result) {
        if(count == l) {
            if(flag && consonant > 1) sb.append(result + "\n");
            return;
        }
        for(int i = idx; i < c; i++) {
            if(characters[i] == 'a' || characters[i] == 'e' || characters[i] == 'i' || characters[i] == 'o' || characters[i] == 'u') {
                dfs(count+1, true,  consonant, i+1,result+characters[i]);
            }
            else {
                dfs(count+1, flag, consonant+1, i+1, result+characters[i]);
            }
        }
    }
}