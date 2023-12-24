package Baekjoon;

import java.io.*;

public class Recursion12919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();
        System.out.println(solve(s, t));
    }

    public static int solve(String s, String t) {
        if(s.length() == t.length()) {
            if(s.equals(t))
                return 1;
            return 0;
        }

        int answer = 0;
        if(t.charAt(t.length()-1) == 'A') {
            answer += solve(s, t.substring(0, t.length()-1));
        }
        if(t.charAt(0) == 'B') {
            answer += solve(s, new StringBuffer(t.substring(1)).reverse().toString());
        }
        return answer > 0 ? 1 : 0;
    }
}
